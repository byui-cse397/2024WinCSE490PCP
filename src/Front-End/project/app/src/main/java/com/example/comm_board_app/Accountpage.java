package com.example.comm_board_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Accountpage extends AppCompatActivity {

    // EditText fields for user input
    private EditText usernameEditText;
    private EditText emailEditText;
    private EditText bioEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accountpage);

        // Initialize EditText fields
        usernameEditText = findViewById(R.id.userdisplayer);
        emailEditText = findViewById(R.id.editTextText2);
        bioEditText = findViewById(R.id.editTextText3);

        Button saveButton = findViewById(R.id.button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get user input values
                String username = usernameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String bio = bioEditText.getText().toString();

                // Validate input (you can add your validation logic here)

                // Send data to backend server
                sendDataToBackend(username, email, bio);
            }
        });
    }

    // Method to send user data to backend server
    private void sendDataToBackend(String username, String email, String bio) {
        // You will replace "http://your-backend-url.com/api/endpoint" with your actual backend URL
        String backendUrl = "http://your-backend-url.com/api/endpoint";

        try {
            URL url = new URL(backendUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            // Construct request body
            Map<String, String> postData = new HashMap<>();
            postData.put("username", username);
            postData.put("email", email);
            postData.put("bio", bio);

            StringBuilder requestBody = new StringBuilder();
            for (Map.Entry<String, String> entry : postData.entrySet()) {
                if (requestBody.length() != 0) {
                    requestBody.append("&");
                }
                requestBody.append(entry.getKey()).append("=").append(entry.getValue());
            }

            // Write request body to connection
            OutputStream os = connection.getOutputStream();
            os.write(requestBody.toString().getBytes());
            os.flush();
            os.close();

            // Check response code
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Request was successful, handle response (if any)
            } else {
                // Error handling
            }

            // Close connection
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
            // Error handling
        }
    }
}
