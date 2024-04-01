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

    // Mock Community.CommunityFinder
    try {
      CommunityManager.CommunityFinder("CommunityName");
    } catch (FrontEndUsageException e) {
      fail("Exception thrown: " + e.getMessage());
    }

    // Mock Community.CommunityUpdater
    try {
      CommunityManager.CommunityUpdater("CommunityName", 1, 123);
    } catch (FrontEndUsageException e) {
      fail("Exception thrown: " + e.getMessage());
    }

    // Mock Community.CommunityDeleter
    try {
      CommunityManager.CommunityDeleter(1);
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
      CommunityManager.CommunityFinder("CommunityName");
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
      CommunityManager.CommunityFinder("CommunityName");
    } catch (FrontEndUsageException e) {
      fail("Exception thrown: " + e.getMessage());
    }

    // Mock Community.CommunityReader
    try {
      CommunityManager.CommunityReader(1);
    } catch (FrontEndUsageException e) {
      fail("Exception thrown: " + e.getMessage());
    }

    // Assert
    assertNull(CommunityManager.getParentAccountId("NonExistingCommunity"));
  }

  @Test
  public void testTransferCommunityOwnership() throws FrontEndUsageException {
    // Mock UserManager.lookupIdByUsername
    try {
      UserManager.lookupIdByUsername("newUsername");
    } catch (FrontEndUsageException e) {
      fail("Exception thrown: " + e.getMessage());
    }

    // Mock Community.CommunityFinder
    try {
      CommunityManager.CommunityFinder("CommunityName");
    } catch (FrontEndUsageException e) {
      fail("Exception thrown: " + e.getMessage());
    }

    // Mock Community.CommunityUpdater
    try {
      CommunityManager.CommunityUpdater("CommunityName", 1, 123);
    } catch (FrontEndUsageException e) {
      fail("Exception thrown: " + e.getMessage());
    }

    // Assert
    assertEquals(Integer.valueOf(1),
                 CommunityManager.transferCommunityOwnership("CommunityName",
                                                             "newUsername"));
  }

  @Test
  public void testDeleteCommunity() throws FrontEndUsageException {
    // Mock Community.CommunityFinder
    try {
      CommunityManager.CommunityFinder("CommunityName");
    } catch (FrontEndUsageException e) {
      fail("Exception thrown: " + e.getMessage());
    }

    // Mock Community.CommunityDeleter
    try {
      CommunityManager.CommunityDeleter(1);
    } catch (FrontEndUsageException e) {
      fail("Exception thrown: " + e.getMessage());
    }

    // Assert
    assertEquals(Integer.valueOf(1),
                 CommunityManager.DeleteCommunity("CommunityName"));
  }
}
