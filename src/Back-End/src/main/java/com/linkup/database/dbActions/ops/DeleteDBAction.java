package com.linkup.database.dbActions.ops;

import com.linkup.database.dbActions.*;

public abstract class DeleteDBAction extends IDBasedDBAction {
  protected String buildQuery(int id) {
    String where = BuildDBAction.buildWhere(id);
    String query = "DELETE FROM " + getTable() + where;
    return query;
  }
}
