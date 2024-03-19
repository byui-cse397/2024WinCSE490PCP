package com.linkup.common.XMLParsing;

import com.linkup.common.XMLParsing.parser.*;

public enum XMLType {
  INT {
    public DBResult<Integer> parse(String input) {
      IntParser parser = new IntParser();
      parser.parse(input);
      return parser;
    }
  },
  STRING {
    public DBResult<String> parse(String input) {
      StringParser parser = new StringParser();
      parser.parse(input);
      return parser;
    }
  },
  BOOL {
    public DBResult<Boolean> parse(String input) {
      BoolParser parser = new BoolParser();
      parser.parse(input);
      return parser;
    }
  },
  FLOAT {
    public DBResult<Float> parse(String input) {
      FloatParser parser = new FloatParser();
      parser.parse(input);
      return parser;
    }
  },
  DOUBLE {
    public DBResult<Double> parse(String input) {
      DoubleParser parser = new DoubleParser();
      parser.parse(input);
      return parser;
    }
  },
  CHAR {
    public DBResult<Character> parse(String input) {
      CharParser parser = new CharParser();
      parser.parse(input);
      return parser;
    }
  },
  BYTE {
    public DBResult<Byte> parse(String input) {
      ByteParser parser = new ByteParser();
      parser.parse(input);
      return parser;
    }
  },
  PARENT {
    public DBResult<XMLNode> parse(String input) {
      XMLDBResult parser = new XMLDBResult();
      parser.parse(input);
      return parser;
    }
  };

  public abstract DBResult<?> parse(String input);

  public static XMLType fromString(String type) {
    for (XMLType xmlType : XMLType.values()) {
      if (xmlType.name().equalsIgnoreCase(type)) {
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
