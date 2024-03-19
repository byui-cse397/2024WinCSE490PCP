package com.linkup.database.dbActions.ops;

import com.linkup.database.dbActions.*;
import java.util.Map;

public abstract class UpdateDBAction extends BuildDBAction {
  protected String buildQuery(Map<String, String> colValueMap, int id) {
    StringBuilder setClauseBuilder = new StringBuilder("\nSET ");
    for (Map.Entry<String, String> entry : colValueMap.entrySet()) {
      if (setClauseBuilder.length() > 6) {
        setClauseBuilder.append(", ");
      }
      setClauseBuilder.append(entry.getKey())
          .append(" = '")
          .append(entry.getValue())
          .append("'");
    }
    String setClause = setClauseBuilder.toString();
    String where = BuildDBAction.buildWhere(id);
    String query = "UPDATE " + getTable() + setClause + where;
    return query;
  }

  public abstract int getID();

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
