package com.linkup.frontendConnector;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class FrontendConnector {
  public FrontendConnector() throws IOException {
    HttpServer server =
        HttpServer.create(new java.net.InetSocketAddress(8080), 0);
    server.createContext("/", new MyHandler());
    server.start();
    System.out.println("Server started on port 8080...");
  }

  static class MyHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
      String requestMethod = exchange.getRequestMethod();
      System.out.println("Received " + requestMethod + " request");

      // Read request body
      InputStream requestBody = exchange.getRequestBody();
      StringBuilder requestBodyBuilder = new StringBuilder();
      try (BufferedReader reader = new BufferedReader(
               new InputStreamReader(requestBody, StandardCharsets.UTF_8))) {
        String line;
        while ((line = reader.readLine()) != null) {
          requestBodyBuilder.append(line);
        }
      }
      String requestBodyString = requestBodyBuilder.toString();
      System.out.println("Request body: " + requestBodyString);

      // Prepare response
      String response = "Received " + requestMethod +
                        " request with body: " + requestBodyString;
      exchange.sendResponseHeaders(200, response.length());
      try (OutputStream responseBody = exchange.getResponseBody()) {
        responseBody.write(response.getBytes(StandardCharsets.UTF_8));
      }
    }
  }
}
