package com.example.comm_board_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button toSignupButton = findViewById(R.id.tosignup);
        toSignupButton.setOnClickListener(view -> {
            Intent signupIntent = new Intent(Login.this, Signup.class);
            startActivity(signupIntent);
        });

        Button signInButton = findViewById(R.id.signin_button);
        signInButton.setOnClickListener(view -> {
            Intent accountPageIntent = new Intent(Login.this, Accountpage.class);
            startActivity(accountPageIntent);
        });
    }
}
