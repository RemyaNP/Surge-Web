package com.surge.qa.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class SurgeBase {


		public static WebDriver driver;
		public static String chromepath = "/home/remya/Desktop/chromedriver_linux64/chromedriver";
		public static Properties prop;
		public static String firefoxpath = "/home/remya/eclipse-workspace/Internal Dashboard//geckodriver-v0.26.0-linux32/geckodriver";
		
		public SurgeBase() {
			try {
				prop = new Properties();
				FileInputStream prop_stream = new FileInputStream("/home/remya/Surge workspace/SurgeWeb/src/main/java/com/surge/qa/config/SurgeConfig.properties");
				prop.load(prop_stream);
			}			
			catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		public void initialize() {
			String browser = prop.getProperty("browser");
			if(browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", chromepath);
				driver = new ChromeDriver();
			}
			else if(browser.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", firefoxpath);
				driver = new FirefoxDriver();
			}
			
			driver.get(prop.getProperty("url"));
		}
		public void waitForElementPresent(WebElement element) {
			for(int second = 0; ;second++)
			{
				if (second >= Integer.parseInt((prop.getProperty("TimeOutsForElementWait"))))
					Assert.fail("Unable to find the Specified element" + element);
				try {
					if (element.isDisplayed())
						break;
				} 
				catch (Exception e) {
				}
			}
		}
}


