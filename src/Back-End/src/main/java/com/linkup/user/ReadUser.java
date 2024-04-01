package com.linkup.user;

import com.linkup.database.dbActions.ops.ReadDBAction;
import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.database.table.Table;

public class ReadUser extends ReadDBAction {
  private Integer Id;

  public ReadUser(Integer userId) { this.Id = userId; }

  @Override
  public Table getTable() {
    return Table.ACCOUNT;
  }

  @Override
  public int getID() {
    return this.Id;
  }

  @Override
  public Boolean checks() throws FrontEndUsageException {
    nullIdCheck();
    return true;
  }

  public void nullIdCheck() throws FrontEndUsageException {
    if (this.Id == null) {
      throw new FrontEndUsageException("Cannot read user from null ID.") {

      };
    }
  }
}
