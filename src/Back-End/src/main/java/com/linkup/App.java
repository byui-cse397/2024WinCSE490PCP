package com.linkup;
import com.linkup.common.XMLParsing.XMLNode;
import com.linkup.database.dbConnection.*;
import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.user.LoginUser;
import com.linkup.user.User;
import java.util.logging.*;

public class App {
  private static final Logger logger = Logger.getLogger(App.class.getName());
  public static void main(String[] args) {
    // Resolve database host:
    establishConnection();

    // @LOGIN_DB_FUNCTIONALITY_TEST
    LoginUser login = new LoginUser(-999, "username_001", "password_001");
    try {
      XMLNode node = (XMLNode)login.performDBAction().getValue();
      System.out.println("Login output: " + node.toString());
      System.out.println("Double checking... children count: " +
                         node.getChildren().size());

    } catch (FrontEndUsageException e) {
      e.printStackTrace();
      logger.log(Level.SEVERE, "Error performing database action", e);
    }

    // @USER_DB_FUNCTIONALITY_TEST
    User user = new User("username_001", "email@domain.com", "password_001");
    try {
      Integer returnValue = (Integer)user.performDBAction().getValue();
      logger.info("Rows updated: " + returnValue);
      // System.out.println("Rows updated: " + returnValue);
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
