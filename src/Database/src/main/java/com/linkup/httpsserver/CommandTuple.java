package com.linkup.httpsserver;

public class CommandTuple {
  private final CommandType commandType;
  private final String commandValue;

  public CommandTuple(CommandType type, String commandValue) {
    this.commandType = type;
    this.commandValue = commandValue;
  }

  public CommandType getCommandType() { return commandType; }

  public String getCommandValue() { return commandValue; }
}
