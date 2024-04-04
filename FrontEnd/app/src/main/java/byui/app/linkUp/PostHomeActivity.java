package byui.app.linkUp;

//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//import androidx.appcompat.app.AppCompatActivity;
//
//public class PostHomeActivity extends AppCompatActivity {
//
//    TextView NullPost;
//    TextView Postmade;
//    Button toAccountButton;
//    Button toLoginButton;
//    Button createPostButton;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.posthome);
//
//        NullPost = findViewById(R.id.NullPost);
//        Postmade = findViewById(R.id.Postmade);
//        toAccountButton = findViewById(R.id.toaccountbutton);
//        toLoginButton = findViewById(R.id.tologinbutton);
//        createPostButton = findViewById(R.id.Createpostbutton);
//
//        // Initially, set NullPost visible and Postmade invisible
//        NullPost.setVisibility(View.VISIBLE);
//        Postmade.setVisibility(View.GONE);
//
//        createPostButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Start Createpost activity
//                Intent intent = new Intent(PostHomeActivity.this, CreatePostActivity.class);
//                startActivityForResult(intent, 1);
//            }
//        });
//
//        toAccountButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Start AccountActivity
//                Intent intent = new Intent(PostHomeActivity.this, AccountActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        toLoginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Start LoginActivity
//                Intent intent = new Intent(PostHomeActivity.this, LoginActivity.class);
//                startActivity(intent);
//            }
//        });
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 1 && resultCode == RESULT_OK) {
//            // Update Postmade text and visibility
//            String postTitle = data.getStringExtra("postTitle");
//            Postmade.setText(postTitle);
//            Postmade.setVisibility(View.VISIBLE);
//            NullPost.setVisibility(View.GONE);
//        }
//    }
//}
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public class PostHomeActivity extends AppCompatActivity {

    TextView NullPost;
    TextView Postmade;
    TextView temppostTitle;
    Button toAccountButton;
    Button toLoginButton;
    Button createPostButton;
    int postCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.posthome);

        NullPost = findViewById(R.id.NullPost);
        Postmade = findViewById(R.id.Postmade);
        temppostTitle = findViewById(R.id.tempostTitle);
        toAccountButton = findViewById(R.id.toaccountbutton);
        toLoginButton = findViewById(R.id.tologinbutton);
        createPostButton = findViewById(R.id.Createpostbutton);

        // Initially, set NullPost visible and Postmade/temppostTitle invisible
        NullPost.setVisibility(View.VISIBLE);
        Postmade.setVisibility(View.GONE);
        temppostTitle.setVisibility(View.GONE);

        createPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start CreatePost activity
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
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            // Get the post title and description from the result intent
            String postTitle = data.getStringExtra("postTitle");
            String postDescription = data.getStringExtra("postDescription");

            // Update Postmade text and visibility
            if (postCounter == 0) {
                Postmade.setText(postTitle);
                Postmade.setVisibility(View.VISIBLE);
            } else {
                // Create new TextView for duplicated post title
                TextView newPostTitle = new TextView(this);
                newPostTitle.setLayoutParams(Postmade.getLayoutParams());
                newPostTitle.setText(postTitle);
                newPostTitle.setTextSize(Postmade.getTextSize());
                newPostTitle.setTextAlignment(Postmade.getTextAlignment());
                newPostTitle.setBackground(Postmade.getBackground());
                ((ConstraintLayout) findViewById(R.id.posthome)).addView(newPostTitle);


                // Adjust constraints for new post title
                ConstraintSet constraintSet = new ConstraintSet();
                constraintSet.clone((ConstraintLayout) findViewById(R.id.posthome));
                constraintSet.connect(newPostTitle.getId(), ConstraintSet.START, R.id.Postmade, ConstraintSet.START, 0);
                constraintSet.connect(newPostTitle.getId(), ConstraintSet.TOP, R.id.Postmade, ConstraintSet.BOTTOM, 15);
                constraintSet.applyTo((ConstraintLayout) findViewById(R.id.posthome));
            }

            // Update temppostTitle text and visibility
            if (postCounter == 0) {
                temppostTitle.setText(postDescription);
                temppostTitle.setVisibility(View.VISIBLE);
            } else {
                // Create new TextView for duplicated post description
                TextView newPostDescription = new TextView(this);
                newPostDescription.setLayoutParams(temppostTitle.getLayoutParams());
                newPostDescription.setText(postDescription);
                newPostDescription.setTextSize(temppostTitle.getTextSize());
                newPostDescription.setTextAlignment(temppostTitle.getTextAlignment());
                newPostDescription.setBackground(temppostTitle.getBackground());
                ((ConstraintLayout) findViewById(R.id.posthome)).addView(newPostDescription);


                // Adjust constraints for new post description
                ConstraintSet constraintSet = new ConstraintSet();
                constraintSet.clone((ConstraintLayout) findViewById(R.id.posthome));
                constraintSet.connect(newPostDescription.getId(), ConstraintSet.START, R.id.tempostTitle, ConstraintSet.START, 0);
                constraintSet.connect(newPostDescription.getId(), ConstraintSet.TOP, R.id.tempostTitle, ConstraintSet.BOTTOM, 15);
                constraintSet.applyTo((ConstraintLayout) findViewById(R.id.posthome));
            }

            // Hide NullPost
            NullPost.setVisibility(View.GONE);

            // Increment postCounter
            postCounter++;
        }
    }
}

