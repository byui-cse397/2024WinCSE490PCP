package com.linkup.XMLParsing.parser;

public class DoubleParser implements Parser<Double> {
  @Override
  public Double parse(String input) {
    return Double.parseDouble(input);
  }
}
