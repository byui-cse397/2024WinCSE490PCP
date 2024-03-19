package com.linkup.database.dbActions;

import com.linkup.common.XMLParsing.XMLNode;
import com.linkup.common.XMLParsing.XMLParser;
import com.linkup.common.XMLParsing.parser.DBResult;
import com.linkup.database.dbConnection.*;
import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.database.table.*;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class BuildDBAction implements DBActionInterface {
  public abstract Table getTable();

  /**
   * Parses our object for the column names in our SQL table.
   * @param obj
   * @return
   *
   */
  protected Map<String, String> objToMap(DBActionInterface obj) {
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
    return colValueMap;
  }

  protected abstract String queryBuilder();

  protected abstract Map<String, String>
  cleanMap(Map<String, String> colValueMap);

  protected Map<String, String> mapHandler(DBActionInterface obj) {
    Map<String, String> objMap = objToMap(obj);
    objMap = cleanMap(objMap);
    objMap = checkForDependencies(objMap);
    return objMap;
  }

  protected Map<String, String> checkForDependencies(Map<String, String> map) {
    Table table = getTable();
    ArrayList<String> fields = table.getFields();
    map = renameKeysCaseInsensitively(map, fields);
    Map<String, String> reducedMap = new HashMap<>();
    for (String field : fields) {
      if (map.containsKey(field)) {
        reducedMap.put(field, map.get(field));
      } else {
        throw new IllegalArgumentException("The object" + this.toString() +
                                           "must have the field: " + field);
      }
    }
    return reducedMap;
  }

  /**
   * After building the query we need to serialize it to send to DB,
   * xmlQuerySerializer enables the user to serialize the DBAction SQL query
   * as xml-like information.
   * @param query The SQL query to be serialized.
   * @return The serialization compatible SQL query.
   *
   */
  protected String xmlQuerySerializer(String query) {
    StringBuilder sb = new StringBuilder();
    sb.append("<query:string>").append(query).append("</query>");
    return sb.toString();
  }

  protected String queryHandler(String query) {
    String serialized = xmlQuerySerializer(query);
    ConnectionManager manager = ConnectionManager.getInstance(null);
    String result = sendXMLQuery(manager.getConnector(), serialized);
    return result;
  }

  protected String sendXMLQuery(HTTPSConnector dbConnection, String query) {
    return dbConnection.sendRequest(query);
  }

  protected static String buildWhere(int id) {
    StringBuilder whereBuilder = new StringBuilder("\nWHERE ");
    whereBuilder.append("ID")
        .append(" = '")
        .append(String.valueOf(id))
        .append("'");
    String where = whereBuilder.toString();
    return where;
  }

  private static Map<String, String>
  renameKeysCaseInsensitively(Map<String, String> map,
                              ArrayList<String> fields) {
    Map<String, String> tempMap = new HashMap<>();
    for (String field : fields) {
      for (Map.Entry<String, String> entry : map.entrySet()) {
        if (entry.getKey().equalsIgnoreCase(field)) {
          tempMap.put(field, entry.getValue());
        }
      }
    }
    map.clear();
    map.putAll(tempMap);
    return map;
  }

  protected XMLNode actionBuilder() {
    String query = queryBuilder();
    String queryResults = queryHandler(query);
    try {
      XMLNode node = new XMLParser(queryResults, null).parse();
      return node;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  public XMLNode performDBAction() throws FrontEndUsageException {
    if (!checks()) {
      return null;
    }
    return actionBuilder();
  }
}
