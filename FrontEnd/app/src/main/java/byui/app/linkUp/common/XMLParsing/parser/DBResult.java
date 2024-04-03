package byui.app.linkUp.common.XMLParsing.parser;

public abstract class DBResult<T> {
  protected T result;

  public DBResult(String input) { this.parse(input); }

  abstract T parser(String input);

  private void parse(String input) {
    T result = parser(input);
    this.result = result;
  }
  public T getResult() { return result; }
}
