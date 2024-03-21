package com.linkup.user;

import com.linkup.LoggingManager;
import com.linkup.common.XMLParsing.XMLNode;
import com.linkup.common.XMLParsing.XMLParent;
import com.linkup.database.exceptions.FrontEndUsageException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.*;

public class UserManager {
  HashMap<Integer, User> activeUsers;
  private Logger logger;

  public UserManager() {
    logger = LoggingManager.getLogger();
    activeUsers = new HashMap<>();
  }

  public Integer loginHandler(String username, String password)
      throws FrontEndUsageException {
    Integer request = loginRequest(username, password);
    if (request != null) {
      User user = new User(request);
      activeUsers.put(request, user);
    }
    return request;
  }

  public Integer createNewUser(String username, String email, String password)
      throws FrontEndUsageException {
    User.Create(username, email, password);
    Integer userID = loginHandler(username, password);
    return userID;
  }

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

  // Method to get a user by userID
  public User getUserById(Integer userID) { return activeUsers.get(userID); }
}
