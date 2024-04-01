package com.linkup;

import static org.junit.Assert.*;

import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.communities.DeleteCommunity;
import com.linkup.database.table.Table;

import org.junit.Test;
public class DeleteCommunityTest {
    @Test
    public void testGetTable() {
        DeleteCommunity deleteCommunity = new DeleteCommunity(1);
        assertEquals(Table.COMMUNITY, deleteCommunity.getTable());
    }

    @Test
    public void testGetID() {
        int communityId = 1;
        DeleteCommunity deleteCommunity = new DeleteCommunity(communityId);
        assertEquals(communityId, deleteCommunity.getID());
    }

    @Test
    public void testChecks() {
        DeleteCommunity deleteCommunity = new DeleteCommunity(1);
        try {
            assertTrue(deleteCommunity.checks());
        } catch (FrontEndUsageException e) {
            fail("Unexpected FrontEndUsageException thrown: " + e.getMessage());
        }
    }

}
