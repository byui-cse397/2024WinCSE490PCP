package com.linkup.CommunityTest;

import static org.junit.Assert.*;

import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.communities.UpdateCommunity;
import com.linkup.database.table.Table;

import org.junit.Test;
public class UpdateCommunityTest {
    @Test
    public void testGetTable() {
        UpdateCommunity updateCommunity = new UpdateCommunity("Updated Community", 1, 1);
        assertEquals(Table.COMMUNITY, updateCommunity.getTable());
    }

    @Test
    public void testGetID() {
        int communityId = 1;
        UpdateCommunity updateCommunity = new UpdateCommunity("Updated Community", communityId, 1);
        assertEquals(communityId, updateCommunity.getID());
    }

    @Test
    public void testChecks_NullName() {
        UpdateCommunity updateCommunity = new UpdateCommunity(null, 1, 1);
        try {
            updateCommunity.checks();
            fail("Expected FrontEndUsageException not thrown");
        } catch (FrontEndUsageException e) {
            assertEquals("Community must have a name.", e.getMessage());
        }
    }

    @Test
    public void testChecks_NameTooLong() {
        UpdateCommunity updateCommunity = new UpdateCommunity("A".repeat(256), 1, 1);
        try {
            updateCommunity.checks();
            fail("Expected FrontEndUsageException not thrown");
        } catch (FrontEndUsageException e) {
            assertEquals("Community name is too long.", e.getMessage());
        }
    }

    @Test
    public void testChecks_ValidInputs() {
        UpdateCommunity updateCommunity = new UpdateCommunity("Updated Community", 1, 1);
        try {
            assertTrue(updateCommunity.checks());
        } catch (FrontEndUsageException e) {
            fail("Unexpected FrontEndUsageException thrown: " + e.getMessage());
        }
    }
}
