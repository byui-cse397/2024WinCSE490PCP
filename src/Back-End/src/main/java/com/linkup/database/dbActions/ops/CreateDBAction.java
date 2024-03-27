package com.linkup.database.dbActions.ops;

import com.linkup.common.XMLParsing.XMLNode;
import com.linkup.database.dbActions.*;
import com.linkup.database.exceptions.FrontEndUsageException;
import java.util.Map;

/**
 * Abstract class representing a database action to create records.
 * Extends BuildDBAction to inherit common functionality.
 */
public abstract class CreateDBAction extends BuildDBAction {
  /**
   * Builds an SQL query to insert a new record into the database table.
   * @param colValueMap A map containing column names and corresponding values for the new record.
   * @return A string representing the SQL query to insert the new record.
   */
  protected String buildQuery(Map<String, String> colValueMap) {
    // Initialize a StringBuilder to construct the column names part of the SQL query
    StringBuilder columnsBuilder = new StringBuilder();

    // Iterate over the keys (column names) in the colValueMap
    for (String columnName : colValueMap.keySet()) {
      // Append a comma if this is not the first column being added
      if (columnsBuilder.length() > 0) {
        columnsBuilder.append(", ");
      }
      // Append the column name to the StringBuilder
      columnsBuilder.append(columnName);
    }
    // Convert the StringBuilder to a string representing the column names
    String columns = columnsBuilder.toString();

    // Initialize a StringBuilder to construct the values part of the SQL query
    StringBuilder valuesBuilder = new StringBuilder();

    // Iterate over the values in the colValueMap
    for (String value : colValueMap.values()) {
      // Append a comma if this is not the first value being added
      if (valuesBuilder.length() > 0) {
        valuesBuilder.append(", ");
      }
      // Enclose the value in single quotes and append it to the StringBuilder
      valuesBuilder.append("'").append(value).append("'");
    }
    // Convert the StringBuilder to a string representing the values
    String values = valuesBuilder.toString();

    // Construct the SQL query to insert the new record using the table name, columns, and values
    String query = "INSERT INTO " + getTable() + " (" + columns + ")\n"
                   + "VALUES (" + values + ");";
    return query;
  }

  /**
   * Constructs the SQL query to perform the database action based on provided column-value mappings.
   * @return A string representing the SQL query.
   */
  protected String queryBuilder() {
    // Retrieve the column-value mappings for the database action
    Map<String, String> colValueMap = mapHandler(this);
    // Build the SQL query using the column-value mappings
    String query = buildQuery(colValueMap);
    return query;
  }

  /**
   * Removes the "Table" key from the column-value map to prevent unnecessary database operations.
   * @param colValueMap A map containing column names and corresponding values.
   * @return The cleaned column-value map.
   */
  @Override
  protected Map<String, String> cleanMap(Map<String, String> colValueMap) {
    // Remove the "Table" key from the map
    colValueMap.remove("Table");
    return colValueMap;
  }

  /**
   * Performs the database action after performing checks.
   * @return An XMLNode containing the result of the database action.
   * @throws FrontEndUsageException If there is a frontend usage exception.
   */
  public XMLNode<Integer> performDBAction() throws FrontEndUsageException {
    // Check if the necessary conditions for performing the database action are met
    if (checks()) {
      // Build and execute the database action, then return the result
      return (XMLNode<Integer>)actionBuilder();
    }
    // Return null if the checks fail
    return null;
  }
}
