package com.prashant.service;

import java.util.List;

import com.prashant.bean.Transaction;
import com.prashant.exceptions.ParseException;

public interface ParseData {

	public List<Transaction> parseData(List<String> transactionData) throws ParseException;
}
