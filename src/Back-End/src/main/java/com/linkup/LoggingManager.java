package com.linkup;

import java.util.logging.*;

public class LoggingManager {
  private static final Logger logger = Logger.getLogger(App.class.getName());

  public static Logger getLogger() { return logger; }
}
