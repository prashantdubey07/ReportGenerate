package com.prashant.api.impl;

import java.io.File;
import java.util.logging.Logger;

import com.prashant.action.LoyalityPointAction;
import com.prashant.api.GenerateReportAPI;
import com.prashant.exceptions.GennerateReportException;
import com.prashant.exceptions.ParseException;
import com.prashant.exceptions.ReadExceptions;

public class GenerateReportAPIImpl implements GenerateReportAPI {
  LoyalityPointAction loyalityPointAction = new LoyalityPointAction();
  File file = null;

  @Override
  public File getReport() {
    try {
      loyalityPointAction.readData();
      loyalityPointAction.parseData();
      file = loyalityPointAction.generateReport();
    } catch (ReadExceptions e) {
      Logger.getLogger("GenerateReportAPIImpl").info(e.getMessage());
    } catch (ParseException e) {
      Logger.getLogger("GenerateReportAPIImpl").info(e.getMessage());
    } catch (GennerateReportException e) {
      Logger.getLogger("GenerateReportAPIImpl").info(e.getMessage());
    }
    return file;
  }

  @Override
  public File getReportGroupBy(String fieldName) {
    try {
      loyalityPointAction.readData();
      loyalityPointAction.parseData();
      file = loyalityPointAction.generateReportByGroup(fieldName);
    } catch (ReadExceptions e) {
      Logger.getLogger("GenerateReportAPIImpl").info(e.getMessage());
    } catch (ParseException e) {
      Logger.getLogger("GenerateReportAPIImpl").info(e.getMessage());
    } catch (GennerateReportException e) {
      Logger.getLogger("GenerateReportAPIImpl").info(e.getMessage());
    }
    return file;
  }

  @Override
  public File getReportSortBy(String fieldName) {
    try {
      loyalityPointAction.readData();
      loyalityPointAction.parseData();
      file = loyalityPointAction.generateReportBySort(fieldName);
      return file;
    } catch (ReadExceptions e) {
      Logger.getLogger("GenerateReportAPIImpl").info(e.getMessage());
    } catch (ParseException e) {
      Logger.getLogger("GenerateReportAPIImpl").info(e.getMessage());
    } catch (GennerateReportException e) {
      Logger.getLogger("GenerateReportAPIImpl").info(e.getMessage());
    }
    return file;
  }

  public static enum Result {
    SUCCCESS, FAILURE, ERROR;
  }
}
