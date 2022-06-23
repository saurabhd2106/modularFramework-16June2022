package com.renewBuy.pages;

import org.openqa.selenium.WebDriver;

import commonLibs.AlertControl;
import commonLibs.ElementControl;
import commonLibs.MouseControl;
import commonLibs.SelectDropdownControl;

public class BasePage {
	
	ElementControl elementControl;
	
	SelectDropdownControl dropdownControl;
	
	AlertControl alertControl;
	
	MouseControl mouseControl;
	
	public BasePage(WebDriver driver) {
		
		elementControl = new ElementControl();
		
		dropdownControl = new SelectDropdownControl();
		
		alertControl = new AlertControl(driver);
		
		mouseControl = new MouseControl(driver);
	}

}
