<<<<<<< HEAD
package com.linkup.user;
=======
package login;
>>>>>>> 9df86f3d6e4a267fcdb6378f141f84af798690c9

public class LoginUser {
    private String username;
    private String password;

    // Constructor
    public LoginUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Method to authenticate the user
    public boolean authenticate() {
        // Check for empty username or password
        if (username.isEmpty() || password.isEmpty()) {
            return false;
        }

        // Check if the provided username and password match the expected values
        return username.equals("user123") && password.equals("password123");
    }
}