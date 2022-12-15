package com.qa.eom.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.utils.Constants;

public class LoginPageTest extends BaseTest
{
//	@BeforeClass
//	public void logPageSetup()
//	{
//		loginPage = registerPage.doRegister(prop.getProperty("fName"), prop.getProperty("lName"), prop.getProperty("username"), prop.getProperty("password"));
//	}
	@Test (priority = 1)
	public void loginPageTitleTest()
	{
		String actTitle = loginPage.getLoginPageTitle();
		System.out.println("Page title :"+actTitle);
		
		Assert.assertEquals(actTitle,Constants.LOGIN_PAGE_TITLE);
	}
	@Test (priority = 2)
	public void loginPageUrlTest()
	{
		
		Assert.assertTrue(loginPage.getLoginPageUrl());

	}
	@Test(priority = 3)
	public void forgotPwdLinkTest()
	{
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	@Test(priority = 4)
	public void registerLinkExistTest()
	{
		Assert.assertTrue(loginPage.isRegisterLinkExist());
	}
	@Test(priority = 5)
	public void doLoginTest()
	{
		accountsPage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		Assert.assertEquals(accountsPage.getAccountsPageTitle(),Constants.ACCOUNTS_PAGE_TITLE);
	}
}
