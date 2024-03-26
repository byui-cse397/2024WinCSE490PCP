package com.linkup.communities;

import com.linkup.database.dbActions.ops.DeleteDBAction;
import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.database.table.Table;

public class DeleteCommunity extends DeleteDBAction {
  int Id;

  public int getID() { return Id; }

  public DeleteCommunity(Integer communityID) { this.Id = communityID; }

  @Override
  public Table getTable() {
    return Table.COMMUNITY;
  }

  public Boolean checks() throws FrontEndUsageException { return true; }
}
