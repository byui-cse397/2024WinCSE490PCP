package com.linkup.user;

import com.linkup.LoggingManager;
import com.linkup.common.XMLParsing.XMLNode;
import com.linkup.database.exceptions.FrontEndUsageException;
import java.time.Instant;
import java.util.logging.*;

public class User {
  private Logger logger;
  private Integer userID;
  private Instant lastActionTime;

  public User(Integer userID) {
    logger = LoggingManager.getLogger();
    this.userID = userID;
    this.lastActionTime = Instant.now();
  }

  public static void Create(String username, String email, String password)
      throws FrontEndUsageException {
    CreateUser user = new CreateUser(username, email, password);
    user.performDBAction();
  }

  public void Read() {
    // TODO: Read implementation
    updateLastActionTime();
  }

  public void Update() {
    // TODO: Update Implementation
    updateLastActionTime();
  }

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

  private void updateLastActionTime() { lastActionTime = Instant.now(); }

  // Getter for lastActionTime
  public Instant getLastActionTime() { return lastActionTime; }
}
