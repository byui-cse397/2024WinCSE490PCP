package byui.app.linkUp.common.XMLParsing.parser;
public class FloatParser extends DBResult<Float> {
  public FloatParser(String input) { super(input); }

  public Float parser(String input) {
    result = Float.parseFloat(input);
    return result;
  }
}
