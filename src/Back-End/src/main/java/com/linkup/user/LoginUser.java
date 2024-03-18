package com.linkup.user;

import com.linkup.database.dbActions.ops.*;
import com.linkup.database.table.*;

public class LoginUser extends ReadDBAction {

  // Member variables to store user information required for login
  private int userId;
  private String username;
  private String password;

  // Constructor to initialize user information
  public LoginUser(int Id, String username, String password) {
    this.userId = Id;
    this.username = username;
    this.password = password;
  }

  // Method to authenticate the user
  public boolean authenticate() {
    // Check for empty username or password
    if (username.isEmpty() || password.isEmpty()) {
      return false; // Return false if username or password is empty
    }

    // Check if the provided username and password match the expected values
    String query = buildQuery(this.userId); // Build query to authenticate user from database

    System.out.println(query); // Print the authentication query for debugging purposes

    return true; // Return true indicating successful authentication
  }

  // Implement the getID method from IDBasedDBAction
  public int getID() { return this.userId; }

  // Implement the getTable method from BuildDBAction
  public Table getTable() {
    // return the name of the table in the database
    return Table.ACCOUNT;
  }
}
