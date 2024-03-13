package main.java.com.linkup.user;
import java.util.Date;
public class User {
  private long id;
  private String username;
  private String email;
  private String password;
  private Date registrationDate;
  private Date lastLoginDate;
  private boolean isActive;

  // Constructor
  public User(String username, String email, String password) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.registrationDate = new Date();
    this.isActive = true;
  }

  public long getId() { return id; }
  public void setId(long id) { this.id = id; }

  public String getUsername() { return username; }

  public void setUsername(String username) { this.username = username; }
  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }

  public String getPassword() { return password; }
  public void setPassword(String password) { this.password = password; }
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
  public static User createNewUser(String username, String email,
                                   String password) {
    User newUser = new User(username, email, password);
    // Here we will add additional logic such as saving the user to a database
    return newUser;
  }
}
