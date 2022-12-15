package com.qa.eom.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	public Properties prop;
	/**
	 * This method is used to initialize webdriver 
	 * @param browserName
	 * @return this will return driver
	 */
	
	public WebDriver init_Driver(Properties prop)
	{
		String browserName =prop.getProperty("browser");
		System.out.println("Browser name is : "+browserName);
		
		if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		else if(browserName.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		else if(browserName.equals("safari"))
		{
			
			driver = new SafariDriver();
			
		}
		else
		{
			System.out.println("Please enter valid browser name");
		}
			
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		
		return driver;
	}
	/**
	 * used to initialize properties
	 * @return will return properties
	 */
	public Properties init_prop()
	{
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
		
	}

}
