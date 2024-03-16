package com.linkup.database.dbActions.ops;

import com.linkup.database.dbActions.*;
import java.util.Map;

public abstract class CreateDBAction extends InitializerDBAction {
  protected String buildQuery(Map<String, String> colValueMap) {
    StringBuilder columnsBuilder = new StringBuilder();
    for (String columnName : colValueMap.keySet()) {
      if (columnsBuilder.length() > 0) {
        columnsBuilder.append(", ");
      }
      columnsBuilder.append(columnName);
    }
    String columns = columnsBuilder.toString();

    StringBuilder valuesBuilder = new StringBuilder();
    for (String value : colValueMap.values()) {
      if (valuesBuilder.length() > 0) {
        valuesBuilder.append(", ");
      }
      valuesBuilder.append("'").append(value).append("'");
    }
    String values = valuesBuilder.toString();
    String query = "INSERT INTO " + getTable() + " (" + columns + ")\n"
                   + "VALUES (" + values + ");";
    return query;
  }
}
