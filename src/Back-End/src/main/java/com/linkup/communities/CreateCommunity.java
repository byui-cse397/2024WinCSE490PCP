package com.linkup.communities;

import com.linkup.database.dbActions.ops.CreateDBAction;
import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.database.table.Table;

public class CreateCommunity extends CreateDBAction {
  String community_name;
  Integer parent_account_id;

  public CreateCommunity(String communityName, Integer userId) {
    this.community_name = communityName;
    parent_account_id = userId;
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
