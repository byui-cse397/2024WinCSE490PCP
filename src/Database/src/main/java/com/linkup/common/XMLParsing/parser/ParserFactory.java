package com.linkup.common.XMLParsing.parser;

import java.util.HashMap;
import java.util.Map;

public class ParserFactory {
  private static final Map<String, Parser<?>> parsers = new HashMap<>();

  static {
    parsers.put("INT", new IntParser());
    parsers.put("STRING", new StringParser());
    parsers.put("BOOL", new BoolParser());
    parsers.put("FLOAT", new FloatParser());
    parsers.put("DOUBLE", new DoubleParser());
    parsers.put("CHAR", new CharParser());
    parsers.put("BYTE", new ByteParser());
  }

  public static Parser<?> getParser(String type) {
    Parser<?> parser = parsers.get(type.toUpperCase());
    if (parser == null) {
      throw new IllegalArgumentException("Invalid type: " + type);
    }
    return parser;
  }
}
