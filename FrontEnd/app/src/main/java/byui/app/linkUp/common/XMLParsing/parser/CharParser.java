package byui.app.linkUp.common.XMLParsing.parser;

public class CharParser extends DBResult<Character> {
  public CharParser(String input) { super(input); }

  public Character parser(String input) {
    if (input.length() != 1) {
      throw new IllegalArgumentException(
          "Input string must be a single character");
    }
    result = input.charAt(0);
    return result;
  }
}
