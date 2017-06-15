/**
 * 
 */
package com.prashant.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.prashant.bean.Transaction;
import com.prashant.bean.Transaction.TransactionType;
import com.prashant.exceptions.ParseException;
import com.prashant.service.ParseData;

/**
 * @author happy
 *
 */
public class ParseDataImpl implements ParseData {

	@Override
	public List<Transaction> parseData(List<String> transactionData) throws ParseException {
	  List<Transaction> transactionList = new ArrayList<>();
	  try{
		for(String str : transactionData)
		{
		  Transaction transaction = new Transaction();
		  String listStr[] = str.split(",");
		  transaction.setExternalTransactionID(listStr[0]);
		  transaction.setUserID(listStr[1]);
		  transaction.setAccountID(Long.parseLong(listStr[2]));
		  transaction.setTransactionType(TransactionType.valueOf(listStr[3]));
		  transaction.setTransactionDate(new Date(listStr[4]));
		  transaction.setValue(Double.parseDouble(listStr[5]));
		  transaction.setPriorityFlag(listStr[6]);
		  boolean flag = transactionList.contains(transaction);
		  transaction = calculateLoyalityPoint( transaction, flag);
		  transactionList.add(transaction);
		}
	  }catch(Exception e)
	  {
	    throw new ParseException("Exception :"+e.getMessage());
	  }
		return transactionList;
	}
	
  public Transaction calculateLoyalityPoint(Transaction transaction,
      boolean flag) {
    long loyalityPoint = 0;
    String transactionType = transaction.getTransactionType().name();
    if ("Y".equals(transaction.getPriorityFlag())) {
      loyalityPoint += 1000;
    }
    if ("N".equals(transaction.getPriorityFlag())
        && transactionType.contains("CARD")) {
      loyalityPoint += 500;
    }
    if ("N".equals(transaction.getPriorityFlag())
        && ("CREDIT".equals(transactionType) || "DD".equals(transactionType))) {
      loyalityPoint += 200;
    }
    if (flag) {
      if (loyalityPoint >= 100)
        loyalityPoint -= 100;
      else
        loyalityPoint = 0;
    }
    transaction.setLoyalityPoints(loyalityPoint);
    return transaction;
  }
}
