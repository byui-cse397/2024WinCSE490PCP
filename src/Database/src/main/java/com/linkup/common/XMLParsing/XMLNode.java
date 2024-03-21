package com.linkup.common.XMLParsing;

import com.linkup.common.XMLParsing.parser.DBResult;

public class XMLNode<T> {
  private String tagName;
  private T value;

  /**
   * XMLNode is an object to keep track of the contents of XML-like tags.
   * @param tagName Stores the name of the tag.
   * @param type Stores the type of the tag.
   * @param value Stores the contents of the tag.
   */
  public XMLNode(String tagName, String type, String value) {
    this.tagName = tagName;
    DBResult<T> parser = (DBResult<T>)XMLType.parseValue(type, value);
    this.value = (T)parser.getResult();
  }

  public String getTagName() { return this.tagName; }

  public T getValue() { return this.value; }

  public void setValue(T value) { this.value = value; }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Tag Name: ").append(tagName).append("\n");
    sb.append("Value: ").append(value.toString()).append("\n");
    return sb.toString();
  }
}
