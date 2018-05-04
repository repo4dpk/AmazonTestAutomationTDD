package com.amzon.testFramework.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.amazon.testFramework.qa.base.TestBase;

public class HomePage extends TestBase{
	
	// define the page factory 
	
	@FindBy(xpath="//*[@id='q']")
	WebElement Search;
	
	@FindBy(xpath="//*[@id='submit']")
	WebElement Go;
	
	@FindBy(xpath="//*[@id='header']/h1/a")
	WebElement Title;
	
// initializing the page objects
	
public HomePage() {
	PageFactory.initElements(driver, this);
}

// Actions

public String validateLoginPageTitle() {	
	return driver.getTitle();
}

public boolean validateLogo() {
	return Title.isDisplayed();
}

public searchResultPage search_string(String toSearch) {	
	Search.sendKeys(toSearch);
	Go.click();
	
	return new searchResultPage();
}

}
