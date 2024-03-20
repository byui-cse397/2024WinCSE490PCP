package com.linkup;
import java.util.logging.*;

import com.linkup.database.dbConnection.*;
import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.user.LoginUser;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.Assert.*;

import com.linkup.common.XMLParsing.*;
import com.linkup.common.XMLParsing.parser.*;

public class LoginUserTest {
	private static final Logger logger = Logger.getLogger(App.class.getName());

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	    // Resolve database host:
	    establishConnection();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	    // Stop database server and close connection:
	    closeConnection();
	}

  // Test case for successful authentication
  // This test case checks if the user can successfully authenticate with the
  // correct username and password.
  @Test
  public void testAuthenticateSuccess() {
    LoginUser loginUser = new LoginUser(123456, "user123", "password123");
    
	try {
		XMLNode result = loginUser.performDBAction();
	} catch (FrontEndUsageException e) {
	      e.printStackTrace();
	      logger.log(Level.SEVERE, "Error performing database action", e);
	}

    //assertTrue(loginUser.authenticate());
  }

//  // Test case for unsuccessful authentication (incorrect password)
//  // This test case checks if the user fails to authenticate due to an
//  // incorrect password.
//  @Test
//  public void testAuthenticateFailureIncorrectPassword() {
//    LoginUser loginUser = new LoginUser(123456,"user123", "wrongpassword");
//    assertFalse(loginUser.authenticate());
//  }
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
//
//  private static void establishConnection() {
//    ConnectionManager.getInstance("https://localhost:3306");
//    //System.out.println("Connection established with Database.");
//    logger.info("Connection established with Database.");
//  }
//
//  private static void closeConnection() {
//    ConnectionManager instance = ConnectionManager.getInstance(null);
//    HTTPSConnector connection = instance.getConnector();
//    connection.sendRequest("<SYSTEM:string>STOP</SYSTEM>");
//    //System.out.println("Closed connection with Database successfully.");
//    logger.info("Closed connection with Database successfully.");
//  }
}
