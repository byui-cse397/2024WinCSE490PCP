package com.linkup.common.XMLParsing.parser;

public class StringParser implements DBResult<String> {
  @Override
  public void parse(String input) {
    result = input;
  }

  private String result;

  @Override
  public String getResult() {
    return result;
  }
}
