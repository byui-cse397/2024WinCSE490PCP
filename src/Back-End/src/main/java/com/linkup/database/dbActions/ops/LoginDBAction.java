package com.linkup.database.dbActions.ops;

import com.linkup.database.dbActions.*;
import java.util.Map;

public abstract class LoginDBAction extends InitializerDBAction {
  protected String buildQuery(Map<String, String> colValueMap) {
    String username = colValueMap.get("username");
    String password = colValueMap.get("password");
    StringBuilder sb = new StringBuilder();
    sb.append("SELECT * FROM ")
        .append(getTable())
        .append(" WHERE username = ")
        .append(username)
        .append(" AND password_hash = ")
        .append(password);
    String query = sb.toString();
    return query;
  }
}
