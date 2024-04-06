package byui.app.linkUp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

import byui.app.linkUp.FrontendSender.FrontendSender;
import byui.app.linkUp.databinding.LoginBinding;

public class LoginActivity extends AppCompatActivity {

  private LoginBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = LoginBinding.inflate(getLayoutInflater());
    View view = binding.getRoot();
    setContentView(view);

    setupLoginButton();
    setupSignUpButton();
  }

  private void setupLoginButton() {
    binding.signinButton.setOnClickListener(v -> {
      String username = binding.UserNEntry.getText().toString().trim();
      String password = binding.passEntry.getText().toString().trim();

      new LoginTask().execute(username, password);
    });
  }

  private void setupSignUpButton() {
    binding.tosignup.setOnClickListener(v -> {
      Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
      startActivity(intent);
    });
  }

  private class LoginTask extends AsyncTask<String, Void, Boolean> {

    @Override
    protected Boolean doInBackground(String... params) {
      try {
        String username = params[0];
        String password = params[1];
        String hashedPassword = HashUtil.hashPassword(password);

        Map<String, String> data = new HashMap<>();
        data.put("username", username);
        data.put("password_hash", hashedPassword);

        FrontendSender.sendDataToBackend("userLogin", data);
      } catch (Exception e) {
        e.printStackTrace();
        return false;
      }
      return true;
    }

    @Override
    protected void onPostExecute(Boolean success) {
      if (success) {
        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(LoginActivity.this, AccountActivity.class);
        startActivity(intent);
        finish();
      } else {
        TextView signin_error = findViewById(R.id.signin_error);
        signin_error.setVisibility(View.VISIBLE);
        Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
      }
    }
  }
}
