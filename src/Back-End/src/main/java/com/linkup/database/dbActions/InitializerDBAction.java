package com.linkup.database.dbActions;

import java.util.Map;

public abstract class InitializerDBAction extends BuildDBAction {
  protected abstract String buildQuery(Map<String, String> colValueMap);

  protected String queryBuilder() {
    Map<String, String> colValueMap = mapHandler(this);
    String query = buildQuery(colValueMap);
    return query;
  }

  @Override
  protected Map<String, String> cleanMap(Map<String, String> colValueMap) {
    colValueMap.remove("Table");
    return colValueMap;
  }
}
