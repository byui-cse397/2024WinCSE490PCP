package com.linkup.user;

import com.linkup.database.dbActions.ops.*;
import com.linkup.database.table.*;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

  /*
    The User class represents a user entity with various attributes such as ID, username, email, etc.
    It provides getter and setter methods to access and modify user information.
    The createNewUser method is intended to be used for creating a new user account. It currently creates
      a new User object and assumes additional logic for saving user data to a database, such as building
      and executing a database query.
    The getTable method specifies the table in the database where user data is stored.
    */
public class User extends CreateDBAction {
  // Member variables to store user information
  private int id;
  private String username;
  private String email;
  private String password;
  private Date registrationDate;
  private Date lastLoginDate;
  private boolean isActive;

  // Constructor to initialize user object with basic information
  public User(int Id, String username, String email, String password) {
    this.username = username;
    this.id = Id;
    this.email = email;
    this.password = password;
    this.registrationDate = new Date();
    this.isActive = true;
  }

  // Getter method for retrieving user ID
  public int getId() { return id; }

  // Getter method for retrieving username
  public String getUsername() { return username; }

  // Setter method for updating username
  public void setUsername(String username) { this.username = username; }

  // Getter method for retrieving email
  public String getEmail() { return email; }

  // Setter method for updating email
  public void setEmail(String email) {
    // Regular expression to check the email address format
    // ^ asserts position at start of the string
    // [a-zA-Z0-9._%+-]+ matches one or more characters including alphanumeric
    // characters, '.', '_', '%', '+', and '-'
    // @[a-zA-Z0-9.-]+ matches '@' followed by one or more characters including
    // alphanumeric characters, '.' and '-'
    // \\.[a-zA-Z]{2,}$ ensures the email ends with a '.' followed by 2 or more
    // letters, asserting the position at the end of the string
    String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    // Check if the email address matches the regular expression
    if (email.matches(emailRegex)) {
      // If the email is valid, assign it to userEmail
      this.email = email;
    }
  }

  // Getter method for retrieving password
  public String getPassword() { return password; }

  // Setter method for updating password
  public void setPassword(String password) {
    // Regular expression to enforce password criteria
    // Regular expression to check the password criteria
    // ^ asserts position at start of the string
    // (?=.*[0-9]) ensures at least one digit exists
    // (?=.*[a-zA-Z]) ensures at least one letter exists, either lowercase or
    // uppercase
    // .{8,} means any character can appear at least 8 times
    // $ asserts position at the end of the string
    String passwordRegex = "^(?=.*[0-9])(?=.*[a-zA-Z]).{8,}$";

    // Check if the password matches the regular expression
    if (password.matches(passwordRegex)) {
      // If the password is valid, assign it to userPassword
      this.password = password;
    }
  }

  // Getter method for retrieving registration date
  public Date getRegistrationDate() { return registrationDate; }

  // Setter method for updating registration date
  public void setRegistrationDate(Date registrationDate) {
    this.registrationDate = registrationDate;
  }

  // Getter method for retrieving last login date
  public Date getLastLoginDate() { return lastLoginDate; }

  // Setter method for updating last login date
  public void setLastLoginDate(Date lastLoginDate) {
    this.lastLoginDate = lastLoginDate;
  }

  // Getter method for checking if the user is active
  public boolean isActive() { return isActive; }

  // Setter method for updating user activity status
  public void setActive(boolean active) { isActive = active; }

  // Method to create a new user account
  public void createNewUser(int id, String username, String email,
                            String password) {
    // Create a new user object with provided information
    User newUser = new User(id, username, email, password);

    // Here we would typically add additional logic to save the user to a database
    // For demonstration, let's assume we are building a query to insert user data into a database
    String query = buildQuery((Map<String, String>)newUser);
  }

  // Method to specify the table in the database where user data is stored
  public Table getTable() { return Table.ACCOUNT; }
}
