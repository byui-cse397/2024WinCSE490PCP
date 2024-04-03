package byui.app.linkUp.FrontendSender;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class FrontendSender {

    private static final String BACKEND_URL = "http://ec2-3-92-170-69.compute-1.amazonaws.com"; // Replace this with your backend URL

    public static void sendDataToBackend(String xmlMessage) {
        try {
            URL url = new URL(BACKEND_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/xml");
            connection.setDoOutput(true);

            try (OutputStream outputStream = connection.getOutputStream();
                 OutputStreamWriter writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8)) {
                writer.write(xmlMessage);
            }

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read response from backend
                StringBuilder response = new StringBuilder();
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                }

                // Process the XML response from the backend
                System.out.println("Response from backend: " + response.toString());
                // Here, you might parse the XML response and handle it according to your application's logic

            } else {
                // Handle error response from backend
                System.out.println("Error sending data to backend. Response code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exception
        }
    }

    public static void main(String[] args) {
        // Example XML message construction
        String xmlMessage = "<userLogin>"
                + "<username>john_doe</username>"
                + "<password_hash>password123</password_hash>"
                + "</userLogin>";

        // Send data to backend
        sendDataToBackend(xmlMessage);
    }
}
