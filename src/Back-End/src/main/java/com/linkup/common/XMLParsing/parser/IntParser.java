package com.linkup.common.XMLParsing.parser;

public class IntParser implements Parser<Integer> {
  @Override
  public Integer parse(String input) {
    return Integer.parseInt(input);
  }
}
