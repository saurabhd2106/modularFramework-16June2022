package com.renewBuy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomepage extends BasePage {

	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchBox;

	@FindBy(id = "searchDropdownBox")
	private WebElement searchDropdown;

	@FindBy(id = "nav-search-submit-button")
	private WebElement searchButton;

	public AmazonHomepage(WebDriver driver) {
		
		super(driver);

		PageFactory.initElements(driver, this);

	}

	public void searchProduct(String product, String category) {

		elementControl.sendText(searchBox, product);

		dropdownControl.selectViaVisibleText(searchDropdown, category);

		elementControl.clickElement(searchButton);

	}

}
