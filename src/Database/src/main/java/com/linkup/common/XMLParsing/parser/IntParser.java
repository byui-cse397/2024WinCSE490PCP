package com.linkup.common.XMLParsing.parser;

public class IntParser extends DBResult<Integer> {
  public IntParser(String input) { super(input); }

  public Integer parser(String input) {
    result = Integer.parseInt(input);
    return result;
  }
}
