package com.crm.bdd.pagebase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.bdd.utils.CommonMethods;
import com.crm.bdd.utils.Constants;
import com.crm.bdd.utils.ORParser;

public class PageBase {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public ORParser ORparser;
	public CommonMethods CommonMethods;
	
	public PageBase(WebDriver driver) throws Exception {
		try {
			this.driver = driver;
			wait = new WebDriverWait(this.driver, new Constants().EXPLICIT_TIMEOUT);
			ORparser = new ORParser(this.driver);
			CommonMethods = new CommonMethods(this.driver, wait);
		} catch(Exception e) {
			throw e;
		}
	}
	
	public String getPageTitle() throws Exception {
		return driver.getTitle();
	}
	
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

}
