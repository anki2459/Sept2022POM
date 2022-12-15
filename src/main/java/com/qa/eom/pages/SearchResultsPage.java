package com.qa.eom.pages;

import org.openqa.selenium.WebDriver;

import com.qa.utils.ElementUtil;

public class SearchResultsPage 
{
	//1.private WebDriver
	private WebDriver driver;
	private ElementUtil eleUtil;

	public SearchResultsPage(WebDriver driver) 
	{
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		
	}

}
