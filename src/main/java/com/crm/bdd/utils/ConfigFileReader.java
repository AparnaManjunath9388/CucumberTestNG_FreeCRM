package com.crm.bdd.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigFileReader {

	private Properties prop;
	
	public ConfigFileReader() throws Exception {
		try {
			prop = new Properties();
			prop.load(new FileInputStream("C:\\Users\\aparn\\eclipse-workspace\\CucumberTestNG_FreeCRM\\src\\main\\java\\com\\crm\\bdd\\config\\config.properties"));
		} catch(Exception e) {
			throw new Exception("Exception from ConfigFileReader: " + e.getMessage());
		}
	}
	
	public String getURL() throws Exception {
		try {
			return prop.getProperty("URL");
		} catch(Exception e) {
			throw new Exception("Exception while reading URL from Config file: " + e.getMessage());
		}
	}
	
	public BrowserType getBrowserType() throws Exception {
		
		try {
			String Browsertype = prop.getProperty("BrowserType");
			if (Browsertype.equalsIgnoreCase("chrome"))
				return BrowserType.CHROME;
			else if(Browsertype.equalsIgnoreCase("firefox"))
				return BrowserType.FIREFOX;
			else if(Browsertype.equalsIgnoreCase("ie"))
				return BrowserType.IE;
			else
				throw new Exception("Unidentified BrowserType from Config File");
		} catch(Exception e) {
			throw e;
		}	
	}
	
	public String getDriverPath(BrowserType browserType) throws Exception {
		try {
			
			switch(browserType) {
			case CHROME:
				return prop.getProperty("ChromeDriverPath").replace("userdir", System.getProperty("user.dir"));
				
			case FIREFOX:
				return prop.getProperty("FirefoxDriverPath").replace("userdir", System.getProperty("user.dir"));
				
			default:
				return prop.getProperty("IEDriverPath").replace("userdir", System.getProperty("user.dir"));
			}
			
			
		} catch(Exception e) {
			throw new Exception("Exception while reading DriverPath from Config file: " + e.getMessage());
		}	
	}
	
	public String getObjectRepPath() throws Exception {
		
		try {
			return prop.getProperty("ObjectRepPath").replace("userdir", System.getProperty("user.dir"));
		} catch(Exception e) {
			throw new Exception("Exception while reading ObjectRepPath from Config file: " + e.getMessage());
		}	
	}
	
	public String getDataFilePath() throws Exception {
		
		try {
			return prop.getProperty("DataSheetPath").replace("userdir", System.getProperty("user.dir"));
		} catch(Exception e) {
			throw new Exception("Exception while reading DataSheetPath from Config file: " + e.getMessage());
		}	
	}
	
	public String getAppName() throws Exception {
		try {
			return prop.getProperty("AppName");
		} catch(Exception e) {
			throw new Exception("Exception while reading AppName from Config file: " + e.getMessage());
		}			
	}
	
	public String getHtmlReportPath() throws Exception {
		try {
			return prop.getProperty("HtmlReportPath").replace("userdir", System.getProperty("user.dir"));
		} catch(Exception e) {
			throw new Exception("Exception while reading HtmlReportPath from Config file: " + e.getMessage());
		}		
	}
	
	public String getScreenshotPath() throws Exception {
		try {
			return prop.getProperty("ScreenshotPath").replace("userdir", System.getProperty("user.dir"));
		} catch(Exception e) {
			throw new Exception("Exception while reading ScreenshotPath from Config file: " + e.getMessage());
		}		
	}
}
