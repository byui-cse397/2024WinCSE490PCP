package com.linkup.user;

import com.linkup.database.dbActions.ops.*;
import com.linkup.database.table.*;

import java.util.Date;

public class DeleteUser extends DeleteDBAction {
  // Member variables to store user information required for deletion
  private int userId;
  private String username;
  private String email;
  private String password;
  private String confirmationPassword;
  private String deletionReason;
  private Date deletionDate;

  // Constructor to initialize user information required for deletion
  public DeleteUser(int userId, String username, String email, String password,
                    String confirmationPassword, String deletionReason) {
    this.userId = userId;
    this.username = username;
    this.email = email;
    this.password = password;
    this.confirmationPassword = confirmationPassword;
    this.deletionReason = deletionReason;
  }

  // Method to initiate the deletion process
  private void deleteAccount(){
    // Check if credentials are valid for deletion
    if (!validateCredentials()){
      validateCredentials(); // Display error message if credentials are invalid
    } else if (validateCredentials()) {
      confirmDeletion(); // Confirm deletion if credentials are valid
      // Check if the provided username and password match the expected values
      String query = buildQuery(this.userId); // Build query to delete user account from the database

      System.out.println(query); // Print the delete query for debugging purposes
    }
  }

  // Method to execute the deletion process
  public void execute(){
    deleteAccount(); // Execute the account deletion process
  }

  // Method to validate user credentials for deletion
  public boolean validateCredentials() {
    return password.equals(confirmationPassword);
  }

  // Method to confirm the deletion of the user account
  public void confirmDeletion() {
    // Check if credentials are valid and deletion reason is provided
    if (validateCredentials() && !deletionReason.isEmpty()) {
      deletionDate = new Date();
    }
  }

  // Getter method to retrieve the deletion reason
  public String getDeletionReason() { return deletionReason; }

  // Getter method to retrieve the deletion date
  public Date getDeletionDate() { return deletionDate; }

  // Method to specify the table in the database from which the user account should be deleted
  public Table getTable() {
    return Table.ACCOUNT; // Return the account table from the database
  }

  // Method to retrieve the ID of the user account to be deleted
  public int getID() {
    return this.userId; // Return the user ID
  }
}
