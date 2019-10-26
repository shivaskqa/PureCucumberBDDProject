package com.virtusa.bdd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
	
	private By txt_username=By.cssSelector("input[name='username']");
	private By txt_password=By.cssSelector("input[name='password']");
	private By btn_submit=By.cssSelector("input[type='submit']");
	WebDriver driver;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	public void setUsername(String username) {
		
		waitForElementtoload(txt_username);
	     	driver.findElement(txt_username).sendKeys(username);
		
	}
	
	public void setPassword(String password)
	{
		waitForElementtoload(txt_password);
		 driver.findElement(txt_password).sendKeys(password);
		
		
	}
	
	public HomePage clickSubmit()
	{
		wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(btn_submit));
		
		WebElement submitbtn=driver.findElement(btn_submit);
		
		if(submitbtn.isEnabled() || submitbtn.isDisplayed())
		{
			submitbtn.submit();
		}
		
		return new HomePage(driver);
	}
	
	public String getTitle()
	{
	    String title=driver.getTitle();
		
		return title;
	}
	
		
}


