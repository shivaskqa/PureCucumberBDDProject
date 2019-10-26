package com.virtusa.bdd.tests;

import org.openqa.selenium.WebDriver;

import com.virtusa.bdd.pages.CompanyPage;
import com.virtusa.bdd.pages.ContactsPage;
import com.virtusa.bdd.pages.DealsPage;
import com.virtusa.bdd.pages.HomePage;

public class HomeTest {

	WebDriver driver;
	HomePage hpage;
	CompanyPage cpage;
	ContactsPage ctpage;
	DealsPage dpage;
	
	
	public HomeTest(WebDriver driver)
	{
		
		this.driver=driver;
		hpage=new HomePage(this.driver);
		
	}
	
	public void clickCompanyTab()
	{
		
		cpage=hpage.clickCompaniesTab();
		
	}
	
	public void clickContactsTab()
	{
		ctpage=hpage.clickContactsTab();
	}
	
	public void clickDealsPage()
	{
		dpage=hpage.clickDealsTab();
	}
	
	public void titleofpage()
	{
	  String title=driver.getTitle();
	  System.out.println(title);
	}
	
}
