package com.linkup.common.XMLParsing.parser;

public class IntParser implements DBResult<Integer> {
  @Override
  public void parse(String input) {
    result = Integer.parseInt(input);
  }

  private Integer result;

  @Override
  public Integer getResult() {
    return result;
  }
}
