package com.linkup.common.XMLParsing;

import com.linkup.common.XMLParsing.parser.*;

public enum XMLType {
  INT {
    public DBResult<Integer> parse(String input) {
      IntParser parser = new IntParser(input);
      return parser;
    }
  },
  STRING {
    public DBResult<String> parse(String input) {
      StringParser parser = new StringParser(input);
      return parser;
    }
  },
  BOOL {
    public DBResult<Boolean> parse(String input) {
      BoolParser parser = new BoolParser(input);
      return parser;
    }
  },
  FLOAT {
    public DBResult<Float> parse(String input) {
      FloatParser parser = new FloatParser(input);
      return parser;
    }
  },
  DOUBLE {
    public DBResult<Double> parse(String input) {
      DoubleParser parser = new DoubleParser(input);
      return parser;
    }
  },
  CHAR {
    public DBResult<Character> parse(String input) {
      CharParser parser = new CharParser(input);
      return parser;
    }
  },
  BYTE {
    public DBResult<Byte> parse(String input) {
      ByteParser parser = new ByteParser(input);
      return parser;
    }
  },
  PARENT {
    public DBResult<XMLParent> parse(String input) {
      XMLParentParser parser = new XMLParentParser(input);
      return parser;
    }
  };

  public abstract DBResult<?> parse(String input);

  public static XMLType fromString(String type) {
    String lowerCaseType = type.toLowerCase();
    for (XMLType xmlType : XMLType.values()) {
      if (xmlType.name().toLowerCase().startsWith(
              lowerCaseType.substring(0, 3))) {
        return xmlType;
      }
    }
    throw new IllegalArgumentException("Invalid XMLType: " + type);
  }

  public static DBResult<?> parseValue(String type, String value) {
    XMLType xmlType = fromString(type);
    return xmlType.parse(value);
  }
}
