package com.linkup;

import static org.junit.Assert.*;

import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.posts.FindPost;
import com.linkup.posts.FindPost.FILTER;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class FindPostTest {
  @Test
  public void testFindPostByAccount() {
    // Arrange
    FindPost findPost = new FindPost(FILTER.ACCOUNTS, 123);
    try {
      findPost.checks();
    } catch (FrontEndUsageException e) {
      fail("Unexpected FEException.");
    }
  }

  @Test
  public void testFindPostByCommunity() {
    // Arrange
    FindPost findPost = new FindPost(FindPost.FILTER.COMMUNITY, 456);
    try {
      findPost.checks();
    } catch (FrontEndUsageException e) {
      fail("Unexpected FEException.");
    }
  }
}
