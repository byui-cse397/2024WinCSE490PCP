import static org.junit.Assert.*;

import com.linkup.user.User;
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
    long userId = 123;
    String username = "testUser";
    String email = "test@example.com";
    String password = "password123";
    String confirmationPassword = "password123";
    String deletionReason = "Account closure";

    // Act
    DeleteUser deleteUser =
        new DeleteUser(userId, username, email, password, confirmationPassword,
                       deletionReason);
    deleteUser.confirmDeletion();

    // Assert
    assertEquals(deletionReason, deleteUser.getDeletionReason());
    assertNotNull(deleteUser.getDeletionDate());
  }

  /*
    testInvalidPassword:
      Tests if deletion fails when the confirmation password doesn't match the
    user's password.
  */

  @Test
  public void testInvalidPassword() {
    // Arrange
    long userId = 123;
    String username = "testUser";
    String email = "test@example.com";
    String password = "password123";
    String confirmationPassword = "invalidPassword";
    String deletionReason = "Account closure";

    // Act
    DeleteUser deleteUser =
        new DeleteUser(userId, username, email, password, confirmationPassword,
                       deletionReason);

    // Assert
    assertFalse(deleteUser.validateCredentials());
  }

  /*
    testEmptyDeletionReason:
      Tests if deletion fails when the deletion reason is empty.
  */

  @Test
  public void testEmptyDeletionReason() {
    // Arrange
    long userId = 123;
    String username = "testUser";
    String email = "test@example.com";
    String password = "password123";
    String confirmationPassword = "password123";
    String deletionReason = "";

    // Act
    DeleteUser deleteUser =
        new DeleteUser(userId, username, email, password, confirmationPassword,
                       deletionReason);

    // Assert
    assertFalse(deleteUser.validateCredentials());
  }

  /*
    testNullDeletionDateBeforeConfirmation:
      Tests if the deletion date is null before the deletion is confirmed.
  */

  @Test
  public void testNullDeletionDateBeforeConfirmation() {
    // Arrange
    long userId = 123;
    String username = "testUser";
    String email = "test@example.com";
    String password = "password123";
    String confirmationPassword = "password123";
    String deletionReason = "Account closure";

    // Act
    DeleteUser deleteUser =
        new DeleteUser(userId, username, email, password, confirmationPassword,
                       deletionReason);

    // Assert
    assertNull(deleteUser.getDeletionDate());
  }

  /*
    testDeletionDateAfterConfirmation:
      Tests if the deletion date is set after the deletion is confirmed.
  */

  @Test
  public void testDeletionDateAfterConfirmation() {
    // Arrange
    long userId = 123;
    String username = "testUser";
    String email = "test@example.com";
    String password = "password123";
    String confirmationPassword = "password123";
    String deletionReason = "Account closure";

    // Act
    DeleteUser deleteUser =
        new DeleteUser(userId, username, email, password, confirmationPassword,
                       deletionReason);
    deleteUser.confirmDeletion();
    Date deletionDate = deleteUser.getDeletionDate();

    // Assert
    assertNotNull(deletionDate);
  }
}
