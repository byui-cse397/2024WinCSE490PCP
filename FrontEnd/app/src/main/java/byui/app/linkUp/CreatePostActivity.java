package byui.app.linkUp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class CreatePostActivity extends AppCompatActivity {

    EditText createPostTitle;
    EditText createPostBox;
    Button posterButton;
    Button backToHomeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createpost);

        createPostTitle = findViewById(R.id.CreatePostTitle);
        createPostBox = findViewById(R.id.CreatePostBox);
        posterButton = findViewById(R.id.poster);
        backToHomeButton = findViewById(R.id.backtohome);

        posterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the post title and description
                String postTitle = createPostTitle.getText().toString();
                String postDescription = createPostBox.getText().toString();
                // Send data back to PosthomeActivity
                Intent resultIntent = new Intent();
                resultIntent.putExtra("postTitle", postTitle);
                setResult(RESULT_OK, resultIntent);
                // Finish this activity and go back to PosthomeActivity
                finish();
            }
        });

        backToHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish this activity and go back to PosthomeActivity
                finish();
            }
        });
    }
}


