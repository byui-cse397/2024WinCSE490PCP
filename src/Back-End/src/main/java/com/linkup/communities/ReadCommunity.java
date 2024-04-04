package com.linkup.communities;

import com.linkup.database.dbActions.ops.ReadDBAction;
import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.database.table.Table;

public class ReadCommunity extends ReadDBAction {
  Integer Id;

  public int getID() { return Id; }

  public ReadCommunity(Integer communityId) { this.Id = communityId; }

  @Override
  public Table getTable() {
    return Table.COMMUNITY;
  }

  public void nullCommunityIdCheck() throws FrontEndUsageException {
    if (Id == null | Id == 0) {
      throw new FrontEndUsageException(
          "Id cannot be null in community deletion.") {

      };
    }
  }

  public Boolean checks() throws FrontEndUsageException {
    nullCommunityIdCheck();
    return true;
  }
}
