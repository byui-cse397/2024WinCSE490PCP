package com.linkup;

import java.util.logging.*;

import com.linkup.database.dbConnection.*;
import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.user.LoginUser;

import com.linkup.common.XMLParsing.*;
import com.linkup.common.XMLParsing.parser.*;

import org.junit.Test;

public class LoginUserTest {
	private static final Logger logger = Logger.getLogger(App.class.getName());

	// Test case for successful authentication
	// This test case checks if the user can successfully authenticate with the
	// correct username and password.
	@Test
	public void testAuthenticateSuccess() {
		// First, establish connection with the DB
		establishDBConnection();
		
		// Then first create a user.
	    User user = new User("user123", "user123@gmail.com", "password123");
	    try {
	      Integer returnValue = (Integer)user.performDBAction().getValue();
	      logger.info("Rows updated: " + returnValue);
	      System.out.println("Rows updated: " + returnValue);
	    } catch (FrontEndUsageException e) {
	      e.printStackTrace();
	      logger.log(Level.SEVERE, "Error Creating User", e);
	      throw e;
	    }
		
	    // User login attempt
		LoginUser loginUser = new LoginUser(123456, "user123", "password123");
		
		try {
			XMLNode result = (XMLNode) loginUser.performDBAction().getValue();
		} catch (FrontEndUsageException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "Error performing database action", e);
			throw e;
		}

		// Delete the user
		
		// And finally, close the connection with the DB
		closeDBConnection();
	}

//  // Test case for unsuccessful authentication (incorrect password)
//  // This test case checks if the user fails to authenticate due to an
//  // incorrect password.
//  @Test
//  public void testAuthenticateFailureIncorrectPassword() {
//    LoginUser loginUser = new LoginUser(123456,"user123", "wrongpassword");
//    assertFalse(loginUser.authenticate());
//  }establishConnectionestablishConnection
//
//  // Test case for unsuccessful authentication (incorrect username)
//  // This test case checks if the user fails to authenticate due to an
//  // incorrect username.
//  @Test
//  public void testAuthenticateFailureIncorrectUsername() {
//    LoginUser loginUser = new LoginUser(123456,"invaliduser", "password123");
//    assertFalse(loginUser.authenticate());
//  }
//
//  // Test case for unsuccessful authentication (empty username)
//  // This test case checks if the user fails to authenticate due to an empty
//  // username.
//  @Test
//  public void testAuthenticateFailureEmptyUsername() {
//    LoginUser loginUser = new LoginUser(123456,"", "password123");
//    assertFalse(loginUser.authenticate());
//  }
//
//  // Test case for unsuccessful authentication (empty password)
//  // This test case checks if the user fails to authenticate due to an empty
//  // password.
//  @Test
//  public void testAuthenticateFailureEmptyPassword() {
//    LoginUser loginUser = new LoginUser(123456,"user123", "");
//    assertFalse(loginUser.authenticate());
//  }

	private static void establishDBConnection() {
		ConnectionManager.getInstance("https://localhost:4039");
		// System.out.println("Connection established with Database.");
		logger.info("Connection established with Database.");
	}

	private static void closeDBConnection() {
		ConnectionManager instance = ConnectionManager.getInstance(null);
		HTTPSConnector connection = instance.getConnector();
		connection.sendRequest("<SYSTEM:string>STOP</SYSTEM>");
		// System.out.println("Closed connection with Database successfully.");
		logger.info("Closed connection with Database successfully.");
	}
}
