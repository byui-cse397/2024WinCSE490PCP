package byui.app.linkUp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONException;
import org.json.JSONObject;
import byui.app.linkUp.databinding.SignupBinding;

public class SignupActivity extends AppCompatActivity {

    EditText emailEditText, usernameEditText, passwordEditText, confirmPasswordEditText;
    private SignupBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = SignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot()); // Use the View from the binding

        // Now you can directly access the views from the binding object
        gotoLoginButton();

        binding.createAccountButton.setOnClickListener(view -> {
            // Get user inputs
            String email = binding.CEmail.getText().toString();
            String username = binding.CUser.getText().toString();
            String password = binding.CPass.getText().toString();
            String confirmPassword = binding.CPass2x.getText().toString();

            // Validate inputs (error handling)
            if (email.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(SignupActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            } else if (!password.equals(confirmPassword)) {
                Toast.makeText(SignupActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            } else {
                // Show confirmation dialog
                new AlertDialog.Builder(SignupActivity.this)
                        .setTitle("Confirm Account Creation")
                        .setMessage("Are you sure you want to create this account?")
                        .setPositiveButton("Yes", (dialogInterface, i) -> {
                            // User confirmed, proceed with account creation
                            JSONObject postData = new JSONObject();
                            try {
                                postData.put("email", email);
                                postData.put("username", username);
                                postData.put("password", password);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            new SendDataToServer().execute(postData.toString());
                        })
                        .setNegativeButton("No", null)
                        .show();
            }
        });
    }

    private void gotoLoginButton() {
        binding.toLogin.setOnClickListener(v -> {
            // Navigate to LoginActivity
            Intent Loginintent = new Intent(SignupActivity.this, LoginActivity.class);
            startActivity(Loginintent);

        });
    }
    private class SendDataToServer extends AsyncTask<String, Void, Boolean> {
        @Override
        protected Boolean doInBackground(String... strings) {
            return null;
        }
        // AsyncTask implementation remains the same
    }
}
