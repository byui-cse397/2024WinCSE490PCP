package com.linkup.common.XMLParsing.parser;

public interface DBResult<T> {
  void parse(String input);

  T getResult();
}
