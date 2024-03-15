package com.linkup.database.dbConnection;

public class NotInstantiatedException extends RuntimeException {
  public NotInstantiatedException() {
    super("ConnectionManager has not been instantiated yet.");
  }

  public NotInstantiatedException(String message) { super(message); }
}
