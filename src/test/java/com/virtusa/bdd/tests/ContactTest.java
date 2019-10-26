package com.virtusa.bdd.tests;

import org.openqa.selenium.WebDriver;

import com.virtusa.bdd.pages.ContactsPage;

import junit.framework.Assert;

public class ContactTest {

	WebDriver driver;
	ContactsPage contactPage;
	String resString=null;
	
	public ContactTest(WebDriver driver)
	{
		this.driver=driver;
		contactPage=new ContactsPage(this.driver);
	}
	
	public void clickNewContact()
	{
		contactPage.clickNewContact();
	}
	
	public void feedContactForm(String title, String fname,String sname,String companyname,String source,String msgner,String date,String timezone,String country)
	{
		
		resString=fname+" "+sname;
		
		System.out.println(resString);
		
		contactPage.setTitle(title);
		contactPage.setFirstName(fname);
		contactPage.setSurName(sname);
		contactPage.setCompanyName(companyname);
		contactPage.setSource(source);
        contactPage.setMessenger(msgner);
        contactPage.setTimeZone(timezone);
        contactPage.setCountry(country);
        contactPage.setAllowCallsFlag();
        contactPage.setReceiveEmailFlag();
        contactPage.setReceiveSMSFlag();
        contactPage.setBirthDate(date);	
		
	}
	
	public void feedContactFormByCompanyLookUp(String title, String fname,String sname,String companyname,String source,String msgner,String date,String timezone,String country)
	{
		
		resString=fname+" "+sname;
		
		System.out.println(resString);
		
		contactPage.setTitle(title);
		contactPage.setFirstName(fname);
		contactPage.setSurName(sname);
		contactPage.setCompanyNameByLookUp(companyname);
		contactPage.setSource(source);
        contactPage.setMessenger(msgner);
        contactPage.setTimeZone(timezone);
        contactPage.setCountry(country);
        contactPage.setAllowCallsFlag();
        contactPage.setReceiveEmailFlag();
        contactPage.setReceiveSMSFlag();
        contactPage.setBirthDate(date);	
		
        
		
	}
	
	
	
	
	public void clickSave() {
		
		contactPage.clickSave();
		
	}
    
	public void verifyHeaderInContactsPage()
	{
		String text=contactPage.verifyHeader();
		System.out.println(text);
		Assert.assertEquals(text, resString);
	}

}
