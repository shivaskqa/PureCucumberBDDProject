package com.virtusa.bdd.tests;

import org.openqa.selenium.WebDriver;

import com.virtusa.bdd.pages.HomePage;
import com.virtusa.bdd.pages.LoginPage;

public class LoginTest {

	LoginPage lpage;
	HomePage hpage;
	WebDriver driver;

	
	public LoginTest(WebDriver driver)
	{
        this.driver=driver;		
		lpage=new LoginPage(this.driver);
	}
	
	
	
	public void enterCredentials(String username,String password)
	{
		
		lpage.setUsername(username);
		lpage.setPassword(password);
	
		
	}
	public void clickSubmit()
	{
		
		hpage=lpage.clickSubmit();}
}
