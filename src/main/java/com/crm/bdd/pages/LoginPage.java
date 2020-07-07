package com.crm.bdd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.crm.bdd.pagebase.PageBase;

public class LoginPage extends PageBase {
	
	public LoginPage(WebDriver driver) throws Exception {
		super(driver);
	}

	public HomePage login(String username, String password) throws Exception {
		
		try {
	    	CommonMethods.setElementText(ORparser.getElement("login.username"), username);
	    	//Thread.sleep(1000);
	    	CommonMethods.setElementText(ORparser.getElement("login.password"), password);
	    	//Thread.sleep(1000);
	    	wait.until(ExpectedConditions.invisibilityOf(ORparser.getElement("login.preloader")));
	    	CommonMethods.clickOnWebElement(ORparser.getElement("login.loginBtn"));
	    	//Thread.sleep(2000);
	    	
	    	return new HomePage(driver);
		} catch(Exception e) {
			throw e;
		}
	}
	
	
}
