package com.linkup.communities;

import com.linkup.database.dbActions.ops.FindDBAction;
import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.database.table.Table;
import java.util.Map;

public class FindCommunity extends FindDBAction {
  String community_name;

  public FindCommunity(String communityName) {
    this.community_name = communityName;
  }

  @Override
  public Table getTable() {
    return Table.COMMUNITY;
  }

  public Boolean checks() throws FrontEndUsageException { return true; }

  protected String buildQuery(Map<String, String> colValueMap) {
    String communityName = colValueMap.get("community_name");

    StringBuilder sb = new StringBuilder();
    sb.append("SELECT * FROM ")
        .append(getTable())
        .append(" WHERE community_name = '")
        .append(communityName)
        .append("';");
    String query = sb.toString();
    return query;
  }
}
