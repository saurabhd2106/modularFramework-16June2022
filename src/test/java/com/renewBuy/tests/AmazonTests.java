package com.renewBuy.tests;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.renewBuy.utils.TestDataProviderUtils;

public class AmazonTests extends BaseTest {

	@Test(priority = 1000, groups = {"Sanity", "Regression"})
	public void verifyHomepageTitle() throws Exception {

		reportUtils.createTestCase("Verify Homepage title", "This testcase verifies the title of the homepage");

		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";

		String actualTitle = cmnDriver.getTitle();

		AssertJUnit.assertEquals(actualTitle, expectedTitle);

		reportUtils.addLogs("info", "Verify Homepage title is successfull");

	}

	@Test(priority = 2000)
	public void searchProduct() {
		
		reportUtils.createTestCase("Verify search product ", "This testcase verifies the search functionality of Product");


		String product = "Apple Watch";
		String category = "Electronics";

		homepage.searchProduct(product, category);
		
		homepage.getAllProduct();

		// Add an assertion
	}
	
	
	@Test(priority = 2000, dataProvider = "getProductDataFromExcel", dataProviderClass = TestDataProviderUtils.class)
	public void searchProductDataDriven(String product, String category) throws Exception {
		
		reportUtils.createTestCase("Verify search product ", "This testcase verifies the search functionality of Product");


		homepage.searchProduct(product, category);
		
		homepage.getAllProductAndScrollViaJs();

		// Add an assertion
	}

}
