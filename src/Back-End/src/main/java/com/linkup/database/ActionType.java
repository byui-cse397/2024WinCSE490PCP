package com.linkup.database;
import java.util.Map;

public enum ActionType {
  CREATE {
    @Override
    public String buildQuery(Table table, Map<String, String> colValueMap,
                             String id) {
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

      String query = "INSERT INTO " + table + " (" + columns + ")\n"
                     + "VALUES (" + values + ");";
      return query;
    }
  },
  READ {
    @Override
    public String buildQuery(Table table, Map<String, String> colValueMap,
                             String id) {
      String where = ActionType.buildWhere(id);
      String query = "SELECT * FROM " + table + where;
      return query;
    }
  },
  UPDATE {
    @Override
    public String buildQuery(Table table, Map<String, String> colValueMap,
                             String id) {
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
      String where = ActionType.buildWhere(id);
      String query = "UPDATE " + table + setClause + where;

      return query;
    }
  },
  DELETE {
    @Override
    public String buildQuery(Table table, Map<String, String> colValueMap,
                             String id) {
      String where = ActionType.buildWhere(id);
      String query = "DELETE FROM " + table + where;
      return query;
    }
  };

  @Override
  public String toString() {
    return this.name();
  }

  public abstract String buildQuery(Table table,
                                    Map<String, String> colValueMap, String id);

  private static String buildWhere(String id) {
    StringBuilder whereBuilder = new StringBuilder("\nWHERE ");
    whereBuilder.append("ID").append(" = '").append(id).append("'");
    String where = whereBuilder.toString();
    return where;
  }
}
