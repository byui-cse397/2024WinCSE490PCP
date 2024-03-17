package com.linkup.XMLParsing.parser;

public class CharParser implements Parser<Character> {
  @Override
  public Character parse(String input) {
    if (input.length() != 1) {
      throw new IllegalArgumentException(
          "Input string must be a single character");
    }
    return input.charAt(0);
  }
}
