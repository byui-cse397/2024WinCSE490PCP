package com.linkup.database.dbActions.ops;

import com.linkup.database.dbActions.*;

public abstract class ReadDBAction extends IDBasedDBAction {
  protected String buildQuery(int id) {
    String where = BuildDBAction.buildWhere(id);
    String query = "SELECT * FROM " + getTable() + where;
    return query;
  }
}
