package com.linkup.communities;

import com.linkup.database.dbActions.ops.ReadDBAction;
import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.database.table.Table;

public class ReadCommunity extends ReadDBAction {
  int Id;

  public int getID() { return Id; }

  public ReadCommunity(Integer communityId) { this.Id = communityId; }

  @Override
  public Table getTable() {
    return Table.COMMUNITY;
  }

  public Boolean checks() throws FrontEndUsageException { return true; }
}
