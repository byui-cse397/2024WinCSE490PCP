package com.linkup.common.XMLParsing.parser;

import com.linkup.common.XMLParsing.XMLNode;
import com.linkup.common.XMLParsing.XMLParser;
import java.io.IOException;

public class XMLDBResult implements DBResult<XMLNode> {
  @Override
  public void parse(String input) {
    try {
      result = new XMLParser(input, null).parse();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private XMLNode result;

  @Override
  public XMLNode getResult() {
    return result;
  }
}
