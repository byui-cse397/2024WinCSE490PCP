package com.linkup.common.XMLParsing.parser;

public class BoolParser extends DBResult<Boolean> {
  public BoolParser(String input) { super(input); }

  public Boolean parser(String input) {
    result = "TRUE".equalsIgnoreCase(input);
    return result;
  }
}
