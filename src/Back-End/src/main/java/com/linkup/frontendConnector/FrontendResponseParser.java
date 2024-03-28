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

  public static XMLNode<?> parseMessage(String message)
      throws FrontEndUsageException {
    try {
      Map<String, String> map = new HashMap<String, String>();
      XMLParser parser = new XMLParser(message, null);
      XMLNode<XMLParent> node = (XMLNode<XMLParent>)parser.parse();
      ArrayList<XMLNode<?>> data = node.getValue().getChildren();
      for (XMLNode<?> datum : data) {
        map.put(datum.getTagName(), datum.getValue().toString());
      }
      Integer rowsAffected;
      XMLNode<?> result;
      switch (node.getTagName()) {
      case "userLogin":
        Integer value = UserManager.loginHandler(map.get("username"),
                                                 map.get("password_hash"));
        result = new XMLNode<Integer>("user_id", "integer", value.toString());
        break;
      case "userCreate":
        Integer userId = UserManager.createNewUser(
            map.get("username"), map.get("email"), map.get("password_hash"));
        result = new XMLNode<Integer>("user_id", "integer", userId.toString());
        break;
      case "communityCreate":
        Integer communityId = CommunityManager.CreateCommunity(
            map.get("community_name"), map.get("username"));
        result = new XMLNode<Integer>("community_id", "integer",
                                      communityId.toString());
        break;
      case "communityDelete":
        rowsAffected =
            CommunityManager.DeleteCommunity(map.get("community_name"));
        result = new XMLNode<Integer>("rows_affected", "integer",
                                      rowsAffected.toString());
        break;
      case "communityUpdate":
        rowsAffected = CommunityManager.transferCommunityOwnership(
            map.get("community_name"), map.get("username"));
        result = new XMLNode<Integer>("rows_affected", "integer",
                                      rowsAffected.toString());
        break;

      case "postCreate":
        rowsAffected =
            PostManager.createNewPost(map.get("post_text"), map.get("username"),
                                      map.get("community_name"));
        result =
            new XMLNode<Integer>("post_id", "integer", rowsAffected.toString());
        break;
      case "postUpdate":
        rowsAffected = PostManager.updatePost(
            map.get("post_id"), map.get("post_text"), map.get("username"),
            map.get("community_name"));
        result = new XMLNode<Integer>("rows_affected", "integer",
                                      rowsAffected.toString());
        break;

      case "postDelete":
        rowsAffected = PostManager.deletePost(map.get("post_id"));
        result = new XMLNode<Integer>("rows_affected", "integer",
                                      rowsAffected.toString());
        break;
      case "postRead":
        result = PostManager.readPost(map.get("post_id"));
        break;
      case "postFindFromCommunity":
        result = PostManager.findPostsFromCommunity(map.get("community_name"));
        break;

      case "postFindFromAccount":
        result = PostManager.findPostsFromAccount(map.get("username"));
        break;
      default:
        result = null;
        throw new FrontEndUsageException(
            "Front end action type not implemented.") {};
      }
      return result;

    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }
}
