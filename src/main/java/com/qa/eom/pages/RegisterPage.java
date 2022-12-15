package com.qa.eom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.utils.Constants;
import com.qa.utils.ElementUtil;

public class RegisterPage {
	//1 private 
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	//2 page constructor
	
	public RegisterPage(WebDriver driver)
	{
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		
	}
	
	//3 Private By locators
	
	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By emailID = By.id("input-email");
	private By password = By.id("input-password");
	private By newsletterNo = By.id("input-newsletter-no");
	private By agreeCheckBox = By.name("agree");
	private By contButton = By.xpath("//button[@type = 'submit']");
	private By header = By.xpath("//div[@id = 'content']/h1");
	
	//Page Actions
	
	public String getRegisterPageTitle()
	{ 
		return eleUtil.doGetTitleWithFraction(Constants.REGISTER_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}
	
	public boolean getRegisterPageUrl()
	{
		return eleUtil.waitForURLToContain(Constants.REGISTER_PAGE_URL_FRACTION, Constants.DEFAULT_TIME_OUT);
	}
	public String checkHeading()
	{
		 return eleUtil.doGetText(header);
	}
	public LoginPage doRegister(String fName,String lName,String email,String pwd)
	{
	    eleUtil.doSendKeys(firstName, fName);
	    eleUtil.doSendKeys(lastName, lName);
	    eleUtil.doSendKeys(emailID, email);
	    eleUtil.doSendKeys(password, pwd);
	    eleUtil.doClick(newsletterNo);
	    eleUtil.doClick(agreeCheckBox);
	    eleUtil.doClick(contButton);
	    try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new LoginPage(driver);

	}

}
