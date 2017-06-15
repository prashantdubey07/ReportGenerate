package com.prashant.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.prashant.bean.Report;
import com.prashant.bean.Transaction.TransactionType;

public class ReportAggregator {
  
  
  public List<Report> getDataGroupByUser(List<Report> reportListInput){
    List<Report> reportList = new ArrayList<>();
    Map<String,List<Report>> groupByUserID = new HashMap<>();
    for(Report report :reportListInput)
    {
      if(groupByUserID.containsKey(report.getUserID()))
      {
        groupByUserID.get(report.getUserID()).add(report);
      }else
      {
        List<Report> reportListTemp = new ArrayList<>();
        reportListTemp.add(report);
        groupByUserID.put(report.getUserID(), reportListTemp);
      }
    }
    for(String set: groupByUserID.keySet())
    {
      reportList.addAll(groupByUserID.get(set));
    }
    
    return reportList;
    
  }
  

  public List<Report> getDataGroupByTransactionType(List<Report> reportListInput){
    List<Report> reportList = new ArrayList<>();
    Map<TransactionType,List<Report>> groupByUserID = new HashMap<>();
    for(Report report :reportListInput)
    {
      if(groupByUserID.containsKey(report.getTransactionType()))
      {
        groupByUserID.get(report.getTransactionType()).add(report);
      }else
      {
        List<Report> reportListTemp = new ArrayList<>();
        reportListTemp.add(report);
        groupByUserID.put(report.getTransactionType(), reportListTemp);
      }
    }
    for(TransactionType set: groupByUserID.keySet())
    {
      reportList.addAll(groupByUserID.get(set));
    }
    return reportList;
    
  }
  
  public List<Report> getDataGroupByTransactionDate(List<Report> reportListInput){
    List<Report> reportList = new ArrayList<>();
    Map<Date,List<Report>>  groupByUserID = new HashMap<>();
    for(Report report :reportListInput)
    {
      if(groupByUserID.containsKey(report.getTransactionDate()))
      {
        groupByUserID.get(report.getTransactionDate()).add(report);
      }else
      {
        List<Report> reportListTemp = new ArrayList<>();
        reportListTemp.add(report);
        groupByUserID.put(report.getTransactionDate(), reportListTemp);
      }
    }
    for(Date set: groupByUserID.keySet())
    {
      reportList.addAll(groupByUserID.get(set));
    }
    return reportList;
    
  }
  
  public List<Report> getDataGroupByPriority(List<Report> reportListInput){
    List<Report> reportList = new ArrayList<>();
    Map<String,List<Report>> groupByUserID = new HashMap<>();
    for(Report report :reportListInput)
    {
      if(groupByUserID.containsKey(report.getPriorityFlag()))
      {
        groupByUserID.get(report.getPriorityFlag()).add(report);
      }else
      {
        List<Report> reportListTemp = new ArrayList<>();
        reportListTemp.add(report);
        groupByUserID.put(report.getPriorityFlag(), reportListTemp);
      }
    }
    for(String set: groupByUserID.keySet())
    {
      reportList.addAll(groupByUserID.get(set));
    }
    return reportList;
  }
  

}
