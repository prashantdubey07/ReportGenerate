package com.prashant.exceptions;

public class ReadExceptions extends Exception {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public ReadExceptions() {
  }

  public ReadExceptions(String message) {
    super(message);
  }

  public ReadExceptions(String message, Throwable cause) {
    super(message, cause);
  }

  public ReadExceptions(Throwable cause) {
    super(cause);
  }
}
