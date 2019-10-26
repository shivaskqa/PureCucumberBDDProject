package com.virtusa.bdd.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	static WebDriver driver;
	static Properties prop;
	static FileInputStream fis;
	static WebDriverWait wait;;
	
	public static WebDriver initializeDriver()
	{
	try
	{
		String browsername=prop.getProperty("browser");
	
	if(browsername.equalsIgnoreCase("chrome"))
	{
		
	WebDriverManager.chromedriver().setup();
			
	}
	else if(browsername.equalsIgnoreCase("edge"))
	{
		
		WebDriverManager.edgedriver().setup();
		
	}
		
	else
	{
		WebDriverManager.firefoxdriver().setup();
	}
		
	}
	
	catch(Exception e)
	{
	  e.printStackTrace();
	}
	
	driver=new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
		
	return driver;
	
	}
	
	public static Properties getProperties()
	{
		try
		{
		fis=new FileInputStream("src\\main\\java\\com\\virtusa\\bdd\\config\\config.properties");
		prop=new Properties();
		prop.load(fis);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	
		
		return prop;
	}
	
	public boolean elementIsDisplayed(By locator)
	{
		waitForElementtoload(locator);
		return driver.findElement(locator).isDisplayed();
	}
	
	public void waitForElementtoload(By locator)
	{
		wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
	
	public void moveToElement(By locator)
	{
		
		Actions actions=new Actions(driver);
		actions.moveToElement(driver.findElement(locator)).build().perform();
				
	}
	
	public static void tearDown()
	{
		
		driver.quit();
		
		
	}
	
	public void switchToFrame(String frameName)
	{
		wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
		//driver.switchTo().frame(frameName);
	}

	public void switchToWindow(String winName)
	{
		
	   driver.switchTo().window(winName);
		
	}
}
