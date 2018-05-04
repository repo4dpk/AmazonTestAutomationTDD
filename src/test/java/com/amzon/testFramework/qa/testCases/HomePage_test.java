package com.amzon.testFramework.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.testFramework.qa.base.TestBase;
import com.amzon.testFramework.qa.pages.HomePage;
import com.amzon.testFramework.qa.pages.searchResultPage;

public class HomePage_test extends TestBase{

	HomePage HP;
	searchResultPage srp;
	
	public HomePage_test() {
		
		super();
	}
	
	
	@BeforeMethod
	public void setup() {
		
		intitialization();
		HP = new HomePage();	
	}
	
	@Test(priority=1)
	public void HomePage_searchTest() {
		String Title = HP.validateLoginPageTitle();
		Assert.assertEquals(Title,"Selenium - Web Browser Automation");
	}
	
	@Test(priority=2) 
	public void HomePagelogoTest() {
		boolean flag = HP.validateLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void SearchTest() {
		 System.out.println("Search string");
		 srp = HP.search_string(prop.getProperty("search"));
		 System.out.println("Returned_search");
	}
		
	
	@AfterMethod
	public void teardn() {
		driver.quit();
	}
	
	
	
}
