package com.virtusa.bdd.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class ContactsPage extends BasePage{
	
	
	WebDriver driver;
	Select select;
	String parentWinHandle;
	
	private By newContactTab=By.cssSelector("a[title='New Contact']");
	private By title=By.cssSelector("select[name=title]");
	private By fname=By.cssSelector("input[id=first_name]");
	private By surname=By.cssSelector("input[id=surname]");
	
	private By company_lookup=By.xpath("//tr[8]//input[@type='button' and @value='Lookup']");
	private By company_txt=By.cssSelector("input[name=client_lookup]");
	
	private By receiveemail_YN=By.cssSelector("input[name='receive_email'][value='N']");
	private By receivesms_YN=By.cssSelector("input[name='receive_sms'][value='N']");
	private By allowcalls_YN=By.cssSelector("input[name='allows_call'][value='N']");
	private By source=By.xpath("//select[@name='source']");
	private By msngr=By.xpath("//select[@name='im_netowrk']");
	
	private By timezone=By.cssSelector("select#timezone");
	private By country=By.cssSelector("select[name='country']");
	
	private By btn_Save=By.cssSelector("form#contactForm input[type='submit']");
	
	private By header=By.cssSelector("td.tabs_header");
	
	
	public ContactsPage(WebDriver driver)
	{
		
	  this.driver=driver;	
	}

	public void clickNewContact()
	{
		waitForElementtoload(newContactTab);
		driver.findElement(newContactTab).click();
		
	}
	
	public void setTitle(String txttitle)
	{
		waitForElementtoload(title);
		select=new Select(driver.findElement(title));
		select.selectByVisibleText(txttitle);
	}
	
	public void setFirstName(String firstname)
	{
		waitForElementtoload(fname);
		driver.findElement(fname).sendKeys(firstname);
	}
	public void setSurName(String sname)
	{
	   waitForElementtoload(surname);
	   driver.findElement(surname).sendKeys(sname);
	}
	
	public void setCompanyNameByLookUp(String companyname)
	{
		
		System.out.println("Inside the setCompanyNameByLookUp method");
		
		//Click on LookUp button to search and set company name
		//waitForElementtoload(company_lookup);
		
		String parentWinHandle=driver.getWindowHandle();
		
		System.out.println("Get Current Window Handle: "+parentWinHandle);
		
		driver.findElement(company_lookup).click();
		
		Set<String> winHandles=driver.getWindowHandles();
		
		System.out.println(winHandles);
		
		for(String handle:winHandles)
		{
			if(!handle.equalsIgnoreCase(parentWinHandle))
				{
				 switchToWindow(handle);
				 System.out.println("Current Title of the Window : "+driver.getTitle());
				 waitForElementtoload(By.cssSelector("input[name='search']"));
				 driver.findElement(By.cssSelector("input[name='search']")).sendKeys(companyname);
				 driver.findElement(By.cssSelector("input[type='submit']")).click();
				 List<WebElement> list=driver.findElements(By.cssSelector("td.datafield a"));
				 
				 int listCount=list.size();
				 
				 System.out.println("Search List size in Company Search LookUp:"+ listCount);
				 
				 if(listCount >1)
				 {
					 for(WebElement e: list)
					 {
						  if(e.getText().equalsIgnoreCase(companyname))
						  {
							 Actions action=new Actions(driver);
							 action.moveToElement(e).contextClick().build().perform();
							 
						  }
					}
					 
				 }
				 else
					 { 
					   list.get(0).click();
					 }
				 				 
				}
		}
		
		switchToWindow(parentWinHandle);
		switchToFrame("mainpanel");
		System.out.println(driver.getTitle());
	}
	
	public void setCompanyName(String companyname)
	{
		waitForElementtoload(company_txt);
		driver.findElement(company_txt).sendKeys(companyname);
	}
	
	public void setReceiveEmailFlag()
	{
		waitForElementtoload(receiveemail_YN);
		driver.findElement(receiveemail_YN).click();
	}
	
	public void setReceiveSMSFlag()
	{
		waitForElementtoload(receivesms_YN);
		driver.findElement(receivesms_YN).click();
	}
	
	public void setAllowCallsFlag()
	{
		waitForElementtoload(allowcalls_YN);
		driver.findElement(allowcalls_YN).click();
	}
	
	public void setSource(String txtsource)
	{
		waitForElementtoload(source);
		select=new Select(driver.findElement(source));
		select.selectByVisibleText(txtsource);
	}
	
	public void setMessenger(String msgr)
	{
		
		waitForElementtoload(msngr);
		select=new Select(driver.findElement(msngr));
		select.selectByVisibleText(msgr);
	}
	
	public void setBirthDate(String date)
	{
	    WebElement dt=driver.findElement(By.cssSelector("input[id='fieldId_birthday']"));
	    ((JavascriptExecutor)driver).executeScript ("document.getElementById('fieldId_birthday').removeAttribute('readonly',0);"); 
	    dt.clear();
	    dt.sendKeys(date);
		
	}
	
	public void setTimeZone(String txttimeZone)
	{
	    waitForElementtoload(timezone);
	    select=new Select(driver.findElement(timezone));
	    select.selectByVisibleText(txttimeZone);
	
	}
	
	public void setCountry(String countryname)
	{
		waitForElementtoload(country);
		select=new Select(driver.findElement(country));
		select.selectByVisibleText(countryname);
	}
	
	public void clickSave()
	{
		
		waitForElementtoload(btn_Save);
		driver.findElement(btn_Save).click();
	}
	
	public String verifyHeader()
	{
		waitForElementtoload(header);
		String headertxt=driver.findElement(header).getText();
			
				return headertxt;
		
		
	}

	
}
