package com.linkup.common.XMLParsing.parser;

import com.linkup.common.XMLParsing.XMLParent;

public class XMLParentParser extends DBResult<XMLParent> {
  public XMLParentParser(String input) { super(input); }

  public XMLParent parser(String input) {
    XMLParent parent = new XMLParent();
    parent.parseParent(input);
    return parent;
  }
}
