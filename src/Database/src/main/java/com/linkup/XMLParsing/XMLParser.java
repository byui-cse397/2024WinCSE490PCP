package com.linkup.XMLParsing;

import java.io.IOException;

public class XMLParser {
  private String xml;
  private int currentIndex;
  private XMLNode parent;

  /**
   * XMLParser takes an XML-like string of the form <name:type>value</name> and
   * decodes the information as XMLNodes containing the parsed value and
   * children nodes (if any).
   * @param xml The xml serialized string to be decoded.
   * @param parent The parent node (if any) for parents to add their children.
   *
   */
  public XMLParser(String xml, XMLNode parent) {
    this.xml = xml;
    this.currentIndex = 0;
    if (parent != null) {
      this.parent = parent;
    }
  }

  /**
   * Perform the parse action and retrieve the XMLNode containing the structure
   * of the XML-like query.
   * @return XMLNode, contianing children nodes (if any) and the values within
   *     the xml query.
   * @throws IOException
   *
   */
  public XMLNode parse() throws IOException {
    skipWhitespace();
    if (currentIndex >= xml.length()) {
      throw new IOException("Unexpected end of XML document.");
    }
    return parseElement();
  }

  /**
   * The recurrsive loop of our parser, breaks our xml tags down to names,
   * types, and values.
   * @return The parent XMLNode.
   * @throws IOException
   *
   */
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
      parseChildren(node, value);
    }
    if (currentIndex < xml.length()) {
      String substr = xml.substring(currentIndex, xml.length());
      XMLParser sibling = new XMLParser(substr, parent);
      sibling.parse();
    }
    return node;
  }

  /**
   * Retrieves the tag name from our xml-like tag.
   * @return The xml-like tag name as a string.
   * @throws IOException
   *
   */
  private String parseTagName() throws IOException {
    int start = currentIndex;
    while (currentIndex < xml.length() && xml.charAt(currentIndex) != ':' &&
           xml.charAt(currentIndex) != '/') {
      currentIndex++;
    }
    return xml.substring(start, currentIndex);
  }

  /**
   * Retrieves the type from our xml-like tag.
   * @return The string identifier of the type of the xml-like tag value.
   * @throws IOException
   *
   */
  private String parseType() throws IOException {
    skipWhitespace();
    if (currentIndex < xml.length() && xml.charAt(currentIndex) == ':') {
      currentIndex++;
      int start = currentIndex;
      while (currentIndex < xml.length() && xml.charAt(currentIndex) != '>') {
        currentIndex++;
      }
      return xml.substring(start, currentIndex);
    } else {
      throw new IOException("Malformed XML: Expected colon in tag name.");
    }
  }

  /**
   * Retrieves the value from our xml-like tags.
   * @param tagName The tag name to identify the closing tag.
   * @return The string representation of the value from our xml tags.
   * @throws IOException
   *
   */
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
    currentIndex = closingTagIndex + closingTag.length();
    return xml.substring(start, closingTagIndex);
  }

  /**
   * parseChildren allows us to identify the children of parent nodes where the
   * value for the parent nodes are more xml-like tags.
   * @param node This node, the parent node for our xml-like children.
   * @param substr The string Representation of xml-like children tags.
   * @throws IOException
   *
   */
  private void parseChildren(XMLNode node, String substr) throws IOException {
    XMLParser parser = new XMLParser(substr, node);
    parser.parse();
  }

  /**
   * Skip accidental whitespaces that might have found their way into our
   * xmltags.
   */
  private void skipWhitespace() {
    while (currentIndex < xml.length() &&
           Character.isWhitespace(xml.charAt(currentIndex))) {
      currentIndex++;
    }
  }
}
