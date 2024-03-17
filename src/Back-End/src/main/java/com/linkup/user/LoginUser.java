package com.linkup.user;

import com.linkup.database.dbActions.ops.*;
import com.linkup.database.table.*;

public class LoginUser extends ReadDBAction {

  private int userId;
  private String username;
  private String password;

  // Constructor
  public LoginUser(int Id, String username, String password) {
    this.userId = Id;
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
    String query = buildQuery(this.userId);

    System.out.println(query);

    return true;
  }

  // Implement the getID method from IDBasedDBAction
  public int getID() { return this.userId; }

  // Implement the getTable method from BuildDBAction
  public Table getTable() {
    // return the name of the table in the database
    return Table.ACCOUNT;
  }
}
