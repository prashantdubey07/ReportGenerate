package com.prashant.util;

import org.apache.commons.lang3.builder.CompareToBuilder;

import com.prashant.bean.Report;

public class ReportComparatorTransDate extends ReportComparator {
  @Override
  public int compare(Report rep1, Report rep2) {
    return new CompareToBuilder()
        .append(rep1.getTransactionDate(), rep2.getTransactionDate())
        .toComparison();
  }

}
