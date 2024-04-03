package com.linkup.PostTest;
import static org.junit.Assert.*;

import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.posts.DeletePost;
import java.util.Date;
import org.junit.Test;
public class DeletePostTest {
    @Test
    public void testValidPostDeletion() throws FrontEndUsageException {
        // Arrange
        DeletePost deletePost = new DeletePost(123);

        // Act
        boolean result = deletePost.checks();

        // Assert
        assertTrue(result);
    }

    @Test(expected = FrontEndUsageException.class)
    public void testNullPostId() throws FrontEndUsageException {
        // Arrange
        DeletePost deletePost = new DeletePost(null);

        // Act
        deletePost.checks();
    }

    @Test(expected = FrontEndUsageException.class)
    public void testInvalidPostId() throws FrontEndUsageException {
        // Arrange
        DeletePost deletePost = new DeletePost(0);

        // Act
        deletePost.checks();
    }
}
