package com.linkup.PostTest;

import static org.junit.Assert.*;

import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.posts.CreatePost;
import java.util.Date;
import org.junit.Test;

public class CreatePostTest {
    @Test
    public void testValidPostCreation() throws FrontEndUsageException {
        // Arrange
        CreatePost createPost = new CreatePost("Valid post text", 123, 456);

        // Act
        boolean result = createPost.checks();

        // Assert
        assertTrue(result);
    }

    @Test(expected = FrontEndUsageException.class)
    public void testNullPostText() throws FrontEndUsageException {
        // Arrange
        CreatePost createPost = new CreatePost(null, 123, 456);

        // Act
        createPost.checks();
    }

    @Test(expected = FrontEndUsageException.class)
    public void testEmptyPostText() throws FrontEndUsageException {
        // Arrange
        CreatePost createPost = new CreatePost("", 123, 456);

        // Act
        createPost.checks();
    }

    @Test(expected = FrontEndUsageException.class)
    public void testNullAccountId() throws FrontEndUsageException {
        // Arrange
        CreatePost createPost = new CreatePost("Valid post text", null, 456);

        // Act
        createPost.checks();
    }

    @Test(expected = FrontEndUsageException.class)
    public void testInvalidAccountId() throws FrontEndUsageException {
        // Arrange
        CreatePost createPost = new CreatePost("Valid post text", 0, 456);

        // Act
        createPost.checks();
    }

    @Test(expected = FrontEndUsageException.class)
    public void testNullCommunityId() throws FrontEndUsageException {
        // Arrange
        CreatePost createPost = new CreatePost("Valid post text", 123, null);

        // Act
        createPost.checks();
    }

    @Test(expected = FrontEndUsageException.class)
    public void testInvalidCommunityId() throws FrontEndUsageException {
        // Arrange
        CreatePost createPost = new CreatePost("Valid post text", 123, 0);

        // Act
        createPost.checks();
    }
}
