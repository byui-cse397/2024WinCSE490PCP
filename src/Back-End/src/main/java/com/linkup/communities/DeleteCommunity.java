package com.linkup.communities;

import com.linkup.database.dbActions.ops.DeleteDBAction;
import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.database.table.Table;

public class DeleteCommunity extends DeleteDBAction {
  Integer Id;

  public int getID() { return Id; }

  public DeleteCommunity(Integer communityID) { this.Id = communityID; }

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
