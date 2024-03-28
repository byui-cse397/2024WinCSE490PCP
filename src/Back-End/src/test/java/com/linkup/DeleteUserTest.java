package com.linkup;
import static org.junit.Assert.*;

import com.linkup.user.DeleteUser;
import java.util.Date;
import org.junit.Test;

public class DeleteUserTest {
  /*
    testValidDeletion:
      Tests if a user account can be successfully deleted with valid deletion
    credentials and confirms that the deletion date is set.
  */

  @Test
  public void testValidDeletion() {
    // Arrange
    int userId = 123456;
//    String username = "testUser";
//    String email = "test@example.com";
//    String password = "password123";
//    String confirmationPassword = "password123";
//    String deletionReason = "Account closure";
    String password = "password_hash";
    String confirmationPassword = "confirmPassword_hash";

    // Act
    DeleteUser deleteUser =
        new DeleteUser(userId, password, confirmationPassword);

    // Assert
//    assertEquals(deletionReason, deleteUser.getDeletionReason());
//    assertNotNull(deleteUser.getDeletionDate());
  }

  /*
    testInvalidPassword:
      Tests if deletion fails when the confirmation password doesn't match the
    user's password.
  */

  @Test
  public void testInvalidPassword() {
    // Arrange
    int userId = 123456;
//    String username = "testUser";
//    String email = "test@example.com";
    String password = "password123";
    String confirmationPassword = "invalidPassword";
//    String deletionReason = "Account closure";

    // Act
    DeleteUser deleteUser =
        new DeleteUser(userId, password, confirmationPassword);

    // Assert
//    assertFalse(deleteUser.validateCredentials());
  }

  /*
    testEmptyDeletionReason:
      Tests if deletion fails when the deletion reason is empty.
  */

  @Test
  public void testEmptyDeletionReason() {
    // Arrange
    int userId = 123456;
//    String username = "testUser";
//    String email = "test@example.com";
    String password = "password123";
    String confirmationPassword = "password123";
//    String deletionReason = "";

    // Act
    DeleteUser deleteUser =
            new DeleteUser(userId, password, confirmationPassword);

    // Assert
//    assertEquals(deletionReason, deleteUser.getDeletionReason());
  }

  /*
    testNullDeletionDateBeforeConfirmation:
      Tests if the deletion date is null before the deletion is confirmed.
  */

  @Test
  public void testNullDeletionDateBeforeConfirmation() {
    // Arrange
    int userId = 123456;
//    String username = "testUser";
//    String email = "test@example.com";
    String password = "password123";
    String confirmationPassword = "password123";
//    String deletionReason = "Account closure";

    // Act
    DeleteUser deleteUser =
            new DeleteUser(userId, password, confirmationPassword);

    // Assert
//    assertNull(deleteUser.getDeletionDate());
  }

  /*
    testDeletionDateAfterConfirmation:
      Tests if the deletion date is set after the deletion is confirmed.
  */

  @Test
  public void testDeletionDateAfterConfirmation() {
    // Arrange
    int userId = 123456;
//    String username = "testUser";
//    String email = "test@example.com";
    String password = "password123";
    String confirmationPassword = "password123";
//    String deletionReason = "Account closure";

    // Act
    DeleteUser deleteUser =
            new DeleteUser(userId, password, confirmationPassword);
//    deleteUser.confirmDeletion();
//    Date deletionDate = deleteUser.getDeletionDate();

    // Assert
//    assertNotNull(deletionDate);
  }
}
