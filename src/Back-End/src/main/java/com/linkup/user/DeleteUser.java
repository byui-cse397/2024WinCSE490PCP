package com.linkup.user;

import com.linkup.database.dbActions.ops.*;
import com.linkup.database.table.*;

import java.util.Date;

public class DeleteUser extends DeleteDBAction {
  private int userId;
  private String username;
  private String email;
  private String password;
  private String confirmationPassword;
  private String deletionReason;
  private Date deletionDate;

  public DeleteUser(int userId, String username, String email, String password,
                    String confirmationPassword, String deletionReason) {
    this.userId = userId;
    this.username = username;
    this.email = email;
    this.password = password;
    this.confirmationPassword = confirmationPassword;
    this.deletionReason = deletionReason;
  }

  private void deleteAccount(){
    if (!validateCredentials()){
      validateCredentials();
    } else if (validateCredentials()) {
      confirmDeletion();
      // Check if the provided username and password match the expected values
      String query = buildQuery(this.userId);

      System.out.println(query);
    }
  }

  public void execute(){
    deleteAccount();
  }
  public boolean validateCredentials() {
    return password.equals(confirmationPassword);
  }

  public void confirmDeletion() {
    if (validateCredentials() && !deletionReason.isEmpty()) {
      deletionDate = new Date();
    }
  }


  public String getDeletionReason() { return deletionReason; }

  public Date getDeletionDate() { return deletionDate; }

  public Table getTable() {
    return Table.ACCOUNT;
  }

  public int getID() {
    return this.userId;
  }
}
