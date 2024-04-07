package byui.app.linkUp;

import android.accounts.Account;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView; // Import TextView instead of EditText
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Toast;

import byui.app.linkUp.R;

import com.google.android.material.bottomnavigation.BottomNavigationView;

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

        BottomNavigationView navView = findViewById(R.id.nav_view);

        Button homeButton = findViewById(R.id.cea);
        Button saveButton = findViewById(R.id.edit_account);

//        navView.setOnNavigationItemSelectedListener(item -> {
//            Intent intent; // Declare a common Intent variable
//            switch (item.getItemId()) {
//                case R.id.posthome:
//                    intent = new Intent(this, PostHomeActivity.class);
//                    startActivity(intent);
//                    break;
//                case R.id.create_post:
//                    intent = new Intent(this, CreatePostActivity.class);
//                    startActivity(intent);
//                    break;
//                case R.id.account_page:
//                    intent = new Intent(this, LoginActivity.class);
//                    startActivity(intent);
//                    break;
//                default:
//                    return false;
//            }
//            finish(); // Optional: if you don't want to recreate the activity if it's already running
//            return true;
//        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open the EditAccountActivity
                Intent intent = new Intent(AccountActivity.this, EditAccountActivity.class);
                startActivity(intent);
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open the PosthomeActivity
                Intent intent = new Intent(AccountActivity.this, PostHomeActivity.class);
                startActivity(intent);
            }
        });
    }


    // Method to get user data from backend server
    private void getDataFromBackend(String email, String bio) {
        String backendUrl = "http://ec2-3-92-170-69.compute-1.amazonaws.com";

        try {
            URL url = new URL(backendUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);


            StringBuilder request = new StringBuilder();

            request.append("<readUser:parent><user_id:int>").append(GlobalUserID.getUserID()).append("</user_id></readUser>");


            // Write request body to connection
            OutputStream os = connection.getOutputStream();
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
        } catch (GlobalUserID.UsernameException e) {
            Toast.makeText(AccountActivity.this, "User Not Recognized. Please Login Again.", Toast.LENGTH_LONG).show();
            // Back out to login screen on failed attempt to pull user data
            Intent intent = new Intent(AccountActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }
}
