package com.linkup.common.XMLParsing.parser;

public class FloatParser implements DBResult<Float> {
  @Override
  public void parse(String input) {
    result = Float.parseFloat(input);
  }

  private Float result;

  @Override
  public Float getResult() {
    return result;
  }
}
