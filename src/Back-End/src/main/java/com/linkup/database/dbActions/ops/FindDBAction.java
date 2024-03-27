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
public abstract class FindDBAction extends BuildDBAction {
  protected abstract String buildQuery(Map<String, String> colValueMap);

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
