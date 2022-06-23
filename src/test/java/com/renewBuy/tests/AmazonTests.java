package com.renewBuy.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTests extends BaseTest {

	@Test(priority = 1000)
	public void verifyHomepageTitle() throws Exception {

		reportUtils.createTestCase("Verify Homepage title", "This testcase verifies the title of the homepage");

		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";

		String actualTitle = cmnDriver.getTitle();

		Assert.assertEquals(actualTitle, expectedTitle);

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

}
