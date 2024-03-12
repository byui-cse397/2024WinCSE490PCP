package com.linkup.database;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public interface DBAction {
  Table getTable();

  ActionType getActionType();

  int getID(); // We use an ID for Reading, Updating and Deleting. Creating can
               // just return 0.

  public static Map<String, String> performDBAction(DBAction obj) {
    Map<String, String> colValueMap = new HashMap<>();

    Field[] fields = obj.getClass().getDeclaredFields();

    for (Field field : fields) {
      try {
        // Access private fields
        field.setAccessible(true);
        Object value = field.get(obj);
        colValueMap.put(field.getName(), String.valueOf(value));
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      }
    }
    colValueMap.remove("ActionType");
    colValueMap.remove("Table");
    String id = colValueMap.remove("ID");
    ActionType action = obj.getActionType();
    Table table = obj.getTable();
    action.performAction(table, colValueMap, id);
    return colValueMap;
  }
}
