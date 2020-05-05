package com.surge.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.surge.qa.base.SurgeBase;

public class HomePage extends SurgeBase {
	
	@FindBy(xpath="//span[text()='Sign in with LinkedIn']")
	WebElement SignInWithLinkedIn;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String getHomePage() {
		return driver.getCurrentUrl();
	}
}
