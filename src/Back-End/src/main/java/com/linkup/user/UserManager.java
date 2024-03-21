package com.linkup.user;

import com.linkup.LoggingManager;
import com.linkup.common.XMLParsing.XMLNode;
import com.linkup.common.XMLParsing.XMLParent;
import com.linkup.database.exceptions.FrontEndUsageException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.*;

/**
 * Manages user-related operations such as login and user creation.
 */
public class UserManager {
  HashMap<Integer, User> activeUsers;
  private Logger logger;

  /**
   * Constructor to initialize the UserManager.
   */
  public UserManager() {
    logger = LoggingManager.getLogger();
    activeUsers = new HashMap<>();
  }

  /**
   * Handles user login by validating credentials and creating a new User object if successful.
   * @param username The username of the user trying to log in.
   * @param password The password of the user trying to log in.
   * @return The userID of the logged-in user.
   * @throws FrontEndUsageException If there is a front-end usage exception.
   */
  public Integer loginHandler(String username, String password)
      throws FrontEndUsageException {
    Integer request = loginRequest(username, password);
    if (request != null) {
      User user = new User(request);
      activeUsers.put(request, user);
    }
    return request;
  }

  /**
   * Creates a new user by invoking the CreateUser action and handling the login process.
   * @param username The username of the new user.
   * @param email The email of the new user.
   * @param password The password of the new user.
   * @return The userID of the newly created user.
   * @throws FrontEndUsageException If there is a front-end usage exception.
   */
  public Integer createNewUser(String username, String email, String password)
      throws FrontEndUsageException {
    User.Create(username, email, password);
    Integer userID = loginHandler(username, password);
    return userID;
  }

  /**
   * Sends a login request to the database to authenticate the user and retrieve their userID.
   * @param username The username of the user trying to log in.
   * @param password The password of the user trying to log in.
   * @return The userID of the logged-in user.
   * @throws FrontEndUsageException If there is a front-end usage exception.
   */
  private Integer loginRequest(String username, String password)
      throws FrontEndUsageException {
    Integer id = null;
    LoginUser login = new LoginUser(-999, username, password);
    XMLNode<XMLParent> node = login.performDBAction();
    ArrayList<XMLNode<?>> rows = node.getValue().getChildren();
    XMLNode<XMLParent> first_result = (XMLNode<XMLParent>)rows.getFirst();
    ArrayList<XMLNode<?>> first_items = first_result.getValue().getChildren();
    for (XMLNode<?> item : first_items) {
      if (item.getTagName().toUpperCase().equals("ID")) {
        id = (Integer)item.getValue();
      }
    }
    return id;
  }

  /**
   * Retrieves a user by their userID.
   * @param userID The userID of the user to retrieve.
   * @return The User object corresponding to the userID.
   */
  public User getUserById(Integer userID) { return activeUsers.get(userID); }
}
