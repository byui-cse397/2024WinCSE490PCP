package com.example.comm_board_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        Button toLogin = findViewById(R.id.createAccountButton);
        toLogin.setOnClickListener(view -> {
            Intent signupIntent = new Intent(Signup.this, Login.class);
            startActivity(signupIntent);
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button toLoginn = findViewById(R.id.retlog);
        toLoginn.setOnClickListener(view -> {
            Intent signupIntent = new Intent(Signup.this, Login.class);
            startActivity(signupIntent);
        });
    }
}
