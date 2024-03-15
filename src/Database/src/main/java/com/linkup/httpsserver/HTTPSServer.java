package com.linkup.httpsserver;

import com.linkup.XMLParsing.XMLNode;
import com.linkup.XMLParsing.XMLParser;
import com.linkup.httpsserver.CommandType;
import com.linkup.spark.DatabaseManager;
import com.nimbusds.jose.util.StandardCharset;
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
import java.sql.SQLException;
import java.util.concurrent.Executors;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

public class HTTPSServer {
  private SSLContext context;
  private HttpsServer server; // Make the server a class-level field

  public HTTPSServer(DatabaseManager db) throws Exception {
    // Set up the HTTPS server
    server = HttpsServer.create(new InetSocketAddress(4039), 0);
    // new KeyGen();
    createSSLContext();
    server.setHttpsConfigurator(new HttpsConfigurator(this.context));
    server.createContext("/", new MyHandler(this, db));
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
    private DatabaseManager db;

    public MyHandler(HTTPSServer server, DatabaseManager db) {
      this.server = server;
      this.db = db;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
      String requestMethod = exchange.getRequestMethod();
      String response = "Command received.";
      if (requestMethod.equalsIgnoreCase("POST")) {
        // Parse the XML-like command
        String request = new String(exchange.getRequestBody().readAllBytes(),
                                    StandardCharset.UTF_8);
        XMLParser parser = new XMLParser(request, null);
        XMLNode node = parser.parse();
        CommandType type = CommandType.fromString(node.getTagName());

        switch (type) {
        case SYSTEM:
          if (node.getValue().equals("STOP")) {
            System.out.println("Received STOP command. Stopping server.");
            server.stopServer();
          }
          break;
        case QUERY:
          System.out.println("Received SQL query: " + node.getValue());
          try {
            response = db.executeQueryJDBC(String.valueOf(node.getValue()));
          } catch (SQLException e) {
            e.printStackTrace();
            response = e.toString();
          }
          break;
        case NULL:
          System.out.println("Invalid command received.");
          break;
        }
      }

      // Send a response
      exchange.sendResponseHeaders(200, response.length());
      OutputStream os = exchange.getResponseBody();
      os.write(response.getBytes());
      os.close();
    }
  }

  // Method to stop the server
  public void stopServer() { server.stop(0); }
}
