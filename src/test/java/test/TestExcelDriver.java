package test;

import org.testng.annotations.Test;

import utils.ExcelDriver;

public class TestExcelDriver {

	@Test
	public void verifyExcelDriver() {

		String filename = System.getProperty("user.dir") + "/testData/test.xlsx";

		try {
			
			String sheetname = "TestData";

			ExcelDriver excelDriver = new ExcelDriver();

			excelDriver.createWorkbook(filename);

			excelDriver.openWorkbook(filename);

			excelDriver.createSheet(sheetname);

			excelDriver.setCellData(sheetname, 0, 0, "Saurabh");

			excelDriver.setCellData(sheetname, 0, 1, "Dhingra");
			
			excelDriver.setCellData(sheetname, 1, 0, "Saurabh");

			excelDriver.setCellData(sheetname, 1, 1, "Dhingra");

			excelDriver.setCellData(sheetname, 2, 0, "Gaurav");

			excelDriver.setCellData(sheetname, 2, 1, "Dhingra");
			
			excelDriver.saveFile();

			excelDriver.closeWorkbook();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
