package com.linkup.user;

import com.linkup.LoggingManager;
import com.linkup.common.XMLParsing.XMLNode;
import com.linkup.common.XMLParsing.XMLParent;
import com.linkup.database.exceptions.FrontEndUsageException;
import java.time.Instant;
import java.util.logging.*;

/**
 * Represents a user in the community board application.
 */
public class User {
  private Logger logger;
  private Integer userID;
  private Instant lastActionTime;

  /**
   * Constructor to initialize a User object with a given userID.
   * @param userID The unique identifier for the user.
   */
  public User(Integer userID) {
    logger = LoggingManager.getLogger();
    this.userID = userID;
    this.lastActionTime = Instant.now();
  }

  public Integer getUserId() { return userID; }

  /**
   * Creates a new user with the provided username, email, and password.
   * @param username The username of the new user.
   * @param email The email of the new user.
   * @param password The password of the new user.
   * @throws FrontEndUsageException If there is a front-end usage exception.
   */
  public static void Create(String username, String email, String password)
      throws FrontEndUsageException {
    CreateUser user = new CreateUser(username, email, password);
    user.performDBAction();
  }

  /**
   * Reads user information.
   * TODO: Implement Read functionality.
   */
  public void Read() {
    // TODO: Read implementation
    updateLastActionTime();
  }

  /**
   * Updates user information.
   * TODO: Implement Update functionality.
   */
  public void Update() {
    // TODO: Update Implementation
    updateLastActionTime();
  }

  /**
   * Deletes the user.
   * @throws FrontEndUsageException If there is a front-end usage exception.
   */
  public void Delete() throws FrontEndUsageException {
    DeleteUser deletion =
        new DeleteUser(userID, "user", "email", "password",
                       "confirmationPassword", "A really terrible reason");
    updateLastActionTime();
    XMLNode<Integer> node = deletion.performDBAction();
    Integer rowsDeleted = node.getValue();
    if (rowsDeleted == 1) {
      return;
    }
    StringBuilder sb = new StringBuilder();
    sb.append("DeleteUser operation returned ")
        .append(rowsDeleted)
        .append(" rows were deleted for userID ")
        .append(userID)
        .append(". This means that unique IDs are not being enforced.");
    logger.log(Level.WARNING, sb.toString());
  }

  /**
   * Updates the last action time to the current time.
   */
  private void updateLastActionTime() { lastActionTime = Instant.now(); }

  /**
   * Retrieves the last action time of the user.
   * @return The last action time.
   */
  public Instant getLastActionTime() { return lastActionTime; }
}
