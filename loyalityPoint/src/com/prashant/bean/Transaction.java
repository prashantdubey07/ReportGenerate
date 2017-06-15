/**
 * 
 */
package com.prashant.bean;

import java.util.Date;

/**
 * @author Prashant
 *
 */
public class Transaction {

  private String externalTransactionID;
  private String userID;
  private long accountID;
  private TransactionType transactionType;
  private Date transactionDate;
  private double value;
  private String priorityFlag;
  private long loyalityPoints;

  public long getLoyalityPoints() {
    return loyalityPoints;
  }

  public void setLoyalityPoints(long loyalityPoints) {
    this.loyalityPoints = loyalityPoints;
  }

  public String getExternalTransactionID() {
    return externalTransactionID;
  }

  public void setExternalTransactionID(String externalTransactionID) {
    this.externalTransactionID = externalTransactionID;
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

  public double getValue() {
    return value;
  }

  public void setValue(double value) {
    this.value = value;
  }

  public String getPriorityFlag() {
    return priorityFlag;
  }

  public void setPriorityFlag(String priorityFlag) {
    this.priorityFlag = priorityFlag;
  }

  @Override
  public String toString() {
    return "Transaction [externalTransactionID=" + externalTransactionID
        + ", userID=" + userID + ", accountID=" + accountID
        + ", transactionType=" + transactionType + ", transactionDate="
        + transactionDate + ", value=" + value + ", priorityFlag="
        + priorityFlag + "]";
  }

  @Override
  public boolean equals(Object anObject) {
    if (this == anObject) {
      return true;
    }
    if (anObject instanceof Transaction) {
      Transaction anotherTransaction = (Transaction) anObject;
      if(this.getUserID().equals(anotherTransaction.getUserID())
          && this.getAccountID() == anotherTransaction.getAccountID()
          && this.getTransactionType().name().contains("CARD"))
        return true;
    }
    return false;
  }
  @Override
  public int hashCode() {
      int hash = 7;
      hash = 17 * hash + (this.userID != null ? this.userID.hashCode() : 0);
      hash = (int) (17 * hash + (accountID != 0 ? this.accountID : 0));
      return hash;
  }

  public static enum TransactionType {
    CREDIT, DEBIT, DD, CREDIT_CARD, DEBIT_CARD;
  }
}
