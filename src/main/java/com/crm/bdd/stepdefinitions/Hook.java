package com.crm.bdd.stepdefinitions;

import java.util.Hashtable;

import org.openqa.selenium.WebDriver;

import com.crm.bdd.reporting.ExtentReportUtil;
import com.crm.bdd.utils.DriverManager;
import com.crm.bdd.utils.ExcelDataReader;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook {
	
	protected static WebDriver driver;
	private static Hashtable<String, String> TestParams;
	protected ExtentReportUtil ReportingUtil;
	
	@Before
	public void setUp(Scenario scenario) throws Exception {
		
		try {
			DriverManager Drivermanager = new DriverManager();
			driver = Drivermanager.CreateDriver();
			
			if (driver == null)
				throw new Exception("Could not initialize the Browser");
		
			ExcelDataReader DataProvider = new ExcelDataReader();
			TestParams = DataProvider.get("TestData", scenario.getName());
			
			ReportingUtil = new ExtentReportUtil();
			ReportingUtil.addScenarioNode(scenario.getName());

		} catch(Exception e) {
			throw new Exception("Exception while setting up before scenario starts: " + e.getMessage());
		}
	}
	
	@After
	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.quit();
		TestParams.clear();
		ReportingUtil.flushReport();
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static Hashtable<String, String> getTestParams(){
		return TestParams;
	}
}
