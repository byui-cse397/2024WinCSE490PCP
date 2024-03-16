package com.linkup.database.dbActions;

import com.linkup.database.*;

public interface DBActionInterface {
  Table getTable();

  /**
   * Takes an object that implements the DBAction interface and enables the
   * object to communicate with DB by building a SQL query from the variables
   * and values the class has implemented. This method relies on the assumption
   * that our ConnectionManager has already been resolved, if it hasn't been
   * resolved, our host won't be resolved here.
   * @param obj The DBAction object to build the SQL query for.
   * @return The xml serialized SQL query for the DBAction object as a String.
   *
   */
  public String performDBAction();
}
