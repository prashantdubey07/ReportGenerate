package com.prashant.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.prashant.exceptions.ReadExceptions;
import com.prashant.service.ReadTransaction;

public class ReadTransactionImpl implements ReadTransaction {

	@Override
	public List<String> readData(File file) throws ReadExceptions
	{
		List<String> transactionData = new ArrayList<>();
		 BufferedReader bf = null;
		try {
      bf = new BufferedReader(new FileReader(file));
      String str= bf.readLine();
      while((str = bf.readLine()) != null){
        transactionData.add(str);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      throw new ReadExceptions("File Not Found" + e.getStackTrace());
    } catch (IOException e) {
      e.printStackTrace();
    }
		finally{
		  if(null != bf)
		  {
		    try {
          bf.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
		  }
		}
		return transactionData;
	}

	@Override
	public List<String> readData() {
		List<String> transactionData = new ArrayList<>();
		
		return transactionData;
	}
}
