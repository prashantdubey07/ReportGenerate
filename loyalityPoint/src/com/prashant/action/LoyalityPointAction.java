package com.prashant.action;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.prashant.bean.Report;
import com.prashant.bean.Transaction;
import com.prashant.exceptions.GennerateReportException;
import com.prashant.exceptions.ParseException;
import com.prashant.exceptions.ReadExceptions;
import com.prashant.service.GenerateReport;
import com.prashant.service.ParseData;
import com.prashant.service.ReadTransaction;
import com.prashant.service.impl.GenerateReportImpl;
import com.prashant.service.impl.ParseDataImpl;
import com.prashant.service.impl.ReadTransactionImpl;

public class LoyalityPointAction {
  private List<String> transactionData = new ArrayList<>();
  private List<Transaction> transactionList = new ArrayList<>();
  private List<Report> reportList = new ArrayList<>();
  private ReadTransaction readTransaction = new ReadTransactionImpl();
  private ParseData parseData = new ParseDataImpl();
  private GenerateReport generateReport = new GenerateReportImpl();
  
  public void readData() throws ReadExceptions
  {
    File file = new File(".\\.\\.\\.\\transactionData.txt");
    transactionData = readTransaction.readData(file);
  }
  
  public void parseData() throws ParseException
  {
    transactionList = parseData.parseData(transactionData);
  }
  
  public File generateReport() throws GennerateReportException
  {
    File file = new File(".\\.\\.\\.\\report.txt");
    reportList = generateReport.generateReport(transactionList);
    BufferedWriter bw = null;
    try {
       bw = new BufferedWriter(new FileWriter(file));
       String strHeader = "User ID,Transaction Type,transaction Date, priority, Loyality Points";
       bw.write(strHeader);
       bw.write("\n");
       for(Report report :reportList)
       {
         String str = report.toString();
         bw.write(str);
         bw.write("\n");
       }
    } catch (IOException e) {
      e.printStackTrace();
    }
    finally{
      if(null != bw)
      {
        try {
          bw.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return file;
  }
  public File generateReportBySort(String fieldName) throws GennerateReportException
  {
    File file = new File(".\\.\\.\\.\\report.txt");
    
    reportList = generateReport.generateReportBySort(transactionList,fieldName);
    BufferedWriter bw = null;
    try {
       bw = new BufferedWriter(new FileWriter(file));
       String strHeader = "User ID,Transaction Type,transaction Date, priority, Loyality Points";
       bw.write(strHeader);
       bw.write("\n");
       for(Report report :reportList)
       {
         String str = report.toString();
         bw.write(str);
         bw.write("\n");
       }
    } catch (IOException e) {
      e.printStackTrace();
    }
    finally{
      if(null != bw)
      {
        try {
          bw.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return file;
  }
  public File generateReportByGroup(String fieldName) throws GennerateReportException
  {
    File file = new File(".\\.\\.\\.\\report.txt");
    reportList = generateReport.generateReportByGroup(transactionList, fieldName);
    BufferedWriter bw = null;
    try {
       bw = new BufferedWriter(new FileWriter(file));
       String strHeader = "User ID,Transaction Type,transaction Date, priority, Loyality Points";
       bw.write(strHeader);
       bw.write("\n");
       for(Report report :reportList)
       {
         String str = report.toString();
         bw.write(str);
         bw.write("\n");
       }
    } catch (IOException e) {
      e.printStackTrace();
    }
    finally{
      if(null != bw)
      {
        try {
          bw.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return file;
  }

}
