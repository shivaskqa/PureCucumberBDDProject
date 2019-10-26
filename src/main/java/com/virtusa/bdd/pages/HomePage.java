package com.virtusa.bdd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
	WebDriver driver;
	WebDriverWait wait;
	private By companies_tab=By.xpath("//a[contains(text(),'Companies')]");
	private By contatcs_tab=By.xpath("//a[contains(text(),'Contacts')]");
	private By home_tab=By.xpath("//a[@title='Home']");
	private By deals_tab=By.xpath("//a[@title='Deals']");
	
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public ContactsPage clickContactsTab()
	{
		
		switchToFrame("mainpanel");
		waitForElementtoload(contatcs_tab);
		moveToElement(contatcs_tab);
				
		return new ContactsPage(driver);
		
	}

	public CompanyPage clickCompaniesTab()
	{
	
		switchToFrame("mainpanel");
		waitForElementtoload(companies_tab);
		moveToElement(companies_tab);
		
		return new CompanyPage(driver);
	}
	
	public DealsPage clickDealsTab()
	{
		
		switchToFrame("mainpanel");
		waitForElementtoload(deals_tab);
		moveToElement(deals_tab);
		
		return new DealsPage();
	}
	
	
	
}
