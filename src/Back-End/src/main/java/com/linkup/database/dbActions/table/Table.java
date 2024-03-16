package com.linkup.database;

import java.util.ArrayList;

public enum Table {
  ACCOUNT,
  POST;

  @Override
  public String toString() {
    return this.name();
  }
}
