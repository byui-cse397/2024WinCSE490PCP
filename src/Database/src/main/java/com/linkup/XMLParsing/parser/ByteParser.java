package com.linkup.XMLParsing.parser;

public class ByteParser implements Parser<Byte> {
  @Override
  public Byte parse(String input) {
    return Byte.parseByte(input);
  }
}
