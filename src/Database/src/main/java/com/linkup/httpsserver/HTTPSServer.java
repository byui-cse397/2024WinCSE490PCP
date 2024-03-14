package com.linkup.httpsserver;

import com.linkup.httpsserver.CommandType;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpsConfigurator;
import com.sun.net.httpserver.HttpsParameters;
import com.sun.net.httpserver.HttpsServer;
import io.netty.handler.ssl.SslContext;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.security.KeyStore;
import java.util.concurrent.Executors;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

public class HTTPSServer {
  private SSLContext context;
  private HttpsServer server; // Make the server a class-level field

  public HTTPSServer() throws Exception {
    // Set up the HTTPS server
    server = HttpsServer.create(new InetSocketAddress(4039), 0);
    createSSLContext();
    server.setHttpsConfigurator(new HttpsConfigurator(this.context));
    server.createContext("/", new MyHandler(this)); // Pass 'this' to MyHandler
    server.setExecutor(Executors.newCachedThreadPool());
    server.start();

    System.out.println(
        "Server started on port 4039. Waiting for STOP command.");
  }

  private void createSSLContext() throws Exception {
    // Load the keystore
    char[] password = "LinkupDBHTTPSServer".toCharArray();
    KeyStore ks = KeyStore.getInstance("JKS");
    FileInputStream fis = new FileInputStream("keystore.jks");
    ks.load(fis, password);

    // Set up the key and trust managers
    KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
    kmf.init(ks, password);
    TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
    tmf.init(ks);

    // Set up the SSL context
    SSLContext sslContext = SSLContext.getInstance("TLS");
    sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
    this.context = sslContext;
  }

  static class MyHandler implements HttpHandler {
    private final HTTPSServer server; // Reference to the HTTPSServer instance

    public MyHandler(HTTPSServer server) { this.server = server; }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
      String requestMethod = exchange.getRequestMethod();
      if (requestMethod.equalsIgnoreCase("POST")) {
        // Parse the XML-like command
        CommandTuple commandTuple =
            parseCommand(exchange.getRequestBody().readAllBytes());
        if (commandTuple != null) {
          CommandType commandType = commandTuple.getCommandType();
          String commandValue = commandTuple.getCommandValue();
          switch (commandType) {
          case SYSTEM:
            if (commandValue.equals("STOP")) {
              System.out.println("Received STOP command. Stopping server.");
              server.stopServer();
            }
            break;
          case QUERY:
            System.out.println("Received SQL query: " + commandValue);
            break;
          case NULL:
            System.out.println("Invalid command received.");
            break;
          }
        } else {
          System.out.println("Invalid command format.");
        }
      }

      // Send a response
      String response = "Command received.";
      exchange.sendResponseHeaders(200, response.length());
      OutputStream os = exchange.getResponseBody();
      os.write(response.getBytes());
      os.close();
    }
  }

  private static CommandTuple parseCommand(byte[] requestBody) {
    String request = new String(requestBody);
    int startTag = request.indexOf("<");
    int endTag = request.indexOf(">");
    if (startTag != -1 && endTag != -1) {
      String tag = request.substring(startTag + 1, endTag);
      int startContent = request.indexOf("<", endTag);
      int endContent = request.indexOf("</", startContent);
      if (startContent != -1 && endContent != -1) {
        String commandType = tag;
        String commandValue = request.substring(startContent + 1, endContent);
        return new CommandTuple(CommandType, commandValue);
      }
    }
    return null;
  }

  // Method to stop the server
  public void stopServer() { server.stop(0); }
}
