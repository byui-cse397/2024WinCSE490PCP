package byui.app.linkUp;

public class GlobalUserID {
    private static int user_id = -1;
    public static void setUserID(int newUserID) { user_id = newUserID; }

    public static int getUserID() throws UsernameException {
        if (GlobalUserID.user_id == -1) {
            throw new UsernameException("Username has not been set yet.");
        }
        return GlobalUserID.user_id;
    }

    static class UsernameException extends Exception {
        public UsernameException(String message) { super(message); }
    }
}

