package com.linkup.database.dbActions;

import java.util.Map;

public abstract class EditDBAction extends BuildDBAction {
  public abstract int getID();

  protected abstract String buildQuery(Map<String, String> colValueMap, int id);

  public String queryBuilder() {
    Map<String, String> colValueMap = mapHandler(this);
    int id = getID();
    String query = buildQuery(colValueMap, id);
    return queryHandler(query);
  }

  protected Map<String, String> cleanMap(Map<String, String> colValueMap) {
    colValueMap.remove("Table");
    colValueMap.remove("ID");
    return colValueMap;
  }
}
