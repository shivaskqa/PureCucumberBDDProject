package com.virtusa.bdd.tests;

import org.openqa.selenium.WebDriver;

import com.virtusa.bdd.pages.CompanyPage;

import junit.framework.Assert;


public class CompanyTest {

	
	WebDriver driver;
	CompanyPage cpage;
	static String companyName;
	
	
	
	public CompanyTest(WebDriver driver)
	{
		this.driver=driver;
		cpage=new CompanyPage(this.driver);
		
	}
	
	public void clickNewCompany()
	{
	    
		cpage.clickNewCompanyTab();
				
	}
	
	public void feedDatainForm(String cname,String industry,String status,String category,String priority)
	{ 
	   System.out.println("We are in Company Test .. and feeding the data in form");
	   cpage.setCompanyName(cname);
	   companyName=cname;
	   System.out.println("Company name has been entered as :"+ cname);
	   cpage.setIndustry(industry);
	   System.out.println("Industry name has been entered as :"+ industry);
	   cpage.setStatus(status);
	   System.out.println("statushas been selected as :"+ status);
	   cpage.setCategory(category);
	   System.out.println("Category has been selected as :"+ category);
	   cpage.setPriority(priority);
	   System.out.println("Priority has been selected as :"+ priority);
	}
	
	public void clickSave()
	{
		cpage.clickSave();
		
	}
	public void verifyHeaderText()
	{
		String text=cpage.verifyHeaderText();
		Assert.assertEquals(companyName,text);
	}
}
