package com.linkup.common.XMLParsing.parser;

public class BoolParser implements DBResult<Boolean> {
  @Override
  public void parse(String input) {
    result = "TRUE".equalsIgnoreCase(input);
  }

  private Boolean result;

  @Override
  public Boolean getResult() {
    return result;
  }
}
