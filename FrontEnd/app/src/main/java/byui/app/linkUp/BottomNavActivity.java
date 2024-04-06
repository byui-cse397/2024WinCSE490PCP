package byui.app.linkUp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_navigation);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.navigation_home) {
                startActivity(new Intent(BottomNavActivity.this, PostHomeActivity.class));
                return true;
            } else if (itemId == R.id.create_post) {
                startActivity(new Intent(BottomNavActivity.this, CreatePostActivity.class));
                return true;
            } else if (itemId == R.id.account_page) {
                startActivity(new Intent(BottomNavActivity.this, AccountActivity.class));
                return true;
            }
            return false;
        });
    }
}