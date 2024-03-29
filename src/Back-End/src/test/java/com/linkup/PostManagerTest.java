package com.linkup;

import static org.junit.Assert.*;

import com.linkup.common.XMLParsing.XMLNode;
import com.linkup.common.XMLParsing.XMLParent;
import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.posts.PostManager;
import org.junit.Test;

public class PostManagerTest {
    @Test
    public void testReadPost() {
        // Arrange
        String postId = "123";

        // Act
        XMLNode<XMLParent> result = null;
        try {
            result = PostManager.readPost(postId);
        } catch (FrontEndUsageException e) {
            fail("Exception thrown: " + e.getMessage());
        }

        // Assert
        assertNotNull(result);
        assertEquals("123", result.getValue()); // Assuming XMLNode has a getId() method
        // Add more assertions based on the expected structure/content of the XMLNode
    }

    @Test(expected = FrontEndUsageException.class)
    public void testReadPostWithInvalidId() throws FrontEndUsageException {
        // Arrange
        String postId = "invalid_id";

        // Act
        XMLNode<XMLParent> result = PostManager.readPost(postId);

        // Assert
        assertNull(result); // This line won't be reached due to the expected exception
    }
}
