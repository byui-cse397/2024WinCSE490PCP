package byui.app.linkUp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class DeleteActivity extends AppCompatActivity {

    private EditText reasonEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_account); // Ensure this matches your layout file name

        reasonEditText = findViewById(R.id.reasonEditText); // Ensure this ID matches in your layout

        Button deleteButton = findViewById(R.id.yesButton);
        deleteButton.setOnClickListener(view -> {
            String reason = reasonEditText.getText().toString().trim();


//            TODO: Figure this out how to send the reason if it's provided
            if (reason != null) {
                // Send reason if it is provided
            }

            sendDataToBackend(reason);

            Intent deleteIntent = new Intent(DeleteActivity.this, LoginActivity.class);
            startActivity(deleteIntent);
        });

        Button returnButton = findViewById(R.id.noButton);
        returnButton.setOnClickListener(view -> new AlertDialog.Builder(DeleteActivity.this)
                .setTitle("Cancel Deletion")
                .setMessage("Are you sure you want to cancel account deletion?")
                .setPositiveButton("Yes", (dialog, which) -> {
                    Intent accountIntent = new Intent(DeleteActivity.this, AccountActivity.class);
                    startActivity(accountIntent);
                })
                .setNegativeButton("No", (dialog, which) -> dialog.dismiss())
                .show());
    }

    private void sendDataToBackend(String reason) {
        String backendUrl = "http://ec2-3-92-170-69.compute-1.amazonaws.com";

        HttpURLConnection connection = null;
        try {
            URL url = new URL(backendUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");

            // Construct XML data
            String xmlData = "<deleteRequest>" +
                    "<reason>" + reason + "</reason>" +
                    "</deleteRequest>";

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = xmlData.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }


            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Account deleted successfully, navigate to login screen
                runOnUiThread(() -> Toast.makeText(DeleteActivity.this, "Account deleted successfully.", Toast.LENGTH_LONG).show());
                Intent toHomeIntent = new Intent(DeleteActivity.this, LoginActivity.class);
                startActivity(toHomeIntent);
            } else {
                // Similarly, switch to UI thread to show error
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // Show an error message using Toast
                        Toast.makeText(DeleteActivity.this, "Failed to delete account. Please try again.", Toast.LENGTH_LONG).show();
                    }
                });
            }

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
            runOnUiThread(() -> Toast.makeText(DeleteActivity.this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show());
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
