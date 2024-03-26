package com.linkup.communities;

import com.linkup.database.dbActions.ops.UpdateDBAction;
import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.database.table.Table;

public class UpdateCommunity extends UpdateDBAction {
  String community_name;
  int Id;

  public int getID() { return Id; }

  public UpdateCommunity(String newCommunityName, Integer communityID) {
    this.community_name = newCommunityName;
    this.Id = communityID;
  }

  @Override
  public Table getTable() {
    return Table.COMMUNITY;
  }

  public Boolean checks() throws FrontEndUsageException {
    nullNameCheck();
    nameTooLongCheck();
    return true;
  }

  private void nullNameCheck() throws FrontEndUsageException {
    if (this.community_name == null) {
      throw new FrontEndUsageException("Community must have a name.") {

      };
    }
  }

  private void nameTooLongCheck() throws FrontEndUsageException {
    if (community_name.length() > 255) {
      throw new FrontEndUsageException("Community name is too long.") {

      };
    }
  }
}
