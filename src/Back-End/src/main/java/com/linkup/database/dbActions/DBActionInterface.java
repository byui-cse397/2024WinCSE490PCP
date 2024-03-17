package com.linkup.database.dbActions;

import com.linkup.common.XMLParsing.parser.*;
import com.linkup.database.table.*;

public interface DBActionInterface {
  Table getTable();

  /**
   * Takes an object that implements the DBAction interface and enables the
   * object to communicate with DB by building a SQL query from the variables
   * and values the class has implemented. This method relies on the assumption
   * that our ConnectionManager has already been resolved, if it hasn't been
   * resolved, our host won't be resolved here.
   * @param obj The DBAction object to build the SQL query for.
   * @return Returns the parser object with
   *
   */
  public Parser<?> performDBAction();
}
