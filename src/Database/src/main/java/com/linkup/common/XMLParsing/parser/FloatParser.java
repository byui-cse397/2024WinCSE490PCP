package com.linkup.common.XMLParsing.parser;

public class FloatParser implements Parser<Float> {
  @Override
  public Float parse(String input) {
    return Float.parseFloat(input);
  }
}
