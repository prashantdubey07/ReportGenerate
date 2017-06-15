package com.prashant.util;

import java.util.Comparator;

import org.apache.commons.lang3.builder.CompareToBuilder;

import com.prashant.bean.Report;

public class ReportComparator implements Comparator<Report> {
  public int compare(Report rep1, Report rep2) {
    return new CompareToBuilder().append(rep1.getUserID(), rep2.getUserID())
        .append(rep1.getAccountID(), rep2.getAccountID())
        .append(rep1.getTransactionType(), rep2.getTransactionType())
        .append(rep1.getTransactionDate(), rep2.getTransactionDate())
        .append(rep1.getPriorityFlag(), rep2.getPriorityFlag())
        .toComparison();
  }
}