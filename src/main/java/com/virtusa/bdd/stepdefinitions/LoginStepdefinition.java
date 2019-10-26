package com.virtusa.bdd.stepdefinitions;


import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;
import com.virtusa.bdd.pages.BasePage;
import com.virtusa.bdd.tests.LoginTest;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;


public class LoginStepdefinition {

	WebDriver driver;
	LoginTest ltest;
	Properties prop;


	@Before("@logintest")
	public void beforeScenario() {

		prop = BasePage.getProperties();
		driver = BasePage.initializeDriver();
		
	}
	
		
@Given("^user is on CRMPRO application login page$")
public void user_is_on_CRMPRO_application_login_page() throws Throwable {
 
	driver.get(prop.getProperty("url"));
	ltest=new LoginTest(driver);
   
	
}

@When("^user enters valid username,password$")
public void user_enters_valid_username_password() throws Throwable {
    
	ltest.enterCredentials(prop.getProperty("username"),prop.getProperty("password"));
	
	
}

@Then("^Home Page should be displayed$")
public void home_Page_should_be_displayed() throws Throwable {
	ltest.clickSubmit();
	new WebDriverWait(driver,20).until(ExpectedConditions.titleContains("CRMPRO"));
	String titleOfPage=driver.getTitle();
	Assert.assertEquals("CRMPRO",titleOfPage);
}

@When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
public void user_enters_username_and_password_from_examples(String user, String pass) throws Throwable {
    
	System.out.println("Following credentials are supplied from scenario outline - Example");
	System.out.println("Supplied Username is: "+user);
	System.out.println("Supplied Password is: "+pass);
	ltest.enterCredentials(user,pass);
    ltest.clickSubmit();
	
}

@Then("^user should re-direct to login page again$")
public void user_should_re_direct_to_login_page_again() throws Throwable {
    
	new WebDriverWait(driver,20).until(ExpectedConditions.titleContains("CRM software for customer relationship management, sales, and support."));
	String titleOfPage=driver.getTitle();
	System.out.println(titleOfPage);
	//Assert.assertEquals("CRMPRO  - CRM software for customer relationship management, sales, and support.",titleOfPage);
	
}

@When("^user enters username,password$")
public void user_enters_username_password(DataTable data) throws Throwable {
    
	
	List<List<String>> creds=data.raw();
	
	System.out.println("username: "+creds.get(0).get(0));
	System.out.println("Password :"+creds.get(0).get(1));
	
	ltest.enterCredentials(creds.get(0).get(0),creds.get(0).get(1));
	
	ltest.clickSubmit();
	
	
}

@Then("^user should be re-directed to login page again$")
public void user_should_be_re_directed_to_login_page_again() throws Throwable {
    
	new WebDriverWait(driver,20).until(ExpectedConditions.titleContains("CRM software for customer relationship management, sales, and support."));
	String titleOfPage=driver.getTitle();
	System.out.println(titleOfPage);
	//Assert.assertEquals("CRMPRO  - CRM software for customer relationship management, sales, and support.",titleOfPage);
    
	
}

@After("@logintest")
public void afterScenario(Scenario scenario)  {

	String screenshotName = scenario.getName().replaceAll(" ", "_");
	Calendar c=Calendar.getInstance();
	
		  
	try
	{
		  //This takes a screenshot from the driver at save it to the specified location
		 File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 
		 //Building up the destination path for the screenshot to save
		 //Also make sure to create a folder 'screenshots' with in the cucumber-report folder
		 
		 File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName +c.getTimeInMillis()+".png");
		 
		 System.out.println(destinationPath==null);
		 
		 //Copy taken screenshot from source location to destination location
		 FileUtils.copyFile(sourcePath, destinationPath);   
		 
		 //This attach the specified screenshot to the test
		 Reporter.addScreenCaptureFromPath(destinationPath.toString());

		 
		 
	}
	catch(Throwable ie)
	{
		ie.printStackTrace();
		
	}
	
	finally
	{
		if(driver!=null)
		 driver.quit();
	}	
}





}
