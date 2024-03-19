package com.linkup;
import java.util.logging.*;

import com.linkup.database.dbConnection.*;
import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.user.User;

public class App {
  private static final Logger logger = Logger.getLogger(App.class.getName());
  public static void main(String[] args) {
    // Resolve database host:
    establishConnection();

    // @USER_DB_FUNCTIONALITY_TEST
    User user = new User(001, "user@gmail.com", "password1234", "password123");
    try {
      Integer returnValue = (Integer)user.performDBAction().getValue();
      logger.info("Rows updated: " + returnValue);
      //System.out.println("Rows updated: " + returnValue);
    } catch (FrontEndUsageException e) {
      e.printStackTrace();
      logger.log(Level.SEVERE, "Error performing database action", e);
    }
    // Do the rest of backend

    // Stop database server and close connection:
    closeConnection();
  }

  private static void establishConnection() {
    ConnectionManager.getInstance("https://localhost:4039");
    //System.out.println("Connection established with Database.");
    logger.info("Connection established with Database.");
  }

  private static void closeConnection() {
    ConnectionManager instance = ConnectionManager.getInstance(null);
    HTTPSConnector connection = instance.getConnector();
    connection.sendRequest("<SYSTEM:string>STOP</SYSTEM>");
    //System.out.println("Closed connection with Database successfully.");
    logger.info("Closed connection with Database successfully.");
  }
}
