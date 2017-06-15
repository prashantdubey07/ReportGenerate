package com.prashant.util;

import org.apache.commons.lang3.builder.CompareToBuilder;

import com.prashant.bean.Report;

public class ReportComparatorPriority extends ReportComparator {
  @Override
  public int compare(Report rep1, Report rep2) {
    return new CompareToBuilder()
        .append(rep1.getPriorityFlag(), rep2.getPriorityFlag())
        .toComparison();
  }

}
