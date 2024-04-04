package byui.app.linkUp;

import android.app.Application;

public class LinkUp extends Application {
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}