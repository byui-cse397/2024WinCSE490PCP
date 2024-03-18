package com.linkup.common.XMLParsing.parser;

public class ByteParser implements DBResult<Byte> {
  @Override
  public void parse(String input) {
    result = Byte.parseByte(input);
  }

  private Byte result;

  @Override
  public Byte getResult() {
    return result;
  }
}
