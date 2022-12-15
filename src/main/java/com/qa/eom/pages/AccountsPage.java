package com.qa.eom.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.utils.Constants;
import com.qa.utils.ElementUtil;

public class AccountsPage 
{ 
	//1. Private WebDriver
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	
	//2 Page constructor
	
	public AccountsPage(WebDriver driver)
	{
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	//Private By locators
	
	private By header = By.cssSelector("div#logo a");
	private By accountSections = By.cssSelector("div#content h2");
	private By searchField = By.name("search");
	private By searchButton = By.cssSelector("div#search button");
	private By logOutLink = By.linkText("logout");
	
	//Page Actions
	
	public String getAccountsPageTitle()
	{ 
		return eleUtil.doGetTitleWithFraction(Constants.ACCOUNTS_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}
	public List<String> getAccountSecList()
	{
		List<WebElement> accSecList = eleUtil.waitForElementsToBeVisible(accountSections, Constants.DEFAULT_TIME_OUT);
		
		List<String> accSecValList = new ArrayList<String>();
		
		for(WebElement e:accSecList)
		{
			String text = e.getText();
			accSecValList.add(text);
		}
		return accSecValList;
	}
	public boolean isSearchExist()
	{
		 return eleUtil.doIsDisplayed(searchField);
	}
	public boolean isLogoutExist()
	{
		 return eleUtil.doIsDisplayed(logOutLink);
	}
	public SearchResultsPage doSearch(String productName)
	{
		 System.out.println("Searching for Product : "+productName);
		 eleUtil.doSendKeys(searchField, productName);
		 eleUtil.doClick(searchButton);
		 return new SearchResultsPage(driver);
		 
		
	}

}
