package byui.app.linkUp;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView; // Import TextView instead of EditText
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class AccountActivity extends AppCompatActivity {

    // TextView fields for displaying user information
    private TextView usernameTextView;
    private TextView emailTextView;
    private TextView bioTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accountpage);

        // Initialize TextView fields
        usernameTextView = findViewById(R.id.usnView);
        emailTextView = findViewById(R.id.textView2);
        bioTextView = findViewById(R.id.bioView);



        Button cancelButton = findViewById(R.id.cea); // Assuming this is the cancel button
        Button saveButton = findViewById(R.id.edit_account); // Corrected ID for save button

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open the EditAccountActivity
                Intent intent = new Intent(AccountActivity.this, EditAccountActivity.class);
                startActivity(intent);
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open the PosthomeActivity
                Intent intent = new Intent(AccountActivity.this, PostHomeActivity.class);
                startActivity(intent);
            }
        });
    }


    // Method to send user data to backend server
    private void sendDataToBackend(String username, String email, String bio) {
        String backendUrl = "http://ec2-3-92-170-69.compute-1.amazonaws.com";

        try {
            URL url = new URL(backendUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            // Construct request body
            // In future iterations, this should include user_id for the request
            Map<String, String> postData = new HashMap<>();
            postData.put("username", "username");
            postData.put("email", email);
            // postData.put("bio", bio);

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
            // Request was successful, handle response (if any)
            // Error handling

            // Close connection
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
            // Error handling
        }
    }
}
