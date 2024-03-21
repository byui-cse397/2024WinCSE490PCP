package com.linkup.user;

import com.linkup.database.dbActions.ops.*;
import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.database.table.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/*
  The User class represents a user entity with various attributes such as ID,
  username, email, etc. It provides getter and setter methods to access and
  modify user information. The createNewUser method is intended to be used for
  creating a new user account. It currently creates a new User object and
  assumes additional logic for saving user data to a database, such as building
    and executing a database query.
  The getTable method specifies the table in the database where user data is
  stored.
  */
public class CreateUser extends CreateDBAction {
  private static final Logger logger = Logger.getLogger(User.class.getName());
  // Member variables to store user information
  private String password;
  private String password_hash;
  private String username;
  private String email;
  private Date registrationDate;
  private Date lastLoginDate;
  private boolean isActive;

  // Constructor to initialize user object with basic information
  public CreateUser(String username, String email, String password) {
    this.username = username;
    this.email = email;
    this.password_hash = password;
    this.registrationDate = new Date();
    this.isActive = true;

    // Configure logger
    try {
      FileHandler fh = new FileHandler("user.log");
      logger.addHandler(fh);
      SimpleFormatter formatter = new SimpleFormatter();
      fh.setFormatter(formatter);
    } catch (Exception e) {
      logger.warning("Failed to configure logger: " + e.getMessage());
    }
  }

  // Getter method for retrieving username
  public String getUsername() { return username; }

  // Setter method for updating username
  public void setUsername(String username) {
    this.username = username;
    logger.info("Username updated: " + username);
  }

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
      logger.info("Email updated: " + email);
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
      logger.info("Password updated.");
    }
  }

  // Getter method for retrieving registration date
  public Date getRegistrationDate() { return registrationDate; }

  // Setter method for updating registration date
  public void setRegistrationDate(Date registrationDate) {
    this.registrationDate = registrationDate;
    logger.info("Registration date updated: " + registrationDate);
  }

  // Getter method for retrieving last login date
  public Date getLastLoginDate() { return lastLoginDate; }

  // Setter method for updating last login date
  public void setLastLoginDate(Date lastLoginDate) {
    this.lastLoginDate = lastLoginDate;
    logger.info("Last login date updated: " + lastLoginDate);
  }

  // Getter method for checking if the user is active
  public boolean isActive() { return isActive; }

  // Setter method for updating user activity status
  public void setActive(boolean active) {
    isActive = active;
    logger.info("User activity status updated: " + active);
  }

  // Method to create a new user account
  public void createNewUser(String username, String email, String password) {
    // Create a new user object with provided information
    CreateUser newUser = new CreateUser(username, email, password);

    // Here we would typically add additional logic to save the user to a
    // database For demonstration, let's assume we are building a query to//
    // insert user data into a database
    //    // Map user attributes to column-value pairs
    //    Map<String, String> colValueMap = new HashMap<>();
    //    colValueMap.put("Username", newUser.getUsername());
    //    colValueMap.put("Email", newUser.getEmail());
    //    colValueMap.put("Password", newUser.getPassword()); // Storing
    //    password hash in the database is recommended

    logger.info("New user created: " + newUser.getUsername());
  }

  @Override
  public Boolean checks() throws FrontEndUsageException {
    return true;
  }

  // Method to specify the table in the database where user data is stored
  public Table getTable() { return Table.ACCOUNT; }
}
