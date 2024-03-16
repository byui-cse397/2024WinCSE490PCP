package com.linkup.database.dbActions;

import java.util.Map;

public abstract class IDBasedDBAction extends BuildDBAction {
  public abstract int getID();

  protected abstract String buildQuery(int id);

  protected String queryBuilder() {
    String query = buildQuery(getID());
    return query;
  }

  protected Map<String, String> cleanMap(Map<String, String> colValueMap) {
    colValueMap.remove("ID");
    return colValueMap;
  }
}
