package com.linkup.database.dbActions.ops;

import com.linkup.common.XMLParsing.XMLNode;
import com.linkup.database.dbActions.*;
import com.linkup.database.exceptions.FrontEndUsageException;
import java.util.Map;

public abstract class DeleteDBAction extends BuildDBAction {
  protected String buildQuery(int id) {
    String where = BuildDBAction.buildWhere(id);
    String query = "DELETE FROM " + getTable() + where + ";";
    return query;
  }

  public abstract int getID();

  protected String queryBuilder() {
    String query = buildQuery(getID());
    return query;
  }

  protected Map<String, String> cleanMap(Map<String, String> colValueMap) {
    colValueMap.remove("ID");
    return colValueMap;
  }

  public XMLNode<Integer> performDBAction() throws FrontEndUsageException {
    if (checks()) {
      return (XMLNode<Integer>)actionBuilder();
    }
    return null;
  }
}
