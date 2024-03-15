package com.linkup.httpsserver;

public enum CommandType {
  SYSTEM,
  QUERY,
  NULL;

  public static CommandType fromString(String name) {
    try {
      return CommandType.valueOf(name.toUpperCase());
    } catch (IllegalArgumentException e) {
      return CommandType.NULL;
    }
  }
}
