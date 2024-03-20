package com.linkup.database.dbActions.ops;

import com.linkup.database.dbActions.*;
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
}
