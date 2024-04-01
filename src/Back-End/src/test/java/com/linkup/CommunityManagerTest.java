package com.linkup;

import static org.junit.Assert.*;

import com.linkup.communities.CommunityManager;
import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.user.UserManager;
import org.junit.Test;

public class CommunityManagerTest {
  @Test
  public void testCreateCommunity() throws FrontEndUsageException {
    // Mock UserManager.lookupIdByUsername
    try {
      UserManager.lookupIdByUsername("username");
    } catch (FrontEndUsageException e) {
      fail("Exception thrown: " + e.getMessage());
    }

    // Mock Community.CommunityCreator
    try {
      CommunityManager.CreateCommunity("CommunityName", "username");
    } catch (FrontEndUsageException e) {
      fail("Exception thrown: " + e.getMessage());
    }

    // Assert
    assertEquals(Integer.valueOf(1),
                 CommunityManager.CreateCommunity("CommunityName", "username"));
  }

  @Test
  public void testGetCommunityID() throws FrontEndUsageException {
    // Mock Community.CommunityFinder
    try {
      CommunityManager.getCommunityID("CommunityName");
    } catch (FrontEndUsageException e) {
      fail("Exception thrown: " + e.getMessage());
    }

    // Assert
    assertNull(CommunityManager.getCommunityID("NonExistingCommunity"));
  }

  @Test
  public void testGetParentAccountId() throws FrontEndUsageException {
    // Mock Community.CommunityFinder
    try {
      CommunityManager.getParentAccountId("CommunityName");
    } catch (FrontEndUsageException e) {
      fail("Exception thrown: " + e.getMessage());
    }
  }

  @Test
  public void testTransferCommunityOwnership() throws FrontEndUsageException {
    // Mock UserManager.lookupIdByUsername
    try {
      UserManager.lookupIdByUsername("newUsername");
    } catch (FrontEndUsageException e) {
      fail("Exception thrown: " + e.getMessage());
    }
  }

  @Test
  public void testDeleteCommunity() throws FrontEndUsageException {
    // Mock Community.CommunityFinder
  }
}
