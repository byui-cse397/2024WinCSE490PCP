package com.linkup.frontendConnector;

import com.linkup.common.XMLParsing.XMLNode;
import com.linkup.common.XMLParsing.XMLParent;
import com.linkup.common.XMLParsing.XMLParser;
import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.user.UserManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FrontendResponseParser {

  // parseMessage doesn't return anything, but probably should...
  public static void parseMessage(String message)
      throws FrontEndUsageException {
    UserManager manager = UserManager.getManager();
    try {
      Map<String, String> map = new HashMap<String, String>();
      XMLParser parser = new XMLParser(message, null);
      XMLNode<XMLParent> node = (XMLNode<XMLParent>)parser.parse();
      ArrayList<XMLNode<?>> data = node.getValue().getChildren();
      for (XMLNode<?> datum : data) {
        map.put(datum.getTagName(), datum.getValue().toString());
      }

      switch (node.getTagName()) {
      case "login":
        manager.loginHandler(map.get("username"), map.get("password_hash"));
        break;
      case "create":
        manager.createNewUser(map.get("username"), map.get("email"),
                              map.get("password_hash"));

      default:
        throw new FrontEndUsageException(
            "Front end action type not implemented.") {};
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
