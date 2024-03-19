package com.linkup;

import com.linkup.database.dbConnection.*;
import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.user.User;

public class App {
  public static void main(String[] args) {
    // Resolve database host:
    establishConnection();

    // @USER_DB_FUNCTIONALITY_TEST
    User user = new User("username_001", "user@gmail.com", "password1234");
    try {
      Integer returnValue = (Integer)user.performDBAction().getValue();
      System.out.println("Rows updated: " + returnValue);
    } catch (FrontEndUsageException e) {
      e.printStackTrace();
    }
    // Do the rest of backend

    // Stop database server and close connection:
    closeConnection();
  }

  private static void establishConnection() {
    ConnectionManager.getInstance("https://localhost:4039");
    System.out.println("Connection established with Database.");
  }

  private static void closeConnection() {
    ConnectionManager instance = ConnectionManager.getInstance(null);
    HTTPSConnector connection = instance.getConnector();
    connection.sendRequest("<SYSTEM:string>STOP</SYSTEM>");
    System.out.println("Closed connection with Database successfully.");
  }
}
