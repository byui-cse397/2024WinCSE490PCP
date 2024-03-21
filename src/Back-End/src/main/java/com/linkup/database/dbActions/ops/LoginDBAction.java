package com.linkup.database.dbActions.ops;

import com.linkup.common.XMLParsing.XMLNode;
import com.linkup.common.XMLParsing.XMLParent;
import com.linkup.database.dbActions.*;
import com.linkup.database.exceptions.FrontEndUsageException;
import java.util.Map;

/**
 * Abstract class for handling login database actions.
 * Contains methods to build login queries and perform database actions.
 */
public abstract class LoginDBAction extends BuildDBAction {
  /**
   * Builds a login query based on the provided username and password hash.
   * @param colValueMap Map containing username and password hash.
   * @return The constructed SQL query for login.
   */
  protected String buildQuery(Map<String, String> colValueMap) {
    // Retrieve username and password hash from the map
    String username = colValueMap.get("username");
    String password = colValueMap.get("password_hash");

    // Construct the SQL query for login
    StringBuilder sb = new StringBuilder();
    sb.append("SELECT * FROM ")
        .append(getTable())
        .append(" WHERE username = '")
        .append(username)
        .append("' AND password_hash = '")
        .append(password)
        .append("';");
    String query = sb.toString();
    return query;
  }

  /**
   * Builds the login query and returns it.
   * @return The constructed login query.
   */
  protected String queryBuilder() {
    Map<String, String> colValueMap = mapHandler(this);
    String query = buildQuery(colValueMap);
    return query;
  }

  /**
   * Removes the "Table" entry from the column-value map.
   * @param colValueMap Map containing column-value pairs.
   * @return Cleaned column-value map.
   */
  @Override
  protected Map<String, String> cleanMap(Map<String, String> colValueMap) {
    colValueMap.remove("Table");
    return colValueMap;
  }

  /**
   * Performs the database action for login.
   * @return XMLNode containing the result of the database action.
   * @throws FrontEndUsageException If there is a front-end usage exception.
   */
  public XMLNode<XMLParent> performDBAction() throws FrontEndUsageException {
    if (checks()) {
      return (XMLNode<XMLParent>)actionBuilder();
    }
    return null;
  }
}
