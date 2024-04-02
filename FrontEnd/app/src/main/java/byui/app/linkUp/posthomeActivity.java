package byui.app.linkUp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class posthomeActivity extends AppCompatActivity {

    Button toCreatePostButton, toAccountPageButton, toLogoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.posthome);

        
//        toCreatePostButton = findViewById(R.id.tocreatepost);
//        toAccountPageButton = findViewById(R.id.toaccountpage);
//        toLogoutButton = findViewById(R.id.tologout);

       
        toCreatePostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start create post activity
                Intent intent = new Intent(posthomeActivity.this, createpost.class);
                startActivity(intent);
            }
        });

        
        toAccountPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start account page activity
                Intent intent = new Intent(posthomeActivity.this, AccountActivity.class);
                startActivity(intent);
            }
        });

        
        toLogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start login activity
                Intent intent = new Intent(posthomeActivity.this, LoginActivity.class);
                startActivity(intent);
                // Finish current activity
                finish();
            }
        });
    }
}
