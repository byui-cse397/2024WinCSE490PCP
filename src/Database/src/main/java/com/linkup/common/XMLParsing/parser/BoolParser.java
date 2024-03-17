package com.linkup.common.XMLParsing.parser;

public class BoolParser implements Parser<Boolean> {
  @Override
  public Boolean parse(String input) {
    return "TRUE".equalsIgnoreCase(input);
  }
}
