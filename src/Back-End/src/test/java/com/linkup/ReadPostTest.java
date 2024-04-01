package com.linkup;

import static org.junit.Assert.*;

import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.posts.ReadPost;
import org.junit.Test;
public class ReadPostTest {
    @Test
    public void testValidPostReading() throws FrontEndUsageException {
        // Arrange
        ReadPost readPost = new ReadPost(123);

        // Act
        boolean result = readPost.checks();

        // Assert
        assertTrue(result);
    }

    @Test(expected = FrontEndUsageException.class)
    public void testNullPostId() throws FrontEndUsageException {
        // Arrange
        ReadPost readPost = new ReadPost(null);

        // Act
        readPost.checks();
    }

    @Test(expected = FrontEndUsageException.class)
    public void testInvalidPostId() throws FrontEndUsageException {
        // Arrange
        ReadPost readPost = new ReadPost(0);

        // Act
        readPost.checks();
    }
}
