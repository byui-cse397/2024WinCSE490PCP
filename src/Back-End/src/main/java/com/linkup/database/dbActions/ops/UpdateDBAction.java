package com.linkup.database.dbActions.ops;

import com.linkup.database.dbActions.*;
import java.util.Map;

public abstract class UpdateDBAction extends EditDBAction {
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
}
