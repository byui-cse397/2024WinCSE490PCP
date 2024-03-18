package com.linkup.backendconnector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class backendconnector {
    private URI host;

    // Constructor that initializes the backendconnector with the host URL
    public backendconnector(String host) throws URISyntaxException {
        this.host = new URI(host);
    }

    // Method to send a request to the backend server
    public String sendRequest(String message) throws IOException {

        // Convert the host URI to URL
        URL url = host.toURL();

        // Open connection to the URL
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        // Set request method as POST
        conn.setRequestMethod("POST");
        // Set flag to allow output
        conn.setDoOutput(true);

        // Write the message to the output stream of the connection
        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = message.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        // Read the response from the input stream of the connection
        StringBuilder response = new StringBuilder();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), "utf-8"))) {
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
        }

        // Disconnect the connection
        conn.disconnect();

        // Return the response as a string
        return response.toString();
    }
}
