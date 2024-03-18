package com.linkup;

import com.linkup.database.dbConnection.*;

public class App {
  public static void main(String[] args) {
    // Resolve database host:
    establishConnection();

    // Do the rest of backend

    // Stop database server and close connection:
    closeConnection();
  }

  private static void establishConnection() {
    ConnectionManager.getInstance("https://localhost:4039");
    System.out.println("Connection established.");
  }

  private static void closeConnection() {
    ConnectionManager instance = ConnectionManager.getInstance(null);
    HTTPSConnector connection = instance.getConnector();
    connection.sendRequest("<SYSTEM:string>STOP</SYSTEM>");
    System.out.println("Closed successfully.");
  }
}
