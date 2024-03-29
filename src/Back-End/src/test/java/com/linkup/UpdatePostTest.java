package com.linkup;

import static org.junit.Assert.*;

import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.posts.UpdatePost;
import org.junit.Test;
public class UpdatePostTest {
    @Test
    public void testValidPostUpdate() throws FrontEndUsageException {
        // Arrange
        UpdatePost updatePost = new UpdatePost(123, "Updated post text", 456, 789);

        // Act
        boolean result = updatePost.checks();

        // Assert
        assertTrue(result);
    }

    @Test(expected = FrontEndUsageException.class)
    public void testNullPostText() throws FrontEndUsageException {
        // Arrange
        UpdatePost updatePost = new UpdatePost(123, null, 456, 789);

        // Act
        updatePost.checks();
    }

    @Test(expected = FrontEndUsageException.class)
    public void testEmptyPostText() throws FrontEndUsageException {
        // Arrange
        UpdatePost updatePost = new UpdatePost(123, "", 456, 789);

        // Act
        updatePost.checks();
    }

    @Test(expected = FrontEndUsageException.class)
    public void testNullAccountId() throws FrontEndUsageException {
        // Arrange
        UpdatePost updatePost = new UpdatePost(123, "Updated post text", null, 789);

        // Act
        updatePost.checks();
    }

    @Test(expected = FrontEndUsageException.class)
    public void testInvalidAccountId() throws FrontEndUsageException {
        // Arrange
        UpdatePost updatePost = new UpdatePost(123, "Updated post text", 0, 789);

        // Act
        updatePost.checks();
    }

    @Test(expected = FrontEndUsageException.class)
    public void testNullCommunityId() throws FrontEndUsageException {
        // Arrange
        UpdatePost updatePost = new UpdatePost(123, "Updated post text", 456, null);

        // Act
        updatePost.checks();
    }

    @Test(expected = FrontEndUsageException.class)
    public void testInvalidCommunityId() throws FrontEndUsageException {
        // Arrange
        UpdatePost updatePost = new UpdatePost(123, "Updated post text", 456, 0);

        // Act
        updatePost.checks();
    }
}
