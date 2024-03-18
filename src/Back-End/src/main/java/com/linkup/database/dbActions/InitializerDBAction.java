package com.linkup.database.dbActions;

import com.linkup.common.XMLParsing.parser.DBResult;
import com.linkup.common.XMLParsing.parser.ParserFactory;
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

  public DBResult<Integer> performDBAction() {
    String query = queryBuilder();
    String queryResults = queryHandler(query);
    DBResult<Integer> dbResult =
        (DBResult<Integer>)ParserFactory.getParser("Int");
    dbResult.parse(queryResults);
    return dbResult;
  }
}
