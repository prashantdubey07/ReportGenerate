package com.prashant.bean;

import java.util.Date;

import com.prashant.bean.Transaction.TransactionType;

public class Report {
  private String userID;
  private long accountID;
  private TransactionType transactionType;
  private Date transactionDate;
  private String priorityFlag;
  private long loyalityPoints;

  public long getLoyalityPoints() {
    return loyalityPoints;
  }

  public void setLoyalityPoints(long loyalityPoints) {
    this.loyalityPoints = loyalityPoints;
  }
  public String getUserID() {
    return userID;
  }

  public void setUserID(String userID) {
    this.userID = userID;
  }

  
  public long getAccountID() {
    return accountID;
  }

  public void setAccountID(long accountID) {
    this.accountID = accountID;
  }

  public TransactionType getTransactionType() {
    return transactionType;
  }

  public void setTransactionType(TransactionType transactionType) {
    this.transactionType = transactionType;
  }

  public Date getTransactionDate() {
    return transactionDate;
  }

  public void setTransactionDate(Date transactionDate) {
    this.transactionDate = transactionDate;
  }

  public String getPriorityFlag() {
    return priorityFlag;
  }

  public void setPriorityFlag(String priorityFlag) {
    this.priorityFlag = priorityFlag;
  }

  
  @Override
  public String toString() {
    return  userID + "," + transactionType + "," + transactionDate + ","  + priorityFlag + "," + loyalityPoints;
  }

  @Override
  public boolean equals(Object anObject) {
    if (this == anObject) {
      return true;
    }
    if (anObject instanceof Report) {
      Report anotherReport = (Report) anObject;
      if(this.getUserID().equals(anotherReport.getUserID())
          && this.getTransactionType().equals(anotherReport.getTransactionType())
          && this.getTransactionDate().equals(anotherReport.getTransactionDate())
          && this.getPriorityFlag().equals(anotherReport.getPriorityFlag()))
        return true;
    }
    return false;
  }

}
