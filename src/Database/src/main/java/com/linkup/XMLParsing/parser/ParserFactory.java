package com.linkup.XMLParsing.parser;

public class ParserFactory {
  public static Parser<?> getParser(String type) {
    switch (type.toUpperCase()) {
    case "INT":
      return new IntParser();
    case "STRING":
      return new StringParser();
    // Add cases for other types...
    default:
      throw new IllegalArgumentException("Invalid type: " + type);
    }
  }
}
