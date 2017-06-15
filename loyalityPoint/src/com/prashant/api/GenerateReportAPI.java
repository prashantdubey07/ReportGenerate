package com.prashant.api;

import java.io.File;

public interface GenerateReportAPI {
  public File getReport();

  public File getReportGroupBy(String fieldName);

  public File getReportSortBy(String fieldName);
}
