package com.crm.bdd.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.bdd.utils.BrowserType;
import com.crm.bdd.utils.ConfigFileReader;
import com.crm.bdd.utils.Constants;
import com.crm.bdd.utils.EventHandler;

public class DriverManager {
	
	public WebDriver CreateDriver() throws Exception {
		
		WebDriver driver = null;
		
		try {
			
			ConfigFileReader configFileReader = new ConfigFileReader();
			switch(configFileReader.getBrowserType()) {
			
				case CHROME:
					System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath(BrowserType.CHROME));
					driver =new  ChromeDriver();
					
				case FIREFOX:
					System.setProperty("webdriver.gecko.driver", configFileReader.getDriverPath(BrowserType.FIREFOX));
					driver = new FirefoxDriver();
			
			}
			
			if (driver != null) {
				
				EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
				EventHandler eventHandler = new EventHandler();
				eventDriver.register(eventHandler);
				driver = eventDriver;
				
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				driver.get(configFileReader.getURL());
				
				driver.manage().timeouts().pageLoadTimeout(new Constants().PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(new Constants().IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
			}
			return driver;
		} catch(Exception e) {
			throw e;
		}
	}
	

}
