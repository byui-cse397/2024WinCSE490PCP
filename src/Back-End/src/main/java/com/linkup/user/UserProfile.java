package com.linkup.user;

import com.linkup.database.dbActions.ops.*;
import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.database.table.*;
import java.util.Map;

import java.util.Date;

public class UserProfile extends UpdateDBAction{
  // Default values for each property
  private int userId = 0;
  private String username = "";
  private String email = "";
  private String fullName = "";
  private String bio = "";
  private String profilePictureUrl = "";
  private Date registrationDate = null;
  private Date lastLoginDate = null;

  // Constructor that takes userId, name, and email
  public UserProfile(int userId, String name, String email) {
    this.userId = userId;
    this.username = name;
    this.email = email;
  }

  // Method to update user profile
  public void updateProfile() {

  }

  public int getUserId() { return userId; }

  
  public String getUsername() { return username; }

  public void setUsername(String username) { this.username = username; }

  public String getEmail() { return email; }

  public void setEmail(String email) { this.email = email; }

  public String getFullName() { return fullName; }

  public void setFullName(String fullName) { this.fullName = fullName; }

  public String getBio() { return bio; }

  public void setBio(String bio) { this.bio = bio; }

  public String getProfilePictureUrl() { return profilePictureUrl; }

  public void setProfilePictureUrl(String profilePictureUrl) {
    this.profilePictureUrl = profilePictureUrl;
  }

  public Date getRegistrationDate() { return registrationDate; }

  public void setRegistrationDate(Date registrationDate) {
    this.registrationDate = registrationDate;
  }

  public Date getLastLoginDate() { return lastLoginDate; }

  public void setLastLoginDate(Date lastLoginDate) {
    this.lastLoginDate = lastLoginDate;
  }

  @Override
  public Boolean checks() throws FrontEndUsageException {
    return null;
  }

  @Override
  public Table getTable() {
    return Table.ACCOUNT;
  }

  @Override
  public int getID() {
    return this.userId; // Return the user ID
  }
}
