package com.linkup.CommunityTest;

import static org.junit.Assert.*;

import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.communities.ReadCommunity;
import com.linkup.database.table.Table;

import org.junit.Test;
public class ReadCommunityTest {
    @Test
    public void testGetTable() {
        ReadCommunity readCommunity = new ReadCommunity(1);
        assertEquals(Table.COMMUNITY, readCommunity.getTable());
    }

    @Test
    public void testGetID() {
        int communityId = 1;
        ReadCommunity readCommunity = new ReadCommunity(communityId);
        assertEquals(communityId, readCommunity.getID());
    }

    @Test
    public void testChecks() {
        ReadCommunity readCommunity = new ReadCommunity(1);
        try {
            assertTrue(readCommunity.checks());
        } catch (FrontEndUsageException e) {
            fail("Unexpected FrontEndUsageException thrown: " + e.getMessage());
        }
    }
}
