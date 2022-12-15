package com.qa.eom.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.utils.Constants;

public class AccountsPageTest extends BaseTest
{
	@BeforeClass
	public void accPageSetup()
	{
		accountsPage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void accPageTitleTest()
	{
		String actTitle = accountsPage.getAccountsPageTitle();
		System.out.println(actTitle);
		Assert.assertEquals(actTitle,Constants.ACCOUNTS_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void isLogoutExistsTest()
	{
		Assert.assertTrue(accountsPage.isLogoutExist());
	}
	
	@Test(priority = 3)
	public void accPageSectionsTest()
	{
		List<String> accSectionList = accountsPage.getAccountSecList();
		Assert.assertEquals(accSectionList, Constants.expectedAccountSectionList());
	}
	
	@DataProvider
	public Object[][] productList()
	{
		Object [][] prodName = {
				{"MacBook Pro"},
				{"Samsung"},
				{"Lenovo"}
				};
		return prodName;
		
	}
	@Test(priority = 4 , dataProvider = "productList")
	public void searchTest(String prodName)
	{
		accountsPage.doSearch(prodName);
	}

}
