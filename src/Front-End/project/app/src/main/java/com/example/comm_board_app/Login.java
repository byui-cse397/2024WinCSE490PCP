package com.example.comm_board_app;

package com.example.comm_board_app;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Login extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        usernameEditText = findViewById(R.id.User_n_entry);
        passwordEditText = findViewById(R.id.pass_entry);
        Button signInButton = findViewById(R.id.signin_button);

        //button actions
        signInButton.setOnClickListener(view -> {
            String username = usernameEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            // Validate input fields
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(Login.this, "Please enter username and password", Toast.LENGTH_SHORT).show();
                return;
            }

            // Perform login
            performLogin(username, password);
        });

        //sends user to the signup page
        Button toSignupButton = findViewById(R.id.tosignup);
        toSignupButton.setOnClickListener(view -> {
            Intent signupIntent = new Intent(Login.this, Signup.class);
            startActivity(signupIntent);
        });
    }

    private void performLogin(String username, String password) {
        // Background thread for HTTP request
        new Thread(() -> {
            try {
                // Create JSON object with username and password
                JSONObject loginData = new JSONObject();
                loginData.put("username", username);
                loginData.put("password", password);

                // URL of your login endpoint
                URL url = new URL("http://yourbackend.com/api/login");
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                try {
                    // Set up connection properties
                    urlConnection.setRequestMethod("POST");
                    urlConnection.setDoOutput(true);
                    urlConnection.setRequestProperty("Content-Type", "application/json");

                    // Write login data to the output stream
                    OutputStream outputStream = urlConnection.getOutputStream();
                    outputStream.write(loginData.toString().getBytes());
                    outputStream.flush();

                    // Read the response
                    InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                    String response = convertInputStreamToString();

                    // Handle response, check if login was successful
                    assert response != null;
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean loginSuccess = jsonResponse.getBoolean("success");
                    if (loginSuccess) {
                        // Start account page activity
                        Intent accountPageIntent = new Intent(Login.this, Accountpage.class);
                        startActivity(accountPageIntent);
                    } else {
                        // Show error message
                        runOnUiThread(() -> Toast.makeText(Login.this, "Login failed, please try again", Toast.LENGTH_SHORT).show());
                    }
                } finally {
                    urlConnection.disconnect();
                }
            } catch (Exception e) {
                e.printStackTrace();
                runOnUiThread(() -> Toast.makeText(Login.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show());
            }
        }).start();
    }

    private String convertInputStreamToString() {
        // Convert InputStream to String
        // Implementation omitted for brevity
        return null;
    }
}
