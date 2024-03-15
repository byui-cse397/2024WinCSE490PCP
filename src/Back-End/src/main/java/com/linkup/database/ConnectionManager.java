package com.linkup.database;

import java.net.URISyntaxException;
import java.security.InvalidParameterException;

// Singleton class since we don't need to re-resolve our host after
// initialization. Gives us the flexibility of OOP while declaring our
// connection a single time.
//
// Requires that we resolve our host at runtime before it can be used.
public class ConnectionManager {
  private static ConnectionManager instance;
  private static HTTPSConnector connector;

  private ConnectionManager(String url) throws URISyntaxException {
    connector = new HTTPSConnector(url);
  }

  /**
   * Acts as our initializer if the class hasn't been instantiated yet,
   * otherwise returns our resolved host instance.
   * @param host Acts to resolve our host the first time, a nullable parameter
   *     afterwards.
   * @return Returns the current ConnectionManager instance.
   *
   */
  public static ConnectionManager getInstance(String host)
      throws InvalidParameterException {
    if (instance == null) {
      if (host == null) {
        throw new InvalidParameterException("Host wasn't specified.");
      }
      try {
        instance = new ConnectionManager(host);
        HTTPSConnector connector = instance.getConnector();
        connector.sendRequest("<SYSTEM:String>Testing connection...</SYSTEM>");
      } catch (URISyntaxException e) {
        System.out.println("Failed to establish connection with database.");
      }
    }
    return instance;
  }

  public HTTPSConnector getConnector() throws NotInstantiatedException {
    if (connector == null) {
      throw new NotInstantiatedException();
    }
    return connector;
  }
}
