package com.linkup.common.XMLParsing.parser;

public class ByteParser extends DBResult<Byte> {
  public ByteParser(String input) { super(input); }

  public Byte parser(String input) {
    result = Byte.parseByte(input);
    return result;
  }
}
