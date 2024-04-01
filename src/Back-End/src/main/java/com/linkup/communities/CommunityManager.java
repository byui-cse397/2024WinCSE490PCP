package com.linkup.communities;

import com.linkup.common.XMLParsing.XMLNode;
import com.linkup.common.XMLParsing.XMLParent;
import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.user.UserManager;

public class CommunityManager {
  public static Integer CreateCommunity(String communityName, String username)
      throws FrontEndUsageException {
    Integer userId = UserManager.lookupIdByUsername(username);
    Community.CommunityCreator(communityName, userId);
    Integer communityID = Community.CommunityFinder(communityName);
    Integer rows_affected =
        Community.CommunityCreator(communityName, communityID);
    return rows_affected;
  }

  public static Integer getCommunityID(String communityName)
      throws FrontEndUsageException {
    Integer communityID = Community.CommunityFinder(communityName);
    if (communityID <= 0) {
      return null;
    }
    XMLNode<XMLParent> tableNode =
        (XMLNode<XMLParent>)Community.CommunityReader(communityID);
    XMLNode<XMLParent> rowNode =
        (XMLNode<XMLParent>)tableNode.getValue().getChildren().get(0);
    for (XMLNode<?> child : rowNode.getValue().getChildren()) {
      if (child.getTagName().equalsIgnoreCase("id")) {
        return (Integer)child.getValue();
      }
    }
    return 0;
  }

  public static Integer getParentAccountId(String communityName)
      throws FrontEndUsageException {
    Integer communityID = Community.CommunityFinder(communityName);
    if (communityID <= 0) {
      return null;
    }
    XMLNode<XMLParent> tableNode =
        (XMLNode<XMLParent>)Community.CommunityReader(communityID);
    XMLNode<XMLParent> rowNode =
        (XMLNode<XMLParent>)tableNode.getValue().getChildren().get(0);
    for (XMLNode<?> child : rowNode.getValue().getChildren()) {
      if (child.getTagName().equalsIgnoreCase("parent_account_id")) {
        return (Integer)child.getValue();
      }
    }
    return 0;
  }

  public static Integer transferCommunityOwnership(String communityName,
                                                   String newUsername)
      throws FrontEndUsageException {
    Integer newUserId = UserManager.lookupIdByUsername(newUsername);
    Integer communityId = Community.CommunityFinder(communityName);
    Integer rowsAffected =
        Community.CommunityUpdater(communityName, communityId, newUserId);
    return rowsAffected;
  }

  public static Integer DeleteCommunity(String communityName)
      throws FrontEndUsageException {
    Integer communityId = Community.CommunityFinder(communityName);
    Integer rows_affected = Community.CommunityDeleter(communityId);
    return rows_affected;
  }

  private static class Community {
    public static Integer CommunityCreator(String communityName, Integer userId)
        throws FrontEndUsageException {
      CreateCommunity creator = new CreateCommunity(communityName, userId);
      XMLNode<Integer> node = creator.performDBAction();
      return node.getValue();
    }

    private static XMLNode<XMLParent> CommunityReader(Integer communityID)
        throws FrontEndUsageException {
      ReadCommunity reader = new ReadCommunity(communityID);
      XMLNode<XMLParent> parentNode = reader.performDBAction();
      return parentNode;
    }

    private static Integer CommunityUpdater(String communityName,
                                            Integer communityId, Integer userId)
        throws FrontEndUsageException {
      UpdateCommunity updater =
          new UpdateCommunity(communityName, communityId, userId);
      XMLNode<Integer> node = updater.performDBAction();
      return node.getValue();
    }

    private static Integer CommunityFinder(String communityName)
        throws FrontEndUsageException {
      FindCommunity finder = new FindCommunity(communityName);
      XMLNode<XMLParent> tableNode = finder.performDBAction();
      XMLNode<XMLParent> rowNode =
          (XMLNode<XMLParent>)tableNode.getValue().getChildren().get(0);
      Integer communityId = null;
      for (XMLNode<?> node : rowNode.getValue().getChildren()) {
        if (node.getTagName().equalsIgnoreCase("id")) {
          communityId = (Integer)node.getValue();
        }
      }
      return communityId;
    }

    private static Integer CommunityDeleter(Integer communityId)
        throws FrontEndUsageException {
      DeleteCommunity deleter = new DeleteCommunity(communityId);
      XMLNode<Integer> node = deleter.performDBAction();
      return node.getValue();
    }
  }
}
