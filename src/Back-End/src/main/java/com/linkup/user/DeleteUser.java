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
    private Integer userId;
    private String password_Hash;
    private String confirmPassword_Hash;

  /**
   * Constructor to initialize user information required for deletion.
   * @param userId The ID of the user account to be deleted.
   * @param password_hash The password of the user account.
   * @param confirmPassword_hash The confirmation password for deletion.
   */
    public DeleteUser( int userId, String password_Hash, String confirmPassword_Hash){
      this.userId = userId;
      this.password_Hash = password_Hash;
      this.confirmPassword_Hash = confirmPassword_Hash;

    }

    public int getID(){
      return userId;
    }

    public String getPassword_Hash() {
      return password_Hash;
    }

    public String getConfirmPassword_Hash(){
      return confirmPassword_Hash;
    }

    @Override
    public Table getTable() {
      return Table.ACCOUNT;
    }

  @Override
  public Boolean checks() throws FrontEndUsageException {
    nullIdCheck();
    return true;
  }

  public void nullIdCheck() throws FrontEndUsageException {
    if (this.userId == null) {
      throw new FrontEndUsageException("Cannot read user from null ID.") {

      };
    }
    }
  }
