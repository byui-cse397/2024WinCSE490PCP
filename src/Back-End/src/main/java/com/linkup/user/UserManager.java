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
  static UserManager manager;
  private Logger logger;

  /**
   * Constructor to initialize the UserManager.
   */
  public UserManager() {
    if (manager == null) {
      logger = LoggingManager.getLogger();
      manager = this;
    }
  }

  public static UserManager getManager() {
    new UserManager();
    return manager;
  }

  /**
   * Handles user login by validating credentials and creating a new User object
   * if successful.
   * @param username The username of the user trying to log in.
   * @param password The password of the user trying to log in.
   * @return The userID of the logged-in user.
   * @throws FrontEndUsageException If there is a front-end usage exception.
   */
  public static Integer loginHandler(String username, String password)
      throws FrontEndUsageException {
    Integer request = loginRequest(username, password);
    return request;
  }

  /**
   * Creates a new user by invoking the CreateUser action and handling the login
   * process.
   * @param username The username of the new user.
   * @param email The email of the new user.
   * @param password The password of the new user.
   * @return The userID of the newly created user.
   * @throws FrontEndUsageException If there is a front-end usage exception.
   */
  public static Integer createNewUser(String username, String email,
                                      String password)
      throws FrontEndUsageException {
    User.Create(username, email, password);
    Integer userID = loginHandler(username, password);
    return userID;
  }

  /**
   * Sends a login request to the database to authenticate the user and retrieve
   * their userID.
   * @param username The username of the user trying to log in.
   * @param password The password of the user trying to log in.
   * @return The userID of the logged-in user.
   * @throws FrontEndUsageException If there is a front-end usage exception.
   */
  private static Integer loginRequest(String username, String password)
      throws FrontEndUsageException {
    Integer id = null;
    LoginUser login = new LoginUser(username, password);
    XMLNode<XMLParent> node = login.performDBAction();
    ArrayList<XMLNode<?>> rows = node.getValue().getChildren();
    XMLNode<XMLParent> firstResult = (XMLNode<XMLParent>)rows.get(0);
    ArrayList<XMLNode<?>> firstItems = firstResult.getValue().getChildren();
    for (XMLNode<?> item : firstItems) {
      if (item.getTagName().toUpperCase().equals("ID")) {
        id = (Integer)item.getValue();
      }
    }
    return id;
  }

  public static Integer lookupIdByUsername(String username)
      throws FrontEndUsageException {
    FindUser finder = new FindUser(username);
    XMLNode<XMLParent> userParentNode = finder.performDBAction();
    for (XMLNode<?> childNode :
         ((XMLNode<XMLParent>)userParentNode.getValue().getChildren().get(0))
             .getValue()
             .getChildren()) {
      if ("id".equals(childNode.getTagName())) {
        return (Integer)childNode.getValue();
      }
    }
    throw new FrontEndUsageException("Invalid username was supplied.") {

    };
  }

  public static class User {
    // TODO: Handle user actions based off of login time.
    /**
     * Creates a new user with the provided username, email, and password.
     * @param username The username of the new user.
     * @param email The email of the new user.
     * @param password The password of the new user.
     * @throws FrontEndUsageException If there is a front-end usage exception.
     */
    public static XMLNode<Integer> Create(String username, String email,
                                          String password)
        throws FrontEndUsageException {
      CreateUser user = new CreateUser(username, email, password);
      XMLNode<Integer> node = user.performDBAction();
      return node;
    }

    /**
     * Reads user information.
     */
    public static XMLNode<XMLParent> read(Integer userID)
        throws FrontEndUsageException {
      ReadUser readUser = new ReadUser(userID);
      XMLNode<XMLParent> node = readUser.performDBAction();
      return node;
    }

    /**
     * Updates user information.
     */
    public static XMLNode<Integer> Update(Integer userID)
        throws FrontEndUsageException {
      UpdateUser updateUser =
          new UpdateUser(userID, "username", "password_hash");
      XMLNode<Integer> node = updateUser.performDBAction();
      return node;
    }

    /**
     * Deletes the user.
     * @throws FrontEndUsageException If there is a front-end usage exception.
     */
    public void Delete(Integer userId, String password_Hash,
                       String delete_Reason) throws FrontEndUsageException {
      DeleteUser deletion =
          new DeleteUser(userId, password_Hash, delete_Reason);
      XMLNode<Integer> node = deletion.performDBAction();
      node.getValue();
    }
  }
}
