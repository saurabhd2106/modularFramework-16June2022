package com.renewBuy.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.renewBuy.pages.AmazonHomepage;

import commonLibs.CommonDriver;
import utils.ReportUtils;

public class BaseTest {

	CommonDriver cmnDriver;

	WebDriver driver;

	AmazonHomepage homepage;

	ReportUtils reportUtils;

	String projectDirectory;

	private String reportName;

	@BeforeSuite
	public void initialise() {

		projectDirectory = System.getProperty("user.dir");

		reportName = String.format("%s/reports/renew-buy-report.html", projectDirectory);

		reportUtils = new ReportUtils(reportName);

		reportUtils.createTestCase("Initialise during Before Suite", "Created report instances");

		reportUtils.addLogs("info", "Initialised the report successfully");
	}

	@BeforeClass
	public void preSetup() {

		System.out.println("First method executed in a class");

	}

	@BeforeMethod
	public void setup() throws Exception {
		

		reportUtils.createTestCase("Initialise Before Every testcase", "This section inialise browser and page");


		openBrowserAndNavigateToAUrl();

		initializeDriverInstance();

		pageInitialization();

	}

	@AfterMethod
	public void cleanUp() throws Exception {
		
		reportUtils.createTestCase("Initialise After Every testcase", "This section closes browser instance");



		closeBrowerInstance();

	}

	@AfterClass
	public void afterClass() {

		System.out.println("last method executed in a class");

	}
	
	@AfterSuite
	public void cleanupAfterSuite() {
		
		reportUtils.closeReport();
	}

	private void openBrowserAndNavigateToAUrl() throws Exception {
		cmnDriver = new CommonDriver("chrome");

		cmnDriver.navigateToUrl("https://www.amazon.in");
		
		reportUtils.addLogs("info", "Initialised the browser successfully");

	}

	private void pageInitialization() {
		homepage = new AmazonHomepage(driver);
		
		reportUtils.addLogs("info", "Initialised the pages successfully");

	}

	private void initializeDriverInstance() {
		driver = cmnDriver.getDriver();

		reportUtils.addLogs("info", "Initialised the driver instance successfully");
	}

	private void closeBrowerInstance() throws Exception {

		cmnDriver.closeAllBrowser();
		
		
		reportUtils.addLogs("info", "Closed the browser instance successfully");
	}

}
