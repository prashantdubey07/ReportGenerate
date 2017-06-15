package com.prashant.test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import com.prashant.api.GenerateReportAPI;
import com.prashant.api.impl.GenerateReportAPIImpl;

public class TestLoyalityPoint {
  GenerateReportAPI GenerateReportAPI = new GenerateReportAPIImpl();
 @Test
  public void testGenericReportSortByUserID() {

    File file = GenerateReportAPI.getReportSortBy("userID");
    assertNotEquals(file.length(), 0L);
  }
 
 
 @Test
  public void testGenericReport() {
    File file = GenerateReportAPI.getReport();
    assertNotEquals(file.length(),0L);
  }
  

  @Test
  public void testGenericReportSortByTransType() {
    File file = GenerateReportAPI.getReportSortBy("transactionType");
    assertNotEquals(file.length(), 0L);
  }

  @Test
  public void testGenericReportGroupByUserID() {
    File file = GenerateReportAPI.getReportGroupBy("userID");
    assertNotEquals(file.length(), 0L);
  }

  @Test
  public void testGenericReportGroupByTransType() {
    File file = GenerateReportAPI.getReportGroupBy("transactionType");
    assertNotEquals(file.length(), 0L);
  }

}
