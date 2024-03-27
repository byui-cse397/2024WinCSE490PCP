package com.linkup.posts;

import com.linkup.database.dbActions.ops.FindDBAction;
import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.database.table.Table;
import java.util.Map;

public class FindPost extends FindDBAction {
  private String operation;
  private Integer filterValue;

  public FindPost(FILTER operation, Integer filterValue) {
    this.operation = operation.name().toLowerCase();
    this.filterValue = filterValue;
  }

  @Override
  public Table getTable() {
    return Table.POST;
  }

  @Override
  public Boolean checks() throws FrontEndUsageException {
    return true;
  }

  @Override
  protected String buildQuery(Map<String, String> colValueMap) {
    String operation = colValueMap.get("operation") + "_id";
    String filterValue = colValueMap.get("filterValue");
    StringBuilder sb = new StringBuilder();
    sb.append("SELECT * FROM ")
        .append(getTable())
        .append(" WHERE ")
        .append(operation)
        .append(" = ")
        .append(filterValue)
        .append(";");
    String query = sb.toString();
    return query;
  }

  static enum FILTER {
    ACCOUNTS,
    COMMUNITY,
  }
}
