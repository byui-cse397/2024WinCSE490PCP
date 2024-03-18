package com.linkup.common.XMLParsing.parser;

public class CharParser implements DBResult<Character> {
  @Override
  public void parse(String input) {
    if (input.length() != 1) {
      throw new IllegalArgumentException(
          "Input string must be a single character");
    }
    result = input.charAt(0);
  }

  private Character result;

  @Override
  public Character getResult() {
    return result;
  }
}
