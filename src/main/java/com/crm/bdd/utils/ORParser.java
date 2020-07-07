package com.crm.bdd.utils;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ORParser {
	
	private Properties ObjectRep;
	private WebDriver driver;
	
	public ORParser(WebDriver driver) throws Exception {
		
		try {
			
			ConfigFileReader configFileReader = new ConfigFileReader();
			ObjectRep = new Properties();
			ObjectRep.load(new FileInputStream(configFileReader.getObjectRepPath()));
			
			this.driver = driver;
			
		} catch(Exception e) {
			throw e;
		}
	}
	private String Key;
	private String Value;
	
	public String getObjectProperty(String ObjName) {
		try {
			return ObjectRep.getProperty(ObjName);
		} catch(Exception e) {
			throw e;
		}
	}
		
	public By getBy(String ObjName) throws Exception {
		
		String prop = ObjectRep.getProperty(ObjName);
		
		Key = prop.split(":")[0];
		Value = prop.split(":")[1];
		
		switch(Key.toLowerCase()) {
		 
		case "name":
			return By.name(Value);
			
		case "id":
			return By.id(Value);
			
		case "linktext":
			return By.linkText(Value);
			
		case "partiallinktext":
			return By.partialLinkText(Value);
	
		case "tagname":
			return By.tagName(Value);
			
		case "cssselector":
			return By.cssSelector(Value);
		
		case "classname":
			return By.cssSelector(Value);
			
		case "xpath":
			return By.xpath(Value);
		default:
			throw new Exception("Exception from LocationParser.getBy: Unknown locator type '" + Key + "'");

		}
	}
	
	
	public WebElement getElement(String objName) throws Exception {
		try {
			return driver.findElement(getBy(objName));
		} catch(Exception e) {
			throw new Exception("Exception while Parsing object " + objName + " from ObjectRepository: " + e.getMessage());
		}
	}
}
