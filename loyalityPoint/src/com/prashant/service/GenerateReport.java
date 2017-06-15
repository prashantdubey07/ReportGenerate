package com.prashant.service;

import java.util.List;

import com.prashant.bean.Report;
import com.prashant.bean.Transaction;
import com.prashant.exceptions.GennerateReportException;

public interface GenerateReport {

  public List<Report> generateReport(List<Transaction> transactionList) throws GennerateReportException;
  
  public List<Report> generateReportBySort(List<Transaction> transactionList, String fieldName) throws GennerateReportException;
  
  public List<Report> generateReportByGroup(List<Transaction> transactionList,String fieldName) throws GennerateReportException;
}
