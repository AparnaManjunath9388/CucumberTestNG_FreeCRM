package com.crm.bdd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.crm.bdd.pagebase.PageBase;

public class HomePage extends PageBase {
	
	public HomePage(WebDriver driver) throws Exception {
		super(driver);
	}
	
	@Override
	public String getPageTitle() throws Exception {
		try {
			CommonMethods.switchFrame("name", "mainpanel", null);
			return driver.getTitle();
		} catch(Exception e) {
			throw e;
		} finally {
			CommonMethods.switchFrame("default", "", null);
		}
		
			
	}
	
	public boolean AssertLoggedInUser(String ExpectedUserName) throws Exception {
		try {
			String property = ORparser.getObjectProperty("home.loggedInUser").replace("username", ExpectedUserName);
			
			CommonMethods.switchFrame("name", "mainpanel", null);
			if (driver.findElement(By.xpath(property.split(":")[1])).isDisplayed())
				return true;
			else
				return false;
		} catch(Exception e) {
			throw e;
		}
		
		finally {
			CommonMethods.switchFrame("default", "", null);
		}
	}
	
	public void search(String SearchString, String WhereToSearch) throws Exception {
		try {
			CommonMethods.switchFrame("name", "mainpanel", null);
			CommonMethods.setElementText(ORparser.getElement("home.searchBox"), SearchString);
			CommonMethods.selectFromDropDown(ORparser.getElement("home.selectTarget"), WhereToSearch);
			CommonMethods.clickOnWebElement(ORparser.getElement("home.searchBtn"));
			
		} catch(Exception e) {
			throw e;
		} finally {
			CommonMethods.switchFrame("default", "", null);
		}
	}
	
	
	/*************************************************************************************
	 * quickContactCreate
	 * @param Company
	 * @param FName
	 * @param LName
	 * @throws Exception 
	 */
	//@SuppressWarnings("deprecation")
	public void quickContactCreate(String Company, String Fname, String LName) throws Exception {
		
		try {
			
			CommonMethods.switchFrame("name", "mainpanel", null);
			
			//clickOnLeftMenu("Quick Create");
			CommonMethods.clickOnWebElement(ORparser.getElement("home.quickCreate"));
			
			wait.until(ExpectedConditions.visibilityOf(ORparser.getElement("home.quickCreatebox")));
			//if (CommonMethods.elementExists("home.quickCreatebox")) {
			String[] companies = Company.split(",");
			String[] Fnames = Fname.split(",");
			String[] LNames = LName.split(",");
			
			if (companies.length == Fnames.length && Fnames.length == LNames.length) {
				for (int i=0;i<companies.length;i++) {
					CommonMethods.setElementText(ORparser.getElement("home.quickCreateCompany"), companies[i]);
					Thread.sleep(1000);
					CommonMethods.setElementText(ORparser.getElement("home.quickCreateFirstName"), Fnames[i]);
					Thread.sleep(1000);
					CommonMethods.setElementText(ORparser.getElement("home.quickCreateLastName"), LNames[i]);
					Thread.sleep(1000);
					if (i == 0)
						CommonMethods.clickOnWebElement(ORparser.getElement("home.quickCreateBtn"));
					else
						CommonMethods.clickOnWebElement(ORparser.getElement("home.quickCreateSaveBtn"));
					Thread.sleep(1000);
				}
			}
				
				CommonMethods.clickOnWebElement(ORparser.getElement("home.quickCreateCloseBtn"));
			//}
		} catch (Exception e) {
			throw e;
		} finally {
			CommonMethods.switchFrame("default", "", null);
		}
	}
	
	/*************************************************************************************
	 * searchInContacts
	 * @param FirstNames
	 * @param LLsatNames
	 * @return boolean value indicating if the contacts were found
	 */
	public boolean searchInContacts(String FNames, String LNames) throws Exception {
	
		try {
			CommonMethods.switchFrame("name", "mainpanel", null);
			ContactsPage ContactsPage = new ContactsPage(driver);
			boolean NotPresent = false;
			
			wait.until(ExpectedConditions.invisibilityOf(ORparser.getElement("home.quickCreateOverlay")));
			CommonMethods.clickOnWebElement(ORparser.getElement("home.contactsLink"));
			
			if (CommonMethods.elementExists(ORparser.getElement("contacts.advancedSearchBtn"))) {
				String[] FNameList = FNames.split(",");
				String[] LNameList = LNames.split(",");
				
				for (int i=0;i<FNameList.length;i++) {
					String Name = FNameList[i] + " " + LNameList[i];
					if (ContactsPage.searchContact(Name) < 0) {
						NotPresent = true;
					}
				}
			}
			CommonMethods.clickOnWebElement(ORparser.getElement("home.homeLink"));
			if (NotPresent)
				return false;
			else
				return true;
		} catch(Exception e) {
			throw e;
		} finally {
			CommonMethods.switchFrame("default", "", null);
		}
	}
	
	/**
	 * @throws Exception *********************************************************************************************
	 * 
	 */
	public void addBox(String BoxToAdd, String Location) throws Exception {
		
		try {
			CommonMethods.switchFrame("name", "mainpanel", null);
			wait.until(ExpectedConditions.elementToBeClickable(ORparser.getElement("home.addBoxLink")));
			if (CommonMethods.clickOnWebElement(ORparser.getElement("home.addBoxLink"))) {
				wait.until(ExpectedConditions.visibilityOf(ORparser.getElement("home.addBox")));
				
				CommonMethods.selectFromDropDown(ORparser.getElement("home.BoxToSelect"), BoxToAdd);
				CommonMethods.selectFromDropDown(ORparser.getElement("home.BoxLocation"), Location);
				CommonMethods.clickOnWebElement(ORparser.getElement("home.addBtn"));
			}
		} catch(Exception e) {
			throw new Exception("Exception from method HomePage.addBoxAndVerify: " + e.getMessage());
		} finally{
			CommonMethods.switchFrame("default", "", null);
		}
	}
	
	public boolean verifyAddedBox(String BoxToAdd, String Location) throws Exception {
		
		try {
			
			CommonMethods.switchFrame("name", "mainpanel", null);
			wait.until(ExpectedConditions.elementToBeClickable(ORparser.getElement("home.addBoxLink")));
			//String boxToVerify = getBoxNameToVerify(BoxToAdd);
			String boxProperty = ORparser.getObjectProperty(getBoxNameToVerify(BoxToAdd));
			String Pos = Location.split(" ")[0].trim();
			
			boxProperty = boxProperty.replace("position", "homeColumn" + Pos);
			WebElement element = driver.findElement(By.xpath(boxProperty.split(":")[1]));
			wait.until(ExpectedConditions.visibilityOf(element));
			if (element.isDisplayed())
				return true;
			else
				return false;
		} catch(Exception e) {
			throw e;
		} finally {
			CommonMethods.switchFrame("default", "", null);
		}
	}
	
	
	/**
	 * @throws Exception *****************************************************************************************
	 * 
	 */
	public String getBoxNameToVerify(String OptionSelected) throws Exception {
		
		switch(OptionSelected) {
		
		case "Quick Create Form":
			return "home.quickCreateBoxOnHome";
			
		case "This Week Overview":
			return "home.thisWeek";
			
		case "Call List (non scheduled)":
			return "home.callListBox";
			
		case "Email Campaigns":
			return "home.emailCampaignsBox";
			
		case "CRMPRO News":
			return "home.crmproNews";
			
		case "Tag List":
			return "home.tagListBox";
			
		case "Scheduled Calls":
			return "home.scheduledCalls";
		
		default:
			throw new Exception("Unable to figure out option.");
		}
	}

}
