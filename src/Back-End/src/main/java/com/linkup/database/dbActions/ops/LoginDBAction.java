package com.linkup.database.dbActions.ops;

import com.linkup.common.XMLParsing.XMLNode;
import com.linkup.common.XMLParsing.XMLParent;
import com.linkup.database.dbActions.*;
import com.linkup.database.exceptions.FrontEndUsageException;
import java.util.Map;

public abstract class LoginDBAction extends BuildDBAction {
  protected String buildQuery(Map<String, String> colValueMap) {
    String username = colValueMap.get("username");
    String password = colValueMap.get("password_hash");
    StringBuilder sb = new StringBuilder();
    sb.append("SELECT * FROM ")
        .append(getTable())
        .append(" WHERE username = '")
        .append(username)
        .append("' AND password_hash = '")
        .append(password)
        .append("';");
    String query = sb.toString();
    return query;
  }

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

  public XMLNode<XMLParent> performDBAction() throws FrontEndUsageException {
    if (checks()) {
      return (XMLNode<XMLParent>)actionBuilder();
    }
    return null;
  }
}
