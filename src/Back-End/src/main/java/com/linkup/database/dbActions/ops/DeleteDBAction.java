package com.linkup.database.dbActions.ops;

import com.linkup.common.XMLParsing.XMLNode;
import com.linkup.database.dbActions.*;
import com.linkup.database.exceptions.FrontEndUsageException;
import java.util.Map;

/**
 * Abstract class representing a database action to delete records.
 * Extends BuildDBAction to inherit common functionality.
 */
public abstract class DeleteDBAction extends BuildDBAction {
  /**
   * Builds an SQL query to delete a record from the database table based on its
   * ID.
   * @param id The ID of the record to be deleted.
   * @return A string representing the SQL query to delete the record.
   */
  protected String buildQuery(int id) {
    String where = BuildDBAction.buildWhere(id);
    String query = "DELETE FROM " + getTable() + where + ";";
    return query;
  }

  /**
   * Abstract method to retrieve the ID of the record to be deleted.
   * @return The ID of the record to be deleted.
   */
  public abstract int getID();

  /**
   * Constructs the SQL query to perform the database action.
   * @return A string representing the SQL query.
   */
  protected String queryBuilder() {
    String query = buildQuery(getID());
    return query;
  }

  /**
   * Removes the "ID" key from the column-value map to prevent unnecessary
   * database operations.
   * @param colValueMap A map containing column names and corresponding values.
   * @return The cleaned column-value map.
   */
  protected Map<String, String> cleanMap(Map<String, String> colValueMap) {
    colValueMap.remove("ID");
    return colValueMap;
  }

  /**
   * Performs the database action after performing checks.
   * @return An XMLNode containing the result of the database action.
   * @throws FrontEndUsageException If there is a frontend usage exception.
   */
  public XMLNode<Integer> performDBAction() throws FrontEndUsageException {
    if (checks()) {
      return (XMLNode<Integer>)actionBuilder();
    }
    return null;
  }
}
