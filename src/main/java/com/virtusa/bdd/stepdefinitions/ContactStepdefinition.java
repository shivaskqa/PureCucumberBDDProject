package com.virtusa.bdd.stepdefinitions;

import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;
import com.virtusa.bdd.pages.BasePage;
import com.virtusa.bdd.tests.ContactTest;
import com.virtusa.bdd.tests.HomeTest;
import com.virtusa.bdd.tests.LoginTest;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ContactStepdefinition {

	WebDriver driver;
	Properties prop;
	static LoginTest ltest;
	static HomeTest htest;
	static ContactTest ctest;

	@Before("@contacttest")
	public void setUp() {

		prop = BasePage.getProperties();
		driver = BasePage.initializeDriver();
	}

	@Given("^user hit the application URL in the browser$")
	public void user_hit_the_application_URL_in_the_browser() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		driver.get(prop.getProperty("url"));

	}

	@When("^user enters valid user credentials$")
	public void user_enters_valid_user_credentials() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		ltest = new LoginTest(driver);
		ltest.enterCredentials(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Then("^user should be in Home Page successfully$")
	public void user_should_be_in_Home_Page_successfully() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		ltest.clickSubmit();
		System.out.println(driver.getTitle());
	}

	@Given("^that user hovers Contacts Tab in Home$")
	public void that_user_hovers_Contacts_Tab_in_Home() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		htest = new HomeTest(driver);
		htest.clickContactsTab();

	}

	@Given("^click on New Contacts link under Contacts Tab$")
	public void click_on_New_Contacts_link_under_Contacts_Tab() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		ctest = new ContactTest(driver);
		ctest.clickNewContact();

	}

	@When("^user enters data in the mandatory fields in new contact page$")
	public void user_enters_data_in_the_mandatory_fields_in_new_contact_page(DataTable dataTable) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)
		// |Mr.|Sri|Shanmukha|Delloitte.|Internet|Google Talk|14-Oct-1982|IST - India
		// Standard Time|India|

		List<List<String>> data = dataTable.raw();

		String title = data.get(0).get(0);
		System.out.println(title);

		String fname = data.get(0).get(1);
		System.out.println(fname);

		String sname = data.get(0).get(2);
		System.out.println(sname);

		String companyname = data.get(0).get(3);
		System.out.println(companyname);

		String source = data.get(0).get(4);
		System.out.println(source);

		String messenger = data.get(0).get(5);
		System.out.println(messenger);

		String bdate = data.get(0).get(6);
		System.out.println(bdate);

		String timezone = data.get(0).get(7);
		System.out.println(timezone);

		String country = data.get(0).get(8);
		System.out.println(country);

		ctest.feedContactForm(title, fname, sname, companyname, source, messenger, bdate, timezone, country);

	}

	@Then("^details should be saved successfully$")
	public void details_should_be_saved_successfully() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		ctest.clickSave();
		ctest.verifyHeaderInContactsPage();

	}

	@When("^user enters details \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void user_enters_details(String title, String first_name, String surName, String companyName, String source,
			String msgner, String birthdate, String timezone, String country) throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		ctest.feedContactForm(title, first_name, surName, companyName, source, msgner, birthdate, timezone, country);

	}

	@When("^user enters data in the mandatory fields in new contact page by company lookup$")
	public void user_enters_data_in_the_mandatory_fields_in_new_contact_page_by_company_lookup(DataTable dataTable)
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)

		List<List<String>> data = dataTable.raw();

		String title = data.get(0).get(0);
		System.out.println(title);

		String fname = data.get(0).get(1);
		System.out.println(fname);

		String sname = data.get(0).get(2);
		System.out.println(sname);

		String companyname = data.get(0).get(3);
		System.out.println(companyname);

		String source = data.get(0).get(4);
		System.out.println(source);

		String messenger = data.get(0).get(5);
		System.out.println(messenger);

		String bdate = data.get(0).get(6);
		System.out.println(bdate);

		String timezone = data.get(0).get(7);
		System.out.println(timezone);

		String country = data.get(0).get(8);
		System.out.println(country);

		ctest.feedContactFormByCompanyLookUp(title, fname, sname, companyname, source, messenger, bdate, timezone,
				country);

	}

	@When("^user enters details \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" by company lookup$")
	public void user_enters_details_by_company_lookup(String Title, String First_Name, String SurName,
			String Company_Name, String Source, String Messenger, String Birthdate, String Timezone, String Country)
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		ctest.feedContactFormByCompanyLookUp(Title, First_Name, SurName, Company_Name, Source, Messenger, Birthdate,
				Timezone, Country);

	}

	@After("@contacttest")
	public void afterScenario(Scenario scenario) throws Throwable {

		String screenshotName = scenario.getName().replaceAll(" ", "_");
		Calendar c = Calendar.getInstance();

		// This takes a screenshot from the driver at save it to the specified location
		File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Building up the destination path for the screenshot to save
		// Also make sure to create a folder 'screenshots' with in the cucumber-report
		// folder

		File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/"
				+ screenshotName + c.getTimeInMillis() + ".png");

		// Copy taken screenshot from source location to destination location
		FileUtils.copyFile(sourcePath, destinationPath);

		// This attach the specified screenshot to the test
		Reporter.addScreenCaptureFromPath(destinationPath.toString());

		Thread.sleep(10000);

		tearDown();
	}

	public void tearDown() {

		driver.quit();
	}

}
