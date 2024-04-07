package byui.app.linkUp;

import android.app.Application;

public class LinkUpApplication extends Application {
    private LoginActivity loginActivity;
    private String username;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public void setLoginActivity(LoginActivity activity) { this.loginActivity=activity; }
    public LoginActivity getLoginActivity() {return loginActivity; }
}