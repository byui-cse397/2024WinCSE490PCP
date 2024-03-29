package com.linkup;

import static org.junit.Assert.*;

import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.communities.FindCommunity;
import com.linkup.database.table.Table;

import org.junit.Test;

import java.util.Map;

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

    @Test
    public void testBuildQuery() {
        FindCommunity findCommunity = new FindCommunity("test_community");
        String expectedQuery = "SELECT * FROM COMMUNITY WHERE community_name REGEXP 'test_community';";
        assertEquals(expectedQuery, findCommunity.buildQuery(Map.of("community_name", "test_community")));
    }

}
