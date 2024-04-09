package byui.app.linkUp;

public class GlobalUserID {
    private static Integer user_id = null;
    public static void setUserID(int newUserID) { user_id = newUserID; }

    public static int getUserID() throws UsernameException {
        if (GlobalUserID.user_id == null) {
            throw new UsernameException("User not found in system.");
        }
        System.out.println("This is the Global Variable: " + user_id);
        return GlobalUserID.user_id;
    }

    static class UsernameException extends Exception {
        public UsernameException(String message) { super(message); }
    }
}

