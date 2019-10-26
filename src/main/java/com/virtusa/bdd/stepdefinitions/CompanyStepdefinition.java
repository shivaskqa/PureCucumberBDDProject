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

import com.cucumber.listener.Reporter;
import com.virtusa.bdd.pages.BasePage;
import com.virtusa.bdd.tests.CompanyTest;
import com.virtusa.bdd.tests.HomeTest;
import com.virtusa.bdd.tests.LoginTest;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CompanyStepdefinition {

	WebDriver driver;
	Properties prop;
	static LoginTest ltest;
	static HomeTest htest;
	static CompanyTest ctest;

	
	
	@Before("@companytest")
	public void beforeScenario() {

		prop = BasePage.getProperties();
		driver = BasePage.initializeDriver();
		
	}
	
	
	
	@Given("^user launches the application$")
	public void user_launches_the_application() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
	
	
		driver.get(prop.getProperty("url"));

	}

	@When("^user enters valid credentials$")
	public void user_enters_valid_credentials() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		ltest = new LoginTest(driver);
		ltest.enterCredentials(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Then("^user should be successfully logged in$")
	public void user_should_be_successfully_logged_in() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		ltest.clickSubmit();
		System.out.println(driver.getTitle());

	}

	@Given("^User is in HomePage and hover on Company Tab$")
	public void user_is_in_HomePage_and_hover_on_Company_Tab() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		htest = new HomeTest(driver);
		htest.clickCompanyTab();

	}

	@Given("^click on New company link$")
	public void click_on_New_company_link() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
        ctest=new CompanyTest(driver); 
		ctest.clickNewCompany();

	}

	@When("^User enters the details$")
	public void user_enters_the_details(DataTable dataTable) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)

		List<List<String>> data = dataTable.raw();

		String cname = data.get(0).get(0);
		System.out.println(cname);
		String iname = data.get(0).get(1);
		System.out.println(iname);
		String status = data.get(0).get(2);
		System.out.println(status);
		String category = data.get(0).get(3);
		System.out.println(category);
		String priority = data.get(0).get(4);
		System.out.println(priority);
		
		ctest.feedDatainForm(cname, iname, status, category, priority);

	}

	@When("^click on Save button in new Company form$")
	public void click_on_Save_button_in_new_Company_form() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		ctest.clickSave();

	}

	@Then("^company details should be saved successfully$")
	public void company_details_should_be_saved_successfully() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		ctest.verifyHeaderText();

	}

	@When("^User enters \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void user_enters(String company, String industry, String status, String category, String priority)
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		ctest.feedDatainForm(company, industry, status, category, priority);

	}

	@After("@companytest")
	public void afterScenario(Scenario scenario)throws Throwable {

		String screenshotName = scenario.getName().replaceAll(" ", "_");
		Calendar c=Calendar.getInstance();
		
			 //This takes a screenshot from the driver at save it to the specified location
			 File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 
			 //Building up the destination path for the screenshot to save
			 //Also make sure to create a folder 'screenshots' with in the cucumber-report folder
			 
			 File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName +c.getTimeInMillis()+".png");
			 
			 //Copy taken screenshot from source location to destination location
			 FileUtils.copyFile(sourcePath, destinationPath);   
			 
			 //This attach the specified screenshot to the test
			 Reporter.addScreenCaptureFromPath(destinationPath.toString());
			 
			 Thread.sleep(10000);
			 
			 tearDown();
		}

	
	public void tearDown() {
  
		driver.quit();
	}

	
	
}
