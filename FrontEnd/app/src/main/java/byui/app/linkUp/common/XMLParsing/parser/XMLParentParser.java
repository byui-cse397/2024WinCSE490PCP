package byui.app.linkUp.common.XMLParsing.parser;

import byui.app.linkUp.common.XMLParsing.XMLParent;

public class XMLParentParser extends DBResult<XMLParent> {
  public XMLParentParser(String input) { super(input); }

  public XMLParent parser(String input) {
    XMLParent parent = new XMLParent();
    parent.parseParent(input);
    return parent;
  }
}
