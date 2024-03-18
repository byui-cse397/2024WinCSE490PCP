package com.linkup.database.dbActions;

import com.linkup.common.XMLParsing.parser.*;
import com.linkup.database.table.*;

public interface DBActionInterface {
  Table getTable();

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
   * CREATE returns an int representing the new UserID
   * READ returns an XMLNode containing the table values
   * UPDATE returns an int representing the number of rows affected by the query
   * DELETE returns an int representing the number of rows affected by the query
   * LOGIN returns an int representing the UserID
   *
   */
  public DBResult<?> performDBAction();
}
