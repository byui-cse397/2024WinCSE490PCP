package com.linkup.database;

import com.linkup.database.*;
import com.linkup.database.dbConnection.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public interface DBAction {
  Table getTable();

  ActionType getActionType();

  int getID(); // We use an ID for Reading, Updating and Deleting. Creating can
               // just return 0.

  /**
   * Takes an object that implements the DBAction interface and enables the
   * object to communicate with DB by building a SQL query from the variables
   * and values the class has implemented. This method relies on the assumption
   * that our ConnectionManager has already been resolved, if it hasn't been
   * resolved, our host won't be resolved here.
   * @param obj The DBAction object to build the SQL query for.
   * @return The xml serialized SQL query for the DBAction object as a String.
   *
   */
  public static String performDBAction(DBAction obj) {
    Map<String, String> colValueMap = objToMap(obj);
    ActionType action = obj.getActionType();
    Table table = obj.getTable();
    String id = String.valueOf(obj.getID());
    String query = action.buildQuery(table, colValueMap, id);
    String serialized = xmlQuerySerializer(query);
    ConnectionManager manager = ConnectionManager.getInstance(null);
    String result = sendXMLQuery(manager.getConnector(), serialized);
    return result;
  }

  /**
   * Parses our object for the column names in our SQL table.
   * @param obj
   * @return
   *
   */
  private static Map<String, String> objToMap(DBAction obj) {
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
    colValueMap.remove("ID");
    return colValueMap;
  }

  /**
   * After building the query we need to serialize it to send to DB,
   * xmlQuerySerializer enables the user to serialize the DBAction SQL query as
   * xml-like information.
   * @param query The SQL query to be serialized.
   * @return The serialization compatible SQL query.
   *
   */
  private static String xmlQuerySerializer(String query) {
    StringBuilder sb = new StringBuilder();
    sb.append("<query:string>").append(query).append("</query>");
    return sb.toString();
  }

  private static String sendXMLQuery(HTTPSConnector dbConnection,
                                     String query) {
    return dbConnection.sendRequest(query);
  }
}
