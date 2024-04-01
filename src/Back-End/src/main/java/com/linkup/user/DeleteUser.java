package com.linkup.user;

import com.linkup.database.dbActions.ops.*;
import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.database.table.*;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents a class for deleting user accounts from the database.
 * Extends DeleteDBAction abstract class.
 */
public class DeleteUser extends DeleteDBAction {
  // Logger for logging messages
  private static final Logger logger = Logger.getLogger(DeleteUser.class.getName());
  // Member variables to store user information required for deletion
  private int userId;
  private String username;
  private String email;
  private String password;
  private String confirmationPassword;
  private String deletionReason;
  private Date deletionDate;

  /**
   * Constructor to initialize user information required for deletion.
   * @param userId The ID of the user account to be deleted.
   * @param username The username of the user account.
   * @param email The email address of the user account.
   * @param password The password of the user account.
   * @param confirmationPassword The confirmation password for deletion.
   * @param deletionReason The reason for account deletion.
   */
  public DeleteUser(int userId, String username, String email, String password,
                    String confirmationPassword, String deletionReason) {
    this.userId = userId;
    this.username = username;
    this.email = email;
    this.password = password;
    this.confirmationPassword = confirmationPassword;
    this.deletionReason = deletionReason;
  }

  /**
   * Initiates the deletion process for the user account.
   * @return True if the account deletion is successful, false otherwise.
   */
  private Boolean deleteAccount() {
    Boolean delete_flag = true;
    // Check if credentials are valid for deletion
    Boolean credentials = validateCredentials();
    if (!credentials) {
      delete_flag = false;
    } else {
      confirmDeletion(); // Confirm deletion if credentials are valid
      // Check if the provided username and password match the expected values
      // Log user deletion
    }
    return delete_flag;
  }


  /**
   * Executes the deletion process for the user account.
   */
  public void execute(){
    deleteAccount(); // Execute the account deletion process
  }

  /**
   * Validates user credentials for deletion.
   * @return True if the credentials are valid, false otherwise.
   */
  public boolean validateCredentials() {
    return password.equals(confirmationPassword);
  }

  /**
   * Confirms the deletion of the user account.
   */
  public void confirmDeletion() {
    // Check if credentials are valid and deletion reason is provided
    if (validateCredentials() && !deletionReason.isEmpty()) {
      deletionDate = new Date();
      // Log deletion confirmation
      logger.info("Account deletion confirmed. Reason: " + deletionReason);
    }
  }

  /**
   * Retrieves the deletion reason.
   * @return The reason for account deletion.
   */
  public String getDeletionReason() { return deletionReason; }

  /**
   * Retrieves the deletion date.
   * @return The date when the account was deleted.
   */
  public Date getDeletionDate() { return deletionDate; }

  /**
   * Checks if the conditions for performing the database action are met.
   * @return True if the conditions are met, false otherwise.
   * @throws FrontEndUsageException If there is a front-end usage exception.
   */
  @Override
  public Boolean checks() throws FrontEndUsageException {
    Boolean delete = deleteAccount();
    if (!delete) {
      throw new FrontEndUsageException("Confirmation password was invalid.") {

      };
    }
    return delete;
  }


  /**
   * Specifies the table in the database from which the user account should be deleted.
   * @return The table name from the database.
   */
  public Table getTable() {
    return Table.ACCOUNT; // Return the account table from the database
  }

  /**
   * Retrieves the ID of the user account to be deleted.
   * @return The ID of the user account.
   */
  public int getID() {
    return this.userId; // Return the user ID
  }
}
