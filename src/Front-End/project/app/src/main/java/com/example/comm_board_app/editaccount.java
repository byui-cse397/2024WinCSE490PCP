package com.example.comm_board_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class editaccount extends AppCompatActivity {

    EditText usernameEditText, emailEditText, bioEditText;
    TextView usernameTextView, emailTextView, bioTextView;
    Button saveProfileButton, deleteProfileButton;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editaccount);


        usernameEditText = findViewById(R.id.editUsname);
        emailEditText = findViewById(R.id.cemail);
        bioEditText = findViewById(R.id.editTextText3);

        usernameTextView = findViewById(R.id.usertitle);
        emailTextView = findViewById(R.id.emailtitle);
        bioTextView = findViewById(R.id.biotitle);

        saveProfileButton = findViewById(R.id.sprofile);
        deleteProfileButton = findViewById(R.id.dprofile);

        // Assuming we have a method to fetch user data, populate the fields
        // We will need to implement this based on how our data is stored/retrieved
        fetchUserData();

        saveProfileButton.setOnClickListener(view -> {
            // Get user inputs
            String username = usernameEditText.getText().toString();
            String email = emailEditText.getText().toString();
            String bio = bioEditText.getText().toString();

            // Validate inputs
            if (username.isEmpty() || email.isEmpty()) {
                Toast.makeText(editaccount.this, "Please fill in all required fields", Toast.LENGTH_SHORT).show();
            } else {
                // If inputs are valid, prepare data to send to backend
                JSONObject postData = new JSONObject();
                try {
                    postData.put("username", username);
                    postData.put("email", email);
                    postData.put("bio", bio);
                    // We can add other data here if needed
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                // Send data to backend
                new SendDataToServer().execute(postData.toString());
            }
        });

    }

    private void fetchUserData() {
        // This is a placeholder to fetch user data
    }

    private class SendDataToServer extends AsyncTask<String, Void, Boolean> {

        @Override
        protected Boolean doInBackground(String... strings) {
            HttpURLConnection urlConnection = null;
            try {
                URL url = new URL("#"); // Update with whatever our URL is
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("POST");
                urlConnection.setRequestProperty("Content-Type", "application/json");
                urlConnection.setDoOutput(true);

                OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());
                out.write(strings[0].getBytes());
                out.flush();
                out.close();

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
                Toast.makeText(editaccount.this, "Profile updated successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(editaccount.this, "Failed to update profile. Please try again later.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
