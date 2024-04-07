package byui.app.linkUp;

public class GlobalUserID {
    private static int user_id = -1;
    public static void setUserID(int newUserID) { user_id = newUserID; }

    public static int getUserID() throws UsernameException {
        if (GlobalUserID.user_id == -1) {
            throw new UsernameException("User not found in system.");
        }
        System.out.println("This is the Global Variable: " + user_id);
        return GlobalUserID.user_id;
    }

    static class UsernameException extends Exception {
        public UsernameException(String message) { super(message); }
    }
}

