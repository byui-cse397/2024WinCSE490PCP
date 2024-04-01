package com.linkup;

import static org.junit.Assert.*;

import com.linkup.communities.FindCommunity;
import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.database.table.Table;
import java.util.Map;
import org.junit.Test;

public class FindCommunityTest {
  @Test
  public void testGetTable() {
    FindCommunity findCommunity = new FindCommunity("test_community");
    assertEquals(Table.COMMUNITY, findCommunity.getTable());
  }

  @Test
  public void testChecks() {
    FindCommunity findCommunity = new FindCommunity("test_community");
    try {
      assertTrue(findCommunity.checks());
    } catch (FrontEndUsageException e) {
      fail("Unexpected FrontEndUsageException thrown: " + e.getMessage());
    }
  }
}
