package com.linkup;
import com.linkup.database.dbConnection.*;
import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.frontendConnector.FrontendConnector;
import com.linkup.user.UserManager;
import java.io.IOException;
import java.util.logging.*;

/**
 * Main class of the community board mobile application backend.
 * Responsible for initializing components and managing database connections.
 */
public class App {
  // Logger instance for logging application events
  static Logger logger;

  /**
   * Main method to start the application.
   * @param args Command-line arguments.
   */
  public static void main(String[] args) {
    // Setup logging:
    //
    System.out.println("Starting connection");
    try {
      FrontendConnector connector = new FrontendConnector();
    } catch (IOException e) {
      e.printStackTrace();
    }

    /*
    logger = LoggingManager.getLogger();
    // Resolve database host:
    establishConnection();

    // Create a new user:
    UserManager manager = new UserManager();
    try {
      // Attempt to create a new user and retrieve the user ID
      Integer userID = manager.createNewUser("username_002", "email@domain.net",
                                             "password_002");
      // Log successful user creation and login
      StringBuilder sb = new StringBuilder();
      sb.append("User ").append(userID).append(
          " created and logged in successfully.");
      System.out.println(sb.toString());
    } catch (FrontEndUsageException e) {
      // Handle frontend usage exception by parsing the message and sending it
      // to the frontend
    }

    // Stop database server and close connection:
    closeConnection();
    */
  }

  /**
   * Establishes connection with the database server.
   */
  private static void establishConnection() {
    ConnectionManager.getInstance("https://localhost:4039");
    // System.out.println("Connection established with Database.");
    logger.info("Connection established with Database.");
  }

  /**
   * Closes the connection with the database server.
   */
  private static void closeConnection() {
    ConnectionManager instance = ConnectionManager.getInstance(null);
    HTTPSConnector connection = instance.getConnector();
    connection.sendRequest("<SYSTEM:string>STOP</SYSTEM>");
    // System.out.println("Closed connection with Database successfully.");
    logger.info("Closed connection with Database successfully.");
  }
}
