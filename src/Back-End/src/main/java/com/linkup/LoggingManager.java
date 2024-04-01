package com.linkup;

import java.util.logging.*;

/**
 * Manages logging functionality for the application.
 */
public class LoggingManager {
  // Logger instance for logging messages
  private static final Logger logger = Logger.getLogger(App.class.getName());

  /**
   * Retrieves the logger instance.
   * @return The logger instance.
   */
  public static Logger getLogger() { return logger; }
}
