package com.linkup.user;

import com.linkup.database.dbActions.ops.UpdateDBAction;

public class UpdateUser extends UpdateDBAction {
  private String username;
  private String password_hash;
  private Integer Id;

  public UpdateUser(Integer Id, String username, String password_hash) {}
}
