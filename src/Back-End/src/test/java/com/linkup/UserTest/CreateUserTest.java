package com.linkup.UserTest;

import static org.junit.Assert.*;

import com.linkup.user.CreateUser;
import java.util.Date;
import org.junit.Test;

public class CreateUserTest {
  /*
    testCreateUserCreation:
    This test ensures that the user object is created correctly with the
    provided username, email, and password. It checks whether the getters return
    the expected values and verifies that the registration date is set and the
    last login date is null.
  */

  @Test
  public void testCreateUserCreation() {
    // Arrange
    String username = "testCreateUser";
    String email = "test@example.com";
    String password = "password123";

    // Act
    CreateUser user = new CreateUser(username, email, password);

    // Assert
    assertEquals(username, user.getUsername());
    assertEquals(email, user.getEmail());
    assertEquals(password, user.getPassword());
    assertEquals(true, user.isActive());
    assertNotNull(user.getRegistrationDate());
    assertNull(user.getLastLoginDate());
  }
  /*
    testCreateUserSettersAndGetters:
    This test checks the setter and getter methods of the CreateUser class for
    setting and retrieving various attributes such as ID, active status, and
    last login date.
  */
  @Test
  public void testCreateUserSettersAndGetters() {
    // Arrange
    CreateUser user =
        new CreateUser("testCreateUser", "test@example.com", "password123");

    // Act
    user.setActive(false);
    Date lastLoginDate = new Date();
    user.setLastLoginDate(lastLoginDate);

    // Assert
    assertEquals(false, user.isActive());
    assertEquals(lastLoginDate, user.getLastLoginDate());
  }

  /*
    testCreateUserRegistrationDate:
    This test verifies that the registration date remains unchanged when
    attempting to set it to a new date. It ensures that the registration date is
    immutable after object creation.
  */

  @Test
  public void testCreateUserRegistrationDate() {
    // Arrange
    CreateUser user =
        new CreateUser("testCreateUser", "test@example.com", "password123");
    Date registrationDate = user.getRegistrationDate();

    // Act
    user.setRegistrationDate(new Date());

    // Assert
    assertEquals(registrationDate, user.getRegistrationDate());
  }

  /*
    testCreateUserEmailValidation:
    This test checks if the user email remains unchanged when setting an invalid
    email address.
  */

  @Test
  public void testCreateUserEmailValidation() {
    // Arrange
    CreateUser user =
        new CreateUser("testCreateUser", "test@example.com", "password123");

    // Act
    user.setEmail("invalid-email");

    // Assert
    assertEquals("test@example.com", user.getEmail());
  }

  /*
    testCreateUserPasswordStrength:
    This test ensures that the password remains unchanged when setting a weak
    password. It validates that the password strength is maintained.
  */

  @Test
  public void testCreateUserPasswordStrength() {
    // Arrange
    CreateUser user =
        new CreateUser("testCreateUser", "test@example.com", "password123");

    // Act
    user.setPassword("weak");

    // Assert
    assertEquals("password123", user.getPassword());
  }
}
