package com.linkup.common.XMLParsing.parser;

public class DoubleParser implements DBResult<Double> {
  @Override
  public void parse(String input) {
    result = Double.parseDouble(input);
  }

  private Double result;

  @Override
  public Double getResult() {
    return result;
  }
}
