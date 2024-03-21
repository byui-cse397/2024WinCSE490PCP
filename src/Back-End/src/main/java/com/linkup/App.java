package com.linkup;
import com.linkup.database.dbConnection.*;
import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.user.UserManager;
import java.util.logging.*;

public class App {
  static Logger logger;
  public static void main(String[] args) {
    // Setup logging:
    logger = LoggingManager.getLogger();
    // Resolve database host:
    establishConnection();

    UserManager manager = new UserManager();
    try {
      Integer userID = manager.createNewUser("username_002", "email@domain.net",
                                             "password_002");
      StringBuilder sb = new StringBuilder();
      sb.append("User ").append(userID).append(
          " created and logged in successfully.");
      System.out.println(sb.toString());
    } catch (FrontEndUsageException e) {
      // parse this message and send it to FE
    }

    // Stop database server and close connection:
    closeConnection();
  }

  private static void establishConnection() {
    ConnectionManager.getInstance("https://localhost:4039");
    // System.out.println("Connection established with Database.");
    logger.info("Connection established with Database.");
  }

  private static void closeConnection() {
    ConnectionManager instance = ConnectionManager.getInstance(null);
    HTTPSConnector connection = instance.getConnector();
    connection.sendRequest("<SYSTEM:string>STOP</SYSTEM>");
    // System.out.println("Closed connection with Database successfully.");
    logger.info("Closed connection with Database successfully.");
  }
}
