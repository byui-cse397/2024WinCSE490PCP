package com.example.comm_board_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class deletepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_account);

        Button deletedaccount = findViewById(R.id.yesButton);
        deletedaccount.setOnClickListener(view -> {
            Intent signupIntent = new Intent(deletepage.this, Login.class);
            startActivity(signupIntent);
        });

        Button returntoaccount = findViewById(R.id.noButton);
        returntoaccount.setOnClickListener(view -> {
            Intent signupIntent = new Intent(deletepage.this, Accountpage.class);
            startActivity(signupIntent);
        });
    }
}
