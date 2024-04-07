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
import java.util.HashMap;
import java.util.Map;

import byui.app.linkUp.FrontendSender.FrontendSender;

public class EditAccountActivity extends AppCompatActivity {

    EditText usernameEditText, emailEditText, bioEditText;
    TextView usernameTextView, emailTextView, bioTextView;
    Button saveProfileButton, deleteProfileButton, cancelEditButton;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editaccount);

        usernameEditText = (EditText) findViewById(R.id.editUsname);
        emailEditText = (EditText) findViewById(R.id.cemail);
        bioEditText = (EditText) findViewById(R.id.editbio);

        usernameTextView = (TextView) findViewById(R.id.usertitle);
        emailTextView = (TextView) findViewById(R.id.emailtitle);
        bioTextView = (TextView) findViewById(R.id.biotitle);

        saveProfileButton = (Button) findViewById(R.id.sprofile);
        deleteProfileButton = (Button) findViewById(R.id.dprofile);
        cancelEditButton = (Button) findViewById(R.id.cancel_edit);

//        fetchUserData();
        setupSaveProfileButton();
        setupDeleteProfileButton();
        setupCancelEditButton();
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
            Intent intent = new Intent(EditAccountActivity.this, DeleteActivity.class);
            startActivity(intent);
        });
    }

    private void setupCancelEditButton() {
        cancelEditButton.setOnClickListener(v -> {
            // Send the user back to AccountActivity
            Intent intent = new Intent(EditAccountActivity.this, AccountActivity.class);
            startActivity(intent);
            // Optionally, if you don't want the user to come back to this activity on pressing back button from AccountActivity,
            // you can call finish() here to destroy this instance of EditAccountActivity
            finish();
        });
    }

//    private void fetchUserData() {
//        // Placeholder to fetch user data
//    }

    private class SendDataToServer extends AsyncTask<String, Void, Boolean> {
        @Override
        protected Boolean doInBackground(String... params) {
            try {
                String email = params[0];
                String username = params[1];
                String bio = params[2];

                Map<String, String> data = new HashMap<>();
                data.put("email", email);
                data.put("username", username);
                data.put("bio", bio);

                FrontendSender.sendDataToBackend("userCreate", data);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }

        protected void onPostExecute(String result) {
            if (result != null && !result.isEmpty()) {
                Toast.makeText(EditAccountActivity.this, "Profile updated successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(EditAccountActivity.this, AccountActivity.class);
                startActivity(intent);
                finish(); // Optionally finish EditAccountActivity
            } else {
                Toast.makeText(EditAccountActivity.this, "Failed to update profile. Please try again later.", Toast.LENGTH_SHORT).show();
            }
        }

        private String createXmlMessage(String email, String username, String bio) {
            return "<userUpdate>" +
                    "<email>" + email + "</email>" +
                    "<username>" + username + "</username>" +
                    "<bio>" + bio + "</bio>" +
                    "</userUpdate>";
        }
    }
}
