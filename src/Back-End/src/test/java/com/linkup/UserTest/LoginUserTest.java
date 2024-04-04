package com.linkup.UserTest;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.user.LoginUser;
import org.junit.Test;

public class LoginUserTest {

  // Test case for successful authentication
  // This test case checks if the user can successfully authenticate with the
  // correct username and password.
  @Test
  public void testAuthenticateSuccess() {
    LoginUser loginUser = new LoginUser("user123", "password123");
    try {
      assertTrue(loginUser.checks());
    } catch (FrontEndUsageException e) {
      fail("An unexpected FrontEndUsageException was thrown.");
    }
  }

  // Test case for unsuccessful authentication (missing password)
  // This test case checks if the user fails to authenticate due to an
  // incorrect password.
  @Test
  public void testAuthenticateFailureIncorrectPassword() {
    LoginUser loginUser = new LoginUser("user123", "");
    boolean exceptionCaught = false;
    try {
      loginUser.checks();
    } catch (FrontEndUsageException e) {
      assertEquals("Empty password provided for authentication.",
                   e.getMessage());
      exceptionCaught = true;
    }
    if (!exceptionCaught) {
      fail("Expected FrontEndUsageException was not thrown.");
    }
  }

  // Test case for unsuccessful authentication (missing username)
  // This test case checks if the user fails to authenticate due to an
  // incorrect username.
  @Test
  public void testAuthenticateFailureIncorrectUsername() {
    LoginUser loginUser = new LoginUser("", "password123");
    boolean exceptionCaught = false;
    try {
      loginUser.checks();
    } catch (FrontEndUsageException e) {
      assertEquals("Empty username provided for authentication.",
                   e.getMessage());
      exceptionCaught = true;
    }
    if (!exceptionCaught) {
      fail("Expected FrontEndUsageException was not thrown.");
    }
  }
}
