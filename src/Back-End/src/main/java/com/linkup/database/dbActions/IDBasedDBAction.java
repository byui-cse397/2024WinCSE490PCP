package com.linkup.database.dbActions;

import com.linkup.common.XMLParsing.XMLNode;
import com.linkup.common.XMLParsing.parser.DBResult;
import com.linkup.common.XMLParsing.parser.ParserFactory;
import java.util.Map;

public abstract class IDBasedDBAction extends BuildDBAction {
  public abstract int getID();

  protected abstract String buildQuery(int id);

  protected String queryBuilder() {
    String query = buildQuery(getID());
    return query;
  }

  protected Map<String, String> cleanMap(Map<String, String> colValueMap) {
    colValueMap.remove("ID");
    return colValueMap;
  }

  public DBResult<XMLNode> performDBAction() {
    String query = queryBuilder();
    String queryResults = queryHandler(query);
    DBResult<XMLNode> dbResult =
        (DBResult<XMLNode>)ParserFactory.getParser("XMLNode");
    dbResult.parse(queryResults);
    return dbResult;
  }
}
