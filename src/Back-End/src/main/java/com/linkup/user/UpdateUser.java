package com.linkup.user;

import com.linkup.database.dbActions.ops.UpdateDBAction;
import com.linkup.database.exceptions.FrontEndUsageException;
import com.linkup.database.table.Table;

public class UpdateUser extends UpdateDBAction {
  private String username;
  private String password_hash;
  private Integer Id;

  @Override
  public int getID() {
    return Id;
  }

  @Override
  public Table getTable() {
    return Table.ACCOUNT;
  }

  public UpdateUser(Integer id, String username, String password_hash) {
    this.Id = id;
    this.username = username;
    this.password_hash = password_hash;
  }

  @Override
  public Boolean checks() throws FrontEndUsageException {
    nullIdCheck();
    nullUsernameCheck();
    nullPasswordCheck();
    return true;
  }

  public void nullIdCheck() throws FrontEndUsageException {
    if (this.Id == null) {
      throw new FrontEndUsageException("Cannot update user from null ID.") {

      };
    }
  }
  public void nullUsernameCheck() throws FrontEndUsageException {
    if (this.username.isEmpty()) {
      throw new FrontEndUsageException(
          "Cannot change username to a null value.") {

      };
    }
  }
  public void nullPasswordCheck() throws FrontEndUsageException {
    if (this.password_hash.isEmpty()) {
      throw new FrontEndUsageException(
          "Cannot change password to a null value.") {

      };
    }
  }
}
