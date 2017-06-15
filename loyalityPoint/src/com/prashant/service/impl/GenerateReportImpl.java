package com.prashant.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.prashant.bean.Report;
import com.prashant.bean.Transaction;
import com.prashant.exceptions.GennerateReportException;
import com.prashant.service.GenerateReport;
import com.prashant.util.ReportAggregator;
import com.prashant.util.ReportComparator;
import com.prashant.util.ReportComparatorAccount;
import com.prashant.util.ReportComparatorPriority;
import com.prashant.util.ReportComparatorTransDate;
import com.prashant.util.ReportComparatorTransType;
import com.prashant.util.ReportComparatorUser;

public class GenerateReportImpl implements GenerateReport {

  @Override
  public List<Report> generateReport(List<Transaction> transactionList)
      throws GennerateReportException {
    List<Report> reportList = new ArrayList<>();
    try {
      for (Transaction transaction : transactionList) {
        Report report = new Report();
        Report reportTemp = new Report();
        report.setUserID(transaction.getUserID());
        report.setLoyalityPoints(transaction.getLoyalityPoints());
        report.setTransactionDate(transaction.getTransactionDate());
        report.setTransactionType(transaction.getTransactionType());
        report.setPriorityFlag(transaction.getPriorityFlag());
        if (reportList.contains(report)) {
          reportTemp = reportList.get(reportList.indexOf(report));
          reportTemp.setLoyalityPoints(reportTemp.getLoyalityPoints()
              + report.getLoyalityPoints());
        } else {
          reportList.add(report);
        }
      }
    } catch (Exception e) {
      throw new GennerateReportException("Exception :" + e.getMessage());
    }
    return reportList;
  }

  @Override
  public List<Report> generateReportBySort(List<Transaction> transactionList,
      String fieldName) throws GennerateReportException {
    List<Report> reportList = new ArrayList<>();
    ReportComparator reportComparator = null;
    try {
      for (Transaction transaction : transactionList) {
        Report report = new Report();
        Report reportTemp = new Report();
        report.setUserID(transaction.getUserID());
        report.setLoyalityPoints(transaction.getLoyalityPoints());
        report.setTransactionDate(transaction.getTransactionDate());
        report.setTransactionType(transaction.getTransactionType());
        report.setPriorityFlag(transaction.getPriorityFlag());
        if (reportList.contains(report)) {
          reportTemp = reportList.get(reportList.indexOf(report));
          reportTemp.setLoyalityPoints(reportTemp.getLoyalityPoints()
              + report.getLoyalityPoints());
        } else {
          reportList.add(report);
        }
      }

      switch (fieldName) {
      case "userID": {
        reportComparator = new ReportComparatorUser();
        break;
      }
      case "accountID": {
        reportComparator = new ReportComparatorAccount();
        break;
      }
      case "transactionType": {
        reportComparator = new ReportComparatorTransType();
        break;
      }
      case "transactionDate": {
        reportComparator = new ReportComparatorTransDate();
        break;
      }
      case "priorityFlag": {
        reportComparator = new ReportComparatorPriority();
      }
     }
      Collections.sort(reportList, reportComparator);
    } catch (Exception e) {
      throw new GennerateReportException("Exception :" + e.getMessage());
    }

    return reportList;
  }

  @Override
  public List<Report> generateReportByGroup(List<Transaction> transactionList,
      String fieldName) throws GennerateReportException {
    List<Report> reportList = new ArrayList<>();
    ReportAggregator reportAggregator = new ReportAggregator();
    try {
      for (Transaction transaction : transactionList) {
        Report report = new Report();
        Report reportTemp = new Report();
        report.setUserID(transaction.getUserID());
        report.setLoyalityPoints(transaction.getLoyalityPoints());
        report.setTransactionDate(transaction.getTransactionDate());
        report.setTransactionType(transaction.getTransactionType());
        report.setPriorityFlag(transaction.getPriorityFlag());
        if (reportList.contains(report)) {
          reportTemp = reportList.get(reportList.indexOf(report));
          reportTemp.setLoyalityPoints(reportTemp.getLoyalityPoints()
              + report.getLoyalityPoints());
        } else {
          reportList.add(report);
        }
      }

      switch (fieldName) {
      case "userID": {
        reportList = reportAggregator.getDataGroupByUser(reportList);
        break;
      }
      case "transactionType": {
        reportList = reportAggregator.getDataGroupByTransactionType(reportList);
        break;
      }
      case "transactionDate": {
        reportList = reportAggregator.getDataGroupByTransactionDate(reportList);
        break;
      }
      case "priorityFlag": {
        reportList = reportAggregator.getDataGroupByPriority(reportList);
        break;
      }
      }
    } catch (Exception e) {
      throw new GennerateReportException("Exception :" + e.getMessage());
    }
    return reportList;
  }

}
