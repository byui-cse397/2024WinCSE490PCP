package com.linkup.XMLParsing;

import java.io.FileReader;
import java.io.IOException;

public class XMLParser {
  private String xml;
  private int currentIndex;
  private XMLNode parent;

  public XMLParser(String xml, XMLNode parent) {
    this.xml = xml;
    this.currentIndex = 0;
    if (parent != null) {
      this.parent = parent;
    }
  }

  public XMLNode parse() throws IOException {
    skipWhitespace();
    if (currentIndex >= xml.length()) {
      throw new IOException("Unexpected end of XML document.");
    }
    return parseElement();
  }

  private XMLNode parseElement() throws IOException {
    if (xml.charAt(currentIndex) != '<') {
      throw new IOException("Expected '<' at index " + currentIndex);
    }
    currentIndex++;
    skipWhitespace();

    String tagName = parseTagName();
    String type = parseType();
    String value = parseValue(tagName);
    XMLNode node = new XMLNode(tagName, type, value);
    if (parent != null) {
      parent.addChild(node);
    }
    if (type.equalsIgnoreCase(XMLType.PARENT.name())) {
      return parseChildren(node, value);
    }
    return node;
  }

  private String parseTagName() throws IOException {
    int start = currentIndex;
    while (currentIndex < xml.length() && xml.charAt(currentIndex) != '>' &&
           xml.charAt(currentIndex) != '/') {
      currentIndex++;
    }
    return xml.substring(start, currentIndex);
  }

  private String parseType() throws IOException {
    skipWhitespace();
    int start = currentIndex;
    while (currentIndex < xml.length() && xml.charAt(currentIndex) != ':') {
      currentIndex++;
    }
    return xml.substring(start, currentIndex);
  }

  private String parseValue(String tagName) throws IOException {
    skipWhitespace();
    if (xml.charAt(currentIndex) != '>') {
      throw new IOException("Expected '>' at index " + currentIndex);
    }
    currentIndex++;
    skipWhitespace();
    int start = currentIndex;
    String closingTag = "</" + tagName + ">";
    int closingTagIndex = xml.indexOf(closingTag, currentIndex);
    if (closingTagIndex == -1) {
      throw new IOException("Closing tag not found for " + tagName);
    }
    return xml.substring(start, closingTagIndex);
  }

  private XMLNode parseChildren(XMLNode node, String substr)
      throws IOException {
    XMLParser parser = new XMLParser(substr, node);
    XMLNode returnNode = parser.parseElement();
    return returnNode;
  }

  private void skipWhitespace() {
    while (currentIndex < xml.length() &&
           Character.isWhitespace(xml.charAt(currentIndex))) {
      currentIndex++;
    }
  }
}
