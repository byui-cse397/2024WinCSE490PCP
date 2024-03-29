package com.linkup;

import static org.junit.Assert.*;

import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.posts.FindPost;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
public class FindPostTest {
    @Test
    public void testFindPostByAccount() {
        // Arrange
        FindPost findPost = new FindPost(FindPost.FILTER.ACCOUNTS, 123);

        // Act
        String query = findPost.buildQuery(createColValueMap(findPost));

        // Assert
        assertEquals("SELECT * FROM POST WHERE accounts_id = 123;", query);
    }

    @Test
    public void testFindPostByCommunity() {
        // Arrange
        FindPost findPost = new FindPost(FindPost.FILTER.COMMUNITY, 456);

        // Act
        String query = findPost.buildQuery(createColValueMap(findPost));

        // Assert
        assertEquals("SELECT * FROM POST WHERE community_id = 456;", query);
    }

    private Map<String, String> createColValueMap(FindPost findPost) {
        Map<String, String> colValueMap = new HashMap<>();
        colValueMap.put("operation", findPost.operation);
        colValueMap.put("filterValue", String.valueOf(findPost.filterValue));
        return colValueMap;
    }
}
