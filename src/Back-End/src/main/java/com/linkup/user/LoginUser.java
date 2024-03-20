package com.linkup.user;

import com.linkup.database.dbActions.ops.*;
import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.database.table.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginUser extends LoginDBAction {
  // Logger for logging messages
  private static final Logger logger =
      Logger.getLogger(LoginUser.class.getName());

  // Member variables to store user information required for login
  private int userId;
  private String username;
  private String password;
  private String password_hash;

  // Constructor to initialize user information
  public LoginUser(int Id, String username, String password) {
    this.userId = Id;
    this.username = username;
    this.password = password;
    this.password_hash = password;
  }

  // Method to authenticate the user
  public boolean authenticate() {
    // Check for empty username or password
    if (username.isEmpty() || password.isEmpty()) {
      // Log empty username or password
      logger.warning("Empty username or password provided for authentication.");
      return false; // Return false if username or password is empty
    }

    // Check if the provided username and password match the expected values
    // System.out.println(
    // query); // Print the authentication query for debugging purposes

    return true; // Return true indicating successful authentication
  }

  // Implement the getID method from IDBasedDBAction
  public int getID() { return this.userId; }

  @Override
  public Boolean checks() throws FrontEndUsageException {
    return true;
  }

  // Implement the getTable method from BuildDBAction
  public Table getTable() {
    // return the name of the table in the database
    return Table.ACCOUNT;
  }
}
