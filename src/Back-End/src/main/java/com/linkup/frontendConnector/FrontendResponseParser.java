package com.linkup.frontendConnector;

import com.linkup.common.XMLParsing.XMLNode;
import com.linkup.common.XMLParsing.XMLParent;
import com.linkup.common.XMLParsing.XMLParser;
import com.linkup.communities.CommunityManager;
import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.posts.PostManager;
import com.linkup.user.UserManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FrontendResponseParser {

  // parseMessage doesn't return anything, but probably should...
  public static void parseMessage(String message)
      throws FrontEndUsageException {
    try {
      Map<String, String> map = new HashMap<String, String>();
      XMLParser parser = new XMLParser(message, null);
      XMLNode<XMLParent> node = (XMLNode<XMLParent>)parser.parse();
      ArrayList<XMLNode<?>> data = node.getValue().getChildren();
      for (XMLNode<?> datum : data) {
        map.put(datum.getTagName(), datum.getValue().toString());
      }
      switch (node.getTagName()) {
      case "userLogin":
        UserManager.loginHandler(map.get("username"), map.get("password_hash"));
        break;
      case "userCreate":
        UserManager.createNewUser(map.get("username"), map.get("email"),
                                  map.get("password_hash"));
        break;
      case "communityCreate":
        CommunityManager.CreateCommunity(map.get("community_name"),
                                         map.get("username"));
        break;
      case "communityDelete":
        CommunityManager.DeleteCommunity(map.get("community_name"));
        break;

      case "communityUpdate":
        CommunityManager.transferCommunityOwnership(map.get("community_name"),
                                                    map.get("username"));
        break;

      case "postCreate":
        PostManager.createNewPost(map.get("post_text"), map.get("username"),
                                  map.get("community_name"));
        break;
      case "postUpdate":
        PostManager.updatePost(map.get("post_id"), map.get("post_text"),
                               map.get("username"), map.get("community_name"));
        break;

      case "postDelete":
        PostManager.deletePost(map.get("post_id"));
        break;
      case "postRead":
        PostManager.readPost(map.get("post_id"));
        break;
      case "postFindFromCommunity":
        PostManager.findPostsFromCommunity(map.get("community_name"));
        break;

      case "postFindFromAccount":
        PostManager.findPostsFromAccount(map.get("username"));
        break;
      default:
        throw new FrontEndUsageException(
            "Front end action type not implemented.") {};
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
