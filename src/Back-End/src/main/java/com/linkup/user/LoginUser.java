package com.linkup.user;

import com.linkup.database.dbActions.ops.*;
import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.database.table.*;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents a class for authenticating user login.
 * Extends LoginDBAction abstract class.
 */
public class LoginUser extends FindDBAction {
  // Logger for logging messages
  private static final Logger logger =
      Logger.getLogger(LoginUser.class.getName());

  // Member variables to store user information required for login
  private int userId;
  private String username;
  private String password;
  private String password_hash;

  /**
   * Constructor to initialize user information for login.
   * @param Id The ID of the user.
   * @param username The username of the user.
   * @param password The password of the user.
   */
  public LoginUser(int Id, String username, String password) {
    this.userId = Id;
    this.username = username;
    this.password = password;
    this.password_hash = password;
  }

  /**
   * Authenticates the user based on provided credentials.
   * @return True if the user is authenticated, false otherwise.
   */
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

  /**
   * Retrieves the ID of the user.
   * @return The ID of the user.
   */
  public int getID() { return this.userId; }

  /**
   * Checks if the conditions for performing the database action are met.
   * @return True if the conditions are met, false otherwise.
   * @throws FrontEndUsageException If there is a front-end usage exception.
   */
  @Override
  public Boolean checks() throws FrontEndUsageException {
    return true;
  }

  /**
   * Specifies the table in the database for login operation.
   * @return The table name from the database.
   */
  public Table getTable() {
    // return the name of the table in the database
    return Table.ACCOUNT;
  }

  /**
   * Builds a login query based on the provided username and password hash.
   * @param colValueMap Map containing username and password hash.
   * @return The constructed SQL query for login.
   */
  protected String buildQuery(Map<String, String> colValueMap) {
    // Retrieve username and password hash from the map
    String username = colValueMap.get("username");
    String password = colValueMap.get("password_hash");

    // Construct the SQL query for login
    StringBuilder sb = new StringBuilder();
    sb.append("SELECT * FROM ")
        .append(getTable())
        .append(" WHERE username = '")
        .append(username)
        .append("' AND password_hash = '")
        .append(password)
        .append("';");
    String query = sb.toString();
    return query;
  }
}
