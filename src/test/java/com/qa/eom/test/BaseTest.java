package com.qa.eom.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.eom.factory.DriverFactory;
import com.qa.eom.pages.AccountsPage;
import com.qa.eom.pages.LoginPage;
import com.qa.eom.pages.RegisterPage;

public class BaseTest 
{
	DriverFactory df;
	WebDriver driver;
	Properties prop;
	LoginPage loginPage;
	RegisterPage registerPage;
	AccountsPage accountsPage;
	
	@BeforeTest
	public void setup()
	{
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.init_Driver(prop);
		//registerPage = new RegisterPage(driver);
		loginPage = new LoginPage(driver);
		
		
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
