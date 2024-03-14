package com.linkup.XMLParsing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XMLNode {
  private String tagName;
  private Object value;
  private List<XMLNode> children;

  public XMLNode(String tagName, String type, String value) {
    this.tagName = tagName;
    this.value = XMLType.parseValue(type, value);
    this.children = new ArrayList<>();
  }

  public void addChild(XMLNode child) { children.add(child); }

  public String getTagName() { return this.tagName; }

  public Object getValue() { return this.value; }
}
