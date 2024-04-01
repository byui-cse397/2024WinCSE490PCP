package byui.app.linkUp;

import android.annotation.SuppressLint;
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

public class DeleteActivity extends AppCompatActivity {

    // EditText field for reason input
    private EditText reasonEditText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_account);

        // Initialize EditText field
        reasonEditText = findViewById(R.id.reasonEditText);

        Button deleteButton = findViewById(R.id.yesButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get reason for account deletion
                String reason = reasonEditText.getText().toString();
                Intent deleteIntent = new Intent(DeleteActivity.this, LoginActivity.class);
                startActivity(deleteIntent);
                // Validate input (if necessary)

                // Send data to backend server
                sendDataToBackend(reason);
            }
        });

        Button returnButton = findViewById(R.id.noButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate back to Accountpage activity
                Intent accountIntent = new Intent(DeleteActivity.this, AccountActivity.class);
                startActivity(accountIntent);

                // Include popup activity to verify one more time
            }
        });
    }

    // Method to send reason for account deletion to backend server
    private void sendDataToBackend(String reason) {
        // You will replace "http://your-backend-url.com/api/delete_account" with your actual backend URL
        String backendUrl = "http://your-backend-url.com/api/delete_account";

        try {
            URL url = new URL(backendUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            // Construct request body
            Map<String, String> postData = new HashMap<>();
            postData.put("reason", reason);

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
