package byui.app.linkUp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
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

public class EditAccountActivity extends AppCompatActivity {

    EditText usernameEditText, emailEditText, bioEditText;
    TextView usernameTextView, emailTextView, bioTextView;
    Button saveProfileButton, deleteProfileButton;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editaccount);

        usernameEditText = (EditText) findViewById(R.id.editUsname);
        emailEditText = (EditText) findViewById(R.id.cemail);
        bioEditText = (EditText) findViewById(R.id.editTextText3);

        usernameTextView = (TextView) findViewById(R.id.usertitle);
        emailTextView = (TextView) findViewById(R.id.emailtitle);
        bioTextView = (TextView) findViewById(R.id.biotitle);

        saveProfileButton = (Button) findViewById(R.id.sprofile);
        deleteProfileButton = (Button) findViewById(R.id.dprofile);

        fetchUserData();
        setupSaveProfileButton();
        setupDeleteProfileButton();
    }


    private void setupSaveProfileButton() {
        saveProfileButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString();
            String email = emailEditText.getText().toString();
            String bio = bioEditText.getText().toString();

            if (username.isEmpty() || email.isEmpty()) {
                Toast.makeText(EditAccountActivity.this, "Please fill in all required fields", Toast.LENGTH_SHORT).show();
            } else {
                JSONObject postData = new JSONObject();
                try {
                    postData.put("username", username);
                    postData.put("email", email);
                    postData.put("bio", bio);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                new SendDataToServer().execute(postData.toString());
            }
        });
    }

    private void setupDeleteProfileButton() {
        deleteProfileButton.setOnClickListener(v -> {
            // Implement delete logic here
        });
    }

    private void fetchUserData() {
        // Placeholder to fetch user data
    }

    private class SendDataToServer extends AsyncTask<String, Void, Boolean> {

        @Override
        protected Boolean doInBackground(String... strings) {
            HttpURLConnection urlConnection = null;
            try {
                URL url = new URL("#"); // Update with your URL
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
                Toast.makeText(EditAccountActivity.this, "Profile updated successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(EditAccountActivity.this, "Failed to update profile. Please try again later.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
