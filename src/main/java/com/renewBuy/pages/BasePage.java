package com.renewBuy.pages;

import org.openqa.selenium.WebDriver;

import commonLibs.AlertControl;
import commonLibs.ElementControl;
import commonLibs.SelectDropdownControl;

public class BasePage {
	
	ElementControl elementControl;
	
	SelectDropdownControl dropdownControl;
	
	AlertControl alertControl;
	
	public BasePage(WebDriver driver) {
		
		elementControl = new ElementControl();
		
		dropdownControl = new SelectDropdownControl();
		
		alertControl = new AlertControl(driver);
	}

}
