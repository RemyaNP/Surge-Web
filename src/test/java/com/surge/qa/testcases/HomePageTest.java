package com.surge.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.surge.qa.base.SurgeBase;
import com.surge.qa.pages.HomePage;

public class HomePageTest extends SurgeBase {
	HomePage homepage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialize();
		HomePage homepage = new HomePage();
	}
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	
	@Test(priority=0)
	public void verifySurgeHomePageUrlAndElements() {
		
	}
}
