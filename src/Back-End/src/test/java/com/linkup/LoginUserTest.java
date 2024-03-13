package test.java.com.linkup;

import static org.junit.Assert.*;

import main.java.com.linkup.user.LoginUser;
import org.junit.Test;

public class LoginUserTest {

  // Test case for successful authentication
  // This test case checks if the user can successfully authenticate with the
  // correct username and password.
  @Test
  public void testAuthenticateSuccess() {
    LoginUser loginUser = new LoginUser("user123", "password123");
    assertTrue(loginUser.authenticate());
  }

  // Test case for unsuccessful authentication (incorrect password)
  // This test case checks if the user fails to authenticate due to an
  // incorrect password.
  @Test
  public void testAuthenticateFailureIncorrectPassword() {
    LoginUser loginUser = new LoginUser("user123", "wrongpassword");
    assertFalse(loginUser.authenticate());
  }

  // Test case for unsuccessful authentication (incorrect username)
  // This test case checks if the user fails to authenticate due to an
  // incorrect username.
  @Test
  public void testAuthenticateFailureIncorrectUsername() {
    LoginUser loginUser = new LoginUser("invaliduser", "password123");
    assertFalse(loginUser.authenticate());
  }

  // Test case for unsuccessful authentication (empty username)
  // This test case checks if the user fails to authenticate due to an empty
  // username.
  @Test
  public void testAuthenticateFailureEmptyUsername() {
    LoginUser loginUser = new LoginUser("", "password123");
    assertFalse(loginUser.authenticate());
  }

  // Test case for unsuccessful authentication (empty password)
  // This test case checks if the user fails to authenticate due to an empty
  // password.
  @Test
  public void testAuthenticateFailureEmptyPassword() {
    LoginUser loginUser = new LoginUser("user123", "");
    assertFalse(loginUser.authenticate());
  }
}