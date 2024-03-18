package com.linkup.user;

import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.linkup.database.dbActions.ops.*;
import com.linkup.database.table.*;

public class User extends CreateDBAction{
  private int id;
  private String username;
  private String email;
  private String password;
  private Date registrationDate;
  private Date lastLoginDate;
  private boolean isActive;

  // Constructor
  public User(int Id, String username, String email, String password) {
    this.username = username;
    this.id = Id;
    this.email = email;
    this.password = password;
    this.registrationDate = new Date();
    this.isActive = true;
  }

  public int getId() { return id; }

  public String getUsername() { return username; }

  public void setUsername(String username) { this.username = username; }
  public String getEmail() { return email; }
  
  public void setEmail(String email) {
      // Regular expression to check the email address format
      // ^ asserts position at start of the string
      // [a-zA-Z0-9._%+-]+ matches one or more characters including alphanumeric characters, '.', '_', '%', '+', and '-'
      // @[a-zA-Z0-9.-]+ matches '@' followed by one or more characters including alphanumeric characters, '.' and '-'
      // \\.[a-zA-Z]{2,}$ ensures the email ends with a '.' followed by 2 or more letters, asserting the position at the end of the string
      String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

   // Check if the email address matches the regular expression
      if(email.matches(emailRegex)) {
          // If the email is valid, assign it to userEmail
          this.email = email;
      }
  }
  
  public String getPassword() { return password; }
  
  public void setPassword(String password) {
      // Regular expression to check the password criteria
      // ^ asserts position at start of the string
      // (?=.*[0-9]) ensures at least one digit exists
      // (?=.*[a-zA-Z]) ensures at least one letter exists, either lowercase or uppercase
      // .{8,} means any character can appear at least 8 times
      // $ asserts position at the end of the string
      String passwordRegex = "^(?=.*[0-9])(?=.*[a-zA-Z]).{8,}$";	

      // Check if the password matches the regular expression
      if(password.matches(passwordRegex)) {
          // If the password is valid, assign it to userPassword
          this.password = password;
      }
  }
  
  public Date getRegistrationDate() { return registrationDate; }
  public void setRegistrationDate(Date registrationDate) {
    this.registrationDate = registrationDate;
  }
  public Date getLastLoginDate() { return lastLoginDate; }
  public void setLastLoginDate(Date lastLoginDate) {
    this.lastLoginDate = lastLoginDate;
  }
  public boolean isActive() { return isActive; }
  public void setActive(boolean active) { isActive = active; }

  // Method to create a new user account
  public void createNewUser(int id, String username, String email,
                                   String password) {
    User newUser = new User(id, username, email, password);
    // Here we will add additional logic such as saving the user to a database

    String query = buildQuery((Map<String, String>) newUser);
  }

  public Table getTable() {
    return Table.ACCOUNT;
  }
}
