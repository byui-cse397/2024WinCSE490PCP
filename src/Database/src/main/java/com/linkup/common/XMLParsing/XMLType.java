package com.linkup.common.XMLParsing;

public enum XMLType {
  INT {
    public Object parse(String input) { return Integer.parseInt(input); }
  },
  STRING {
    public Object parse(String input) { return input; }
  },
  BOOL {
    public Object parse(String input) { return "TRUE".equalsIgnoreCase(input); }
  },
  FLOAT {
    public Object parse(String input) { return Float.parseFloat(input); }
  },
  DOUBLE {
    public Object parse(String input) { return Double.parseDouble(input); }
  },
  CHAR {
    public Object parse(String input) {
      if (input.length() != 1) {
        throw new IllegalArgumentException(
            "Input string must be a single character");
      }
      return input.charAt(0);
    }
  },
  BYTE {
    public Object parse(String input) { return Byte.parseByte(input); }
  },
  PARENT {
    public Object parse(String input) { return input; }
  };

  public abstract Object parse(String input);

  public static XMLType fromString(String type) {
    for (XMLType xmlType : XMLType.values()) {
      if (xmlType.name().equalsIgnoreCase(type)) {
        return xmlType;
      }
    }
    throw new IllegalArgumentException("Invalid XMLType: " + type);
  }

  public static Object parseValue(String type, String value) {
    XMLType xmlType = fromString(type);
    return xmlType.parse(value);
  }
}
