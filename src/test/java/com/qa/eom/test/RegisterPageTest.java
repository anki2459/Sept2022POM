package com.qa.eom.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterPageTest extends BaseTest
{
	
	@Test(priority = 2)
	public void checkHeadingTest()
	{
		Assert.assertEquals(registerPage.checkHeading(), "Register Account");
	}
	@Test(priority = 1)
	public void doRegisterPageTest()
	{
		registerPage.doRegister(prop.getProperty("fName"), prop.getProperty("lName"), prop.getProperty("username"), prop.getProperty("password"));
	}

}
