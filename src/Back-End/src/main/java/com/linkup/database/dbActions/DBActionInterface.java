package com.linkup.database.dbActions;

import com.linkup.common.XMLParsing.XMLNode;
import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.database.table.*;

public interface DBActionInterface {
  /**
   * Takes an object that implements the DBActionInterface interface and enables
   * the object to communicate with DB by building a SQL query from the
   * variables and values the class has implemented, for more information about
   * how this works search the internet for the term "ORM Wrapper". This method
   * relies on the assumption that our ConnectionManager has already been
   * resolved, if it hasn't been resolved, our host won't be resolved here.
   * @return Returns a DBResult<T> object, a parsed value associated with the
   *     query. The validity and type of these results can be enforced by
   * calling:
   * T result = OBJECT.performDBAction().getResult();
   *
   * CREATE returns an XMLNode<XMLParent> representing the new UserID
   * READ returns an XMLNode<XMLParent> containing the table values
   * UPDATE returns an XMLNode<Integer> representing the number of rows affected
   * by the query
   * DELETE returns an XMLNode<Integer> representing the number of
   * rows affected by the query
   * LOGIN returns an XMLNode<XMLParent> representing
   * the matching user(s).
   *
   *
   * If you have questions about how your object can implement the
   * DBActionInterface consider the developers lifecycle for using
   * DBActionInterface below:
   *
   * 1. Consider the action that you want to implement (CRUD, and extend the
   *    necessary functionality)
   * 2. Add the table that your query affects in getTable()
   * 3. Check the Table.java file to see what values performDBAction expects you
   *    to have variables for, and create those variables in your class
   * 4. Write the logical checks that your functionality should have (I.E.
   *    checking for empty fields like a null value username field for
   *    handling logins), and add those checks to the "checks()" method.
   * 5. Add the call internally to your method to .performDBAction() after your
   *    internal checks have been met
   */
  public XMLNode<?> performDBAction() throws FrontEndUsageException;

  /**
   * Place all of the necessary checks to be run prior to executing
   * .performDBAction() within the checks method, the method expects to return
   * true if all tests passed, otherwise it expects some FrontEndUsageError to
   * be thrown, describing why the check didn't pass.
   * @return True if all tests passed, otherwise false.
   * @throws FrontEndUsageException An exception detailing why this object
   *     shouldn't be added to the database.
   *
   */
  Boolean checks() throws FrontEndUsageException;

  /**
   * Details which table the class action will be performed on.
   * @return The enum from Table.java where your action should be run.
   *
   */
  Table getTable();
}
