package com.linkup.user;

public class LoginUser {
  private String username;
  private String password;

  // Constructor that takes a username and password
  public LoginUser(String username, String password) {
    this.username = username;
    this.password = password;
  }

  // Method to authenticate the user
  public boolean authenticate() { return true; }
}
