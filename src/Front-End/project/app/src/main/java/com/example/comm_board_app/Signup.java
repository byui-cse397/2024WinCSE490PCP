package com.example.comm_board_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Signup extends AppCompatActivity {

    EditText emailEditText, usernameEditText, passwordEditText, confirmPasswordEditText;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        emailEditText = findViewById(R.id.C_email);
        usernameEditText = findViewById(R.id.C_user);
        passwordEditText = findViewById(R.id.C_pass);
        confirmPasswordEditText = findViewById(R.id.C_pass2x);

        //What Happens when you click the button
        Button createAccountButton = findViewById(R.id.createAccountButton);
        createAccountButton.setOnClickListener(view -> {
            // Get user inputs
            String email = emailEditText.getText().toString();
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            String confirmPassword = confirmPasswordEditText.getText().toString();

            // Validate inputs (error handeling)
            if (email.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(Signup.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            } else if (!password.equals(confirmPassword)) {
                Toast.makeText(Signup.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            } else {
                // If inputs are valid, send data to backend
                JSONObject postData = new JSONObject();
                try {
                    postData.put("email", email);
                    postData.put("username", username);
                    postData.put("password", password);
                    // You can add more data as needed
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                // Send data to backend using AsyncTask
                new SendDataToServer().execute(postData.toString());
            }
        });

        // Your code to handle the "Back to Login" button
    }

    private class SendDataToServer extends AsyncTask<String, Void, Boolean> {

        @Override
        protected Boolean doInBackground(String... strings) {
            HttpURLConnection urlConnection = null;
            try {
                // Create URL for your backend endpoint
                URL url = new URL("http://your-backend-url.com/api/signup");

                // Open connection
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("POST");
                urlConnection.setRequestProperty("Content-Type", "application/json");
                urlConnection.setDoOutput(true);

                // Write data to the server
                OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());
                out.write(strings[0].getBytes());
                out.flush();
                out.close();

                // Check server response
                int responseCode = urlConnection.getResponseCode();
                return responseCode == HttpURLConnection.HTTP_OK;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }
        }

        @Override
        protected void onPostExecute(Boolean success) {
            if (success) {
                Toast.makeText(Signup.this, "Account created successfully", Toast.LENGTH_SHORT).show();
                // Redirect to Login activity or any other activity
                startActivity(new Intent(Signup.this, Login.class));
                finish();
            } else {
                Toast.makeText(Signup.this, "Failed to create account. Please try again later.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
