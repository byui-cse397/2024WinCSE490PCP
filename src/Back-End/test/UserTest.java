import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Date;

public class UserTest {
  /*
    testUserCreation: 
    This test ensures that the user object is created correctly with the provided username, email, and password. 
    It checks whether the getters return the expected values and verifies that the registration date is set and the last login date is null.
  */

    @Test
    public void testUserCreation() {
        // Arrange
        String username = "testUser";
        String email = "test@example.com";
        String password = "password123";

        // Act
        User user = new User(username, email, password);

        // Assert
        assertEquals(username, user.getUsername());
        assertEquals(email, user.getEmail());
        assertEquals(password, user.getPassword());
        assertEquals(true, user.isActive());
        assertNotNull(user.getRegistrationDate());
        assertNull(user.getLastLoginDate());
    }
/*
  testUserSettersAndGetters: 
  This test checks the setter and getter methods of the User class for setting and retrieving various attributes such as ID, active status, and last login date.
*/
    @Test
    public void testUserSettersAndGetters() {
        // Arrange
        User user = new User("testUser", "test@example.com", "password123");

        // Act
        user.setId(123);
        user.setActive(false);
        Date lastLoginDate = new Date();
        user.setLastLoginDate(lastLoginDate);

        // Assert
        assertEquals(123, user.getId());
        assertEquals(false, user.isActive());
        assertEquals(lastLoginDate, user.getLastLoginDate());
    }

  /*
    testUserRegistrationDate: 
    This test verifies that the registration date remains unchanged when attempting to set it to a new date. 
    It ensures that the registration date is immutable after object creation.
  */

    @Test
    public void testUserRegistrationDate() {
        // Arrange
        User user = new User("testUser", "test@example.com", "password123");
        Date registrationDate = user.getRegistrationDate();

        // Act
        user.setRegistrationDate(new Date());

        // Assert
        assertEquals(registrationDate, user.getRegistrationDate());
    }

  /*
    testUserEmailValidation: 
    This test checks if the user email remains unchanged when setting an invalid email address.
  */

    @Test
    public void testUserEmailValidation() {
        // Arrange
        User user = new User("testUser", "test@example.com", "password123");

        // Act
        user.setEmail("invalid-email");

        // Assert
        assertEquals("test@example.com", user.getEmail());
    }

  /*
    testUserPasswordStrength: 
    This test ensures that the password remains unchanged when setting a weak password. 
    It validates that the password strength is maintained.
  */

    @Test
    public void testUserPasswordStrength() {
        // Arrange
        User user = new User("testUser", "test@example.com", "password123");

        // Act
        user.setPassword("weak");

        // Assert
        assertEquals("password123", user.getPassword());
    }
}
