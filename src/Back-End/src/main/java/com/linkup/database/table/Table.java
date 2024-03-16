package com.linkup.database.table;

import java.util.ArrayList;

public enum Table {
  ACCOUNT {
    public ArrayList<String> getFields() {
      ArrayList<String> list = new ArrayList<>();
      list.add("username");
      list.add("password_hash");
      return list;
    }
  },
  POST;

  public abstract ArrayList<String> getFields();

  @Override
  public String toString() {
    return this.name();
  }
}
