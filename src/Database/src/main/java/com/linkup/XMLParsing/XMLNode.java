package com.linkup.XMLParsing;

import java.util.ArrayList;
import java.util.List;

public class XMLNode {
  private String tagName;
  private Object value;
  private List<XMLNode> children;

  /**
   * XMLNode is an object to keep track of the contents of XML-like tags.
   * @param tagName Stores the name of the tag.
   * @param type Stores the type of the tag.
   * @param value Stores the contents of the tag.
   *
   */
  public XMLNode(String tagName, String type, String value) {
    this.tagName = tagName;
    this.value = XMLType.parseValue(type, value);
    this.children = new ArrayList<>();
  }

  public void addChild(XMLNode child) { children.add(child); }

  public String getTagName() { return this.tagName; }

  public Object getValue() { return this.value; }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Tag Name: ").append(tagName).append("\n");
    sb.append("Value: ").append(value).append("\n");
    sb.append("Type: ").append(type(value)).append("\n");
    sb.append("Children: ");
    for (XMLNode child : children) {
      sb.append("\n");
      sb.append(child.toString());
    }
    return sb.toString();
  }

  private String type(Object value) { return value.getClass().getSimpleName(); }
}
