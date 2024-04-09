package byui.app.linkUp.FrontendSender;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import byui.app.linkUp.GlobalUserID;

public class FrontendSender {

    private static final String BACKEND_URL = "http://ec2-3-92-170-69.compute-1.amazonaws.com";

    public static void sendLoginAttemptBackend(String actionType, Map<String, String> data) {
        // TODO: REMOVE SYSTEM MESSAGE BEFORE PUBLISHING
        System.out.println(data);
        String xmlMessage = createXmlMessage(actionType, data);
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
                GlobalUserID.setUserID(Integer.parseInt(response.toString()));

            } else {
                // Handle error response from backend
                System.out.println("Error sending data to backend. Response code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exception
        }
    }

    public static void sendDataToBackend(String actionType, Map<String, String> data) {
        // TODO: REMOVE SYSTEM MESSAGE BEFORE PUBLISHING
        System.out.println(data);
        String xmlMessage = createXmlMessage(actionType, data);
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

                // Process the XML response from the backend, outside of logging in this should be the
                // number of rows that were affected in the SQL tables
                System.out.println("Response from backend: " + response.toString());

            } else {
                // Handle error response from backend
                System.out.println("Error sending data to backend. Response code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exception
        }
    }

    public static void getDataFromBackend() {
//        int user_id = GlobalUserID.getUserID();
//        System.out.println(user_id);
//        String xmlMessage = createXmlMessage();
        try {
            URL url = new URL(BACKEND_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/xml");
            connection.setDoOutput(true);

//            try (OutputStream outputStream = connection.getOutputStream();
//                 OutputStreamWriter writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8)) {
//                writer.write(xmlMessage);
//            }

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
            } else {
                // Handle error response from backend
                System.out.println("Error sending data to backend. Response code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exception
        }
    }

    private static String createXmlMessage(String actionType, Map<String, String> data) {
        StringBuilder xml = new StringBuilder("<" + actionType + ":parent>");
        data.forEach((key, value) -> xml.append("<").append(key).append(":").append(data.getClass().getName().toLowerCase()).append(">").append(value).append("</").append(key).append(">"));
        xml.append("</").append(actionType).append(">");
        return xml.toString();
    }


//    public static void main(String[] args) {
//        Map<String, String> data = new HashMap<>();
//        data.put("username", "john_doe");
//        data.put("password_hash", "password123");
//        data.put("post_text", "post example");
//        data.put("community_name", "community");
//        data.put("email", "email@email.com");
//
//        //Defined on each page with a static key
//        sendDataToBackend("userLogin", data);
//    }
}
