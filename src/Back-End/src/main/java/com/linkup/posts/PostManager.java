package com.linkup.posts;

import com.linkup.common.XMLParsing.XMLNode;
import com.linkup.common.XMLParsing.XMLParent;
import com.linkup.communities.CommunityManager;
import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.posts.FindPost.FILTER;
import com.linkup.user.UserManager;

public class PostManager {
  public static Integer createNewPost(String postText, String username,
                                      String communityName)
      throws FrontEndUsageException {
    Integer communityId = CommunityManager.getCommunityID(communityName);
    Integer accountId = UserManager.lookupIdByUsername(username);
    return Post.creator(postText, accountId, communityId);
  }

  public static Integer deletePost(String postId)
      throws FrontEndUsageException {
    Integer postIdInt = Integer.parseInt(postId);
    return Post.deleter(postIdInt);
  }

  public static XMLNode<XMLParent> readPost(String postId)
      throws FrontEndUsageException {
    Integer postIdInt = Integer.parseInt(postId);
    return Post.reader(postIdInt);
  }

  public static Integer updatePost(String postId, String postText,
                                   String username, String communityName)
      throws FrontEndUsageException {
    Integer postIdInt = Integer.parseInt(postId);
    Integer communityId = CommunityManager.getCommunityID(communityName);
    Integer accountId = UserManager.lookupIdByUsername(username);
    return Post.updater(postIdInt, postText, accountId, communityId);
  }

  public static XMLNode<XMLParent> findPostsFromCommunity(String communityName)
      throws FrontEndUsageException {
    Integer communityId = CommunityManager.getCommunityID(communityName);
    return Post.findFromCommunityID(communityId);
  }

  public static XMLNode<XMLParent> findPostsFromAccount(String username)
      throws FrontEndUsageException {
    Integer accountId = UserManager.lookupIdByUsername(username);
    return Post.findFromAccountID(accountId);
  }

  public static class Post {
    public static Integer creator(String postText, Integer accountId,
                                  Integer communityId)
        throws FrontEndUsageException {
      CreatePost post = new CreatePost(postText, accountId, communityId);
      XMLNode<Integer> node = post.performDBAction();
      return node.getValue();
    }

    public static XMLNode<XMLParent> findFromCommunityID(Integer Id)
        throws FrontEndUsageException {
      FindPost findFromCommunity = new FindPost(FILTER.COMMUNITY, Id);
      XMLNode<XMLParent> node = findFromCommunity.performDBAction();
      return node;
    }

    public static XMLNode<XMLParent> findFromAccountID(Integer Id)
        throws FrontEndUsageException {
      FindPost findFromAccount = new FindPost(FILTER.COMMUNITY, Id);
      XMLNode<XMLParent> node = findFromAccount.performDBAction();
      return node;
    }

    public static XMLNode<XMLParent> reader(Integer postId)
        throws FrontEndUsageException {
      ReadPost reader = new ReadPost(postId);
      XMLNode<XMLParent> node = reader.performDBAction();
      return node;
    }

    public static Integer updater(Integer postId, String postText,
                                  Integer accountId, Integer communityId)
        throws FrontEndUsageException {
      UpdatePost updater =
          new UpdatePost(postId, postText, accountId, communityId);
      XMLNode<Integer> node = updater.performDBAction();
      return node.getValue();
    }

    public static Integer deleter(Integer postId)
        throws FrontEndUsageException {
      DeletePost deleter = new DeletePost(postId);
      XMLNode<Integer> node = deleter.performDBAction();
      return node.getValue();
    }
  }
}
