package byui.app.linkUp.common.XMLParsing.parser;

public class DoubleParser extends DBResult<Double> {
  public DoubleParser(String input) { super(input); }

  public Double parser(String input) {
    result = Double.parseDouble(input);
    return result;
  }
}
