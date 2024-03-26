package com.linkup.user;

import com.linkup.database.dbActions.ops.FindDBAction;
import com.linkup.database.exceptions.FrontEndUsageException;
import java.util.Map;

public class FindUser extends FindDBAction {
  private String username;

  public FindUser(String username) { this.username = username; }

  @Override
  public Boolean checks() throws FrontEndUsageException {
    nullUserCheck();
    return true;
  }

  public void nullUserCheck() throws FrontEndUsageException {
    if (this.username == null | this.username.length() == 0) {
      throw new FrontEndUsageException("Username supplied was null.") {

      };
    }
  }

  @Override
  protected String buildQuery(Map<String, String> colValueMap) {
    String username = colValueMap.get("username");
    StringBuilder sb = new StringBuilder();
    sb.append("SELECT * FROM ")
        .append(getTable())
        .append(" WHERE username = '")
        .append(username)
        .append("';");
    String query = sb.toString();
    return query;
  }
}
