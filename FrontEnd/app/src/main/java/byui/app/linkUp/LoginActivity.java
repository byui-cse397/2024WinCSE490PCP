package byui.app.linkUp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import byui.app.linkUp.databinding.LoginBinding;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    // Using View Binding to access the layout's views
    private LoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = LoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // Setup listeners for your buttons
        setupLoginButton();
        setupSignUpButton();
    }

    private void setupLoginButton() {
        binding.signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement your login logic here
                // For example, validate the username and password
                String username = binding.UserNEntry.getText().toString().trim();
                String password = binding.passEntry.getText().toString().trim();

            // Assume a method validateCredentials exists and returns true if the credentials are valid

            TextView signin_error = findViewById(R.id.signin_error);

            if (loginHandler(username, password)) {
                // Start MainActivity on successful login
                Intent intent = new Intent(LoginActivity.this, AccountActivity.class);
                startActivity(intent);
                finish(); // Finish LoginActivity so it's removed from the back stack
            } else {
                // Show error message
                signin_error.setVisibility(View.VISIBLE);
            }
            }
        });
    }

    private void setupSignUpButton() {
        binding.tosignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to SignUpActivity
                // Assume SignUpActivity is another activity you have for users to sign up
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);

            }
        });
    }

    private boolean loginHandler(String username, String password) {
        // Implement your validation logic here
        // This is just a placeholder for demonstration
        return true;
    }
}