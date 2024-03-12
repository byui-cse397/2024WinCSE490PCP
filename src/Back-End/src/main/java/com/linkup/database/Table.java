package com.linkup.database;

public enum Table {
  ACCOUNT,
  POST;

  @Override
  public String toString() {
    return this.name();
  }
}
