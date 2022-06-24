package com.renewBuy.utils;

import org.testng.annotations.DataProvider;

import utils.ExcelDriver;

public class TestDataProviderUtils {
	
	
	@DataProvider
	public Object[][] getProductData(){
		
		Object[][] data = new Object[3][2];
		
		data[0][0] = "Apple Watch";
		data[0][1] = "Electronics";
		
		
		data[1][0] = "Iphone 12";
		data[1][1] = "Electronics";
		
		
		data[2][0] = "Samsung Mobile";
		data[2][1] = "Electronics";
		
		return data;
		
		
	}
	
	
	@DataProvider
	public Object[][] getProductDataFromExcel() throws Exception{
		
		
		ExcelDriver excelDriver = new ExcelDriver();
		
		String filename = String.format("%s/testData/productDetails.xlsx", System.getProperty("user.dir"));
		
		String sheetname = "TestData";
		
		excelDriver.openWorkbook(filename);
		
		int rowCount = excelDriver.getRowCount(sheetname);
		int cellCount= excelDriver.getCellCountFromARow(sheetname, 0);
		
		Object[][] data;
		
		data = new Object[rowCount + 1][cellCount];
		
		for(int row=0; row <=rowCount; row++) {
			for(int cell=0; cell <cellCount; cell++) {
				
				data[row][cell] = excelDriver.getCellData(sheetname, row, cell);
				
			}
		}
		
		
		return data;
		
		
	}

}
