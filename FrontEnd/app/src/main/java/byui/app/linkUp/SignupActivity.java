package byui.app.linkUp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

import byui.app.linkUp.FrontendSender.*;
import byui.app.linkUp.databinding.SignupBinding;

public class SignupActivity extends AppCompatActivity {

    private SignupBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = SignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        gotoLoginButton();

        binding.createAccountButton.setOnClickListener(view -> {
            String email = binding.CEmail.getText().toString();
            String username = binding.CUser.getText().toString();
            String password = binding.CPass.getText().toString();
            String confirmPassword = binding.CPass2x.getText().toString();

            if (email.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(SignupActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            } else if (!password.equals(confirmPassword)) {
                Toast.makeText(SignupActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            } else {
                new AlertDialog.Builder(SignupActivity.this)
                        .setTitle("Confirm Account Creation")
                        .setMessage("Are you sure you want to create this account?")
                        .setPositiveButton("Yes", (dialogInterface, i) -> {
                            new SendDataToServer().execute(email, username, password);
                        })
                        .setNegativeButton("No", null)
                        .show();
            }
        });
    }

    private void gotoLoginButton() {
        binding.toLogin.setOnClickListener(v -> {
            Intent Loginintent = new Intent(SignupActivity.this, LoginActivity.class);
            startActivity(Loginintent);
        });
    }

    private class SendDataToServer extends AsyncTask<String, Void, Boolean> {
        @Override
        protected Boolean doInBackground(String... params) {
            try {
                String email = params[0];
                String username = params[1];
                String password = params[2];
                // Hash the password before sending
                String hashedPassword = HashUtil.hashPassword(password);

                Map<String, String> data = new HashMap<>();
                data.put("email", email);
                data.put("username", username);
                data.put("password_hash", hashedPassword);

                FrontendSender.sendDataToBackend("userCreate", data);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean success) {
            if (success) {
                Toast.makeText(SignupActivity.this, "Account created successfully", Toast.LENGTH_SHORT).show();
                Intent Loginintent = new Intent(SignupActivity.this, PostHomeActivity.class);
                startActivity(Loginintent);

            } else {
                Toast.makeText(SignupActivity.this, "Failed to create account", Toast.LENGTH_SHORT).show();
            }
        }
    }
}