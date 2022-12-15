package com.qa.eom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.utils.Constants;
import com.qa.utils.ElementUtil;

public class LoginPage 
{
	//1. declare private driver
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	//2.page constructor
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	//3.private By locators
	
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");	
	private By loginButton = By.xpath("//button[@type ='submit']");
	private By registerLink = By.linkText("Register");
	private By forgotPwdLink = By.linkText("Forgotten Password");

	 //4.Page Actions
	public String getLoginPageTitle()
	{ 
		return eleUtil.doGetTitleWithFraction(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}
	
	public boolean getLoginPageUrl()
	{
		return eleUtil.waitForURLToContain(Constants.LOGIN_PAGE_URL_FRACTION, Constants.DEFAULT_TIME_OUT);
	}
	
	public boolean isForgotPwdLinkExist()
	{
		return eleUtil.doIsDisplayed(forgotPwdLink);
	}
	public boolean isRegisterLinkExist()
	{
		return eleUtil.doIsDisplayed(registerLink);
	}
	public AccountsPage doLogin(String un,String pwd)
	{
		System.out.println("Log in with : "+un + " : "+pwd);
		eleUtil.doSendKeys(emailId, un);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginButton);
		return new AccountsPage(driver);		

	}

}
