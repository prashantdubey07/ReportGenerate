package com.prashant.service;

import java.io.File;
import java.util.List;

import com.prashant.exceptions.ReadExceptions;

public interface ReadTransaction {
	
	public List<String> readData(File file) throws ReadExceptions;
	
	public List<String> readData();

}
