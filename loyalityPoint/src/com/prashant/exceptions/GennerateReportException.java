package com.prashant.exceptions;

public class GennerateReportException extends Exception{
  private static final long serialVersionUID = 1L;

  public GennerateReportException() {
  }

  public GennerateReportException(String message) {
    super(message);
  }

  public GennerateReportException(String message, Throwable cause) {
    super(message, cause);
  }

  public GennerateReportException(Throwable cause) {
    super(cause);
  }
}
