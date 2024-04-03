package byui.app.linkUp.common.XMLParsing;
import java.util.ArrayList;

public class XMLParent {
  private ArrayList<XMLNode<?>> children;
  public XMLParent() { this.children = new ArrayList<XMLNode<?>>(); }

  public void addChild(XMLNode<?> child) { children.add(child); }

  public ArrayList<XMLNode<?>> getChildren() { return children; }

  public String parseParent(String xml) { return xml; }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (XMLNode<?> child : children) {
      sb.append("\n");
      sb.append(child.toString());
    }
    return sb.toString();
  }
}
