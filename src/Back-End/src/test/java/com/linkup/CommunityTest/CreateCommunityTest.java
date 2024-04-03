package com.linkup.CommunityTest;

import static org.junit.Assert.*;

import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.communities.CreateCommunity;
import com.linkup.database.table.Table;

import org.junit.Test;

public class CreateCommunityTest {
    @Test
    public void testGetTable() {
        CreateCommunity createCommunity = new CreateCommunity("Test Community", 1);
        assertEquals(Table.COMMUNITY, createCommunity.getTable());
    }

    @Test
    public void testChecks_NullName() {
        CreateCommunity createCommunity = new CreateCommunity(null, 1);
        try {
            createCommunity.checks();
            fail("Expected FrontEndUsageException not thrown");
        } catch (FrontEndUsageException e) {
            assertEquals("Community must have a name.", e.getMessage());
        }
    }

    @Test
    public void testChecks_NameTooLong() {
        CreateCommunity createCommunity = new CreateCommunity("A".repeat(256), 1);
        try {
            createCommunity.checks();
            fail("Expected FrontEndUsageException not thrown");
        } catch (FrontEndUsageException e) {
            assertEquals("Community name is too long.", e.getMessage());
        }
    }

    @Test
    public void testChecks_ValidInputs() {
        CreateCommunity createCommunity = new CreateCommunity("Test Community", 1);
        try {
            assertTrue(createCommunity.checks());
        } catch (FrontEndUsageException e) {
            fail("Unexpected FrontEndUsageException thrown: " + e.getMessage());
        }
    }
}
