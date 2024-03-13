package main.java.com.linkup.user;

import java.util.Date;

public class UserProfile {
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

  public int getUserId() { return userId; }

  public void setUserId(int userId) { this.userId = userId; }

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
}
