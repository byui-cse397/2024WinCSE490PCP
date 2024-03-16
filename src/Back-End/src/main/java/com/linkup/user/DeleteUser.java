package com.linkup.user;

import java.util.Date;

public class DeleteUser {
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
}
