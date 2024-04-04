package byui.app.linkUp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PostHomeActivity extends AppCompatActivity {

    TextView NullPost;
    TextView Postmade;
    Button toAccountButton;
    Button toLoginButton;
    Button createPostButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.posthome);

        NullPost = findViewById(R.id.NullPost);
        Postmade = findViewById(R.id.Postmade);
        toAccountButton = findViewById(R.id.toaccountbutton);
        toLoginButton = findViewById(R.id.tologinbutton);
        createPostButton = findViewById(R.id.Createpostbutton);

        // Initially, set NullPost visible and Postmade invisible
        NullPost.setVisibility(View.VISIBLE);
        Postmade.setVisibility(View.GONE);


        BottomNavigationView navView = findViewById(R.id.nav_view);
//        navView.setOnNavigationItemSelectedListener(item -> {
//            Intent intent;
//            switch (item.getItemId()) {
//                case R.id.navigation_home:
//                    // This is the current activity. No need to start a new one if it's already here.
//                    // intent = new Intent(PostHomeActivity.this, PostHomeActivity.class);
//                    break;
//                case R.id.create_post:
//                    intent = new Intent(PostHomeActivity.this, CreatePostActivity.class);
//                    startActivity(intent);
//                    break;
//                case R.id.loginwelcome:
//                    intent = new Intent(PostHomeActivity.this, LoginActivity.class);
//                    startActivity(intent);
//                    break;
//            }
//            return true;
//        });

        createPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start Createpost activity
                Intent intent = new Intent(PostHomeActivity.this, CreatePostActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        toAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start AccountActivity
                Intent intent = new Intent(PostHomeActivity.this, AccountActivity.class);
                startActivity(intent);
            }
        });

        toLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start LoginActivity
                Intent intent = new Intent(PostHomeActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            // Update Postmade text and visibility
            String postTitle = data.getStringExtra("postTitle");
            Postmade.setText(postTitle);
            Postmade.setVisibility(View.VISIBLE);
            NullPost.setVisibility(View.GONE);
        }
    }
}

