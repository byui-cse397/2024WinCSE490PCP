// Anita Woodford and Allan 
package com.linkup.user;

import com.linkup.database.dbActions.ops.*;
import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.database.table.*;


/**
 * Represents a class for deleting user accounts from the database.
 * Extends DeleteDBAction abstract class.
 */
public class DeleteUser extends DeleteDBAction {
  private int userId;
  private String username;
  private String password_Hash;
  private String delete_Reason;


  public DeleteUser( int userId, String username, String password_Hash, String delete_Reason){
    this.userId = userId;
    this.username = username;
    this.password_Hash = password_Hash;
    this.delete_Reason = delete_Reason;

  }

  public int getID(){
    return userId;
  }

  public String getUsername(){
    return username;
  }

  public String getpasswordHash() {
    return password_Hash;
  }

  public String deletionReason(){
    return delete_Reason;
  }

  @Override
  public Table getTable() {
    return Table.ACCOUNT;
  }

  public Boolean checks() throws FrontEndUsageException {
    return true;
  }

}

