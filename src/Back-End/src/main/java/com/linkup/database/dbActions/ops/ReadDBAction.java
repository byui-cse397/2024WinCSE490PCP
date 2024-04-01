package com.linkup.database.dbActions.ops;

import com.linkup.common.XMLParsing.XMLNode;
import com.linkup.common.XMLParsing.XMLParent;
import com.linkup.database.dbActions.*;
import com.linkup.database.exceptions.FrontEndUsageException;
import java.util.Map;

/**
 * Represents an abstract class for reading data from the database.
 */
public abstract class ReadDBAction extends BuildDBAction {
  /**
   * Builds the SQL query for retrieving data based on the provided ID.
   * @param id The ID used to filter the database query.
   * @return The SQL query for reading data.
   */
  protected String buildQuery(int id) {
    String where = BuildDBAction.buildWhere(id);
    String query = "SELECT * FROM " + getTable() + where + ";";
    return query;
  }

  /**
   * Abstract method to get the ID for retrieving data.
   * @return The ID used to retrieve data.
   */
  public abstract int getID();

  /**
   * Builds the SQL query for reading data based on the provided ID.
   * @return The SQL query for reading data.
   */
  protected String queryBuilder() {
    String query = buildQuery(getID());
    return query;
  }

  /**
   * Removes the "ID" key from the column-value map.
   * @param colValueMap The map containing column-value pairs.
   * @return The cleaned map without the "ID" key.
   */
  protected Map<String, String> cleanMap(Map<String, String> colValueMap) {
    colValueMap.remove("ID");
    return colValueMap;
  }

  /**
   * Performs the database action of reading data.
   * @return The XML node containing the read data.
   * @throws FrontEndUsageException If there is a front-end usage exception.
   */
  public XMLNode<XMLParent> performDBAction() throws FrontEndUsageException {
    if (checks()) {
      return (XMLNode<XMLParent>)actionBuilder();
    }
    return null;
  }
}
