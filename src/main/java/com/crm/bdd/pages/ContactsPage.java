package com.crm.bdd.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.crm.bdd.pagebase.PageBase;

public class ContactsPage extends PageBase{

	public ContactsPage(WebDriver driver) throws Exception {
		super(driver);
	}
	
	public int searchContact(String Name) throws Exception {
		
		int row = -1, PageCounter = -1;
		
		try {
			String FirstLetter = Character.toString(Name.toCharArray()[0]);
			boolean FirstAlphabetSelect = selectFirstAlphabet(FirstLetter);
			
			List<WebElement> PageNumbers = driver.findElements(ORparser.getBy("contacts.pageIndex"));
			int maxPageCounter = PageNumbers.size();
			
			if (FirstAlphabetSelect) {
				
				while (row == -1) {
					 List<WebElement> rows = driver.findElements(ORparser.getBy("contacts.allContactRows"));
					 for (int i=4;i<=rows.size();i++) {
						 String contactColXPath = ORparser.getObjectProperty("contacts.contactColumnInTable").replace("rownum", Integer.toString(i));
						 List<WebElement> contacts = driver.findElements(By.xpath(contactColXPath.split(":")[1]));
						 if (contacts.size() > 0)
							 if (contacts.get(0).getText().equalsIgnoreCase(Name)) {
								 row = i;
								 break;
							 }
					 }
					 if ((row == -1) && maxPageCounter > 0) {
						PageCounter++;
						if (PageCounter < maxPageCounter) {
							PageNumbers.get(PageCounter).click();
							Thread.sleep(500);
							PageNumbers = driver.findElements(ORparser.getBy("contacts.pageIndex"));
							
						} else {
							break;
						}
					 } else {
						 break;
					 }
				}
			}
			return row;
		} catch(Exception e) {
			throw e;
		}
	}
	
	public boolean selectFirstAlphabet(String firstLetter) throws Exception {

		try {
			boolean AlphabetClicked = false;
			List<WebElement> allAlbhabets = driver.findElements(ORparser.getBy("contacts.startLetterElements"));
			
			for (WebElement e : allAlbhabets) {
				if (CommonMethods.compareText(firstLetter, e.getText(), "equalsignorecase")) {
					e.click();
					
					String verification = "-" + firstLetter.toUpperCase() +"- Contacts";
					if (ORparser.getElement("contacts.selectedFirstLetter").getText().contains(verification))
						AlphabetClicked = true;
					break;
				}
			}
			return AlphabetClicked;
		} catch(Exception e) {
			throw new Exception("Exception from method ContactPage.selectFirstAllphabet: " + e.getMessage());
		}
	}
	
	public int addNewContact(String ContactDetails) throws Exception {
		try {
			
			CommonMethods.switchFrame("name", "mainpanel", null);
			String[] ContactDetailsArr = ContactDetails.split(",");
			HashMap<String, String> ContactDetailMap = new HashMap<String, String>();
			
			for (String info : ContactDetailsArr) {
				String[] arrInfo = info.split("/");
				ContactDetailMap.put(arrInfo[0], arrInfo[1]);
			}
			
			CommonMethods.hoverMouseAndClick(ORparser.getElement("home.contactsLink"), ORparser.getBy("contacts.newContactLink"));
			
			wait.until(ExpectedConditions.visibilityOf(ORparser.getElement("contacts.newContactTitle")));
			String FName = "", LName = "";

			boolean notSet = false;
			
			for (Entry<String, String> e: ContactDetailMap.entrySet()) {
				String key = e.getKey();
				String value = e.getValue();
				String objName = "contacts." + key;
				
				//CommonMethods.FigureOutInputTypeAndSetValue(objName, ContactDetailMap.get(key));
				
				if (key.toLowerCase().contains("title") || key.toLowerCase().contains("suffix")) {
					if (!CommonMethods.selectFromDropDown(ORparser.getElement(objName), value))
						notSet = true;
				} else if (key.toLowerCase().contains("receiveemail")) {
					if (!CommonMethods.clickOnWebElement(ORparser.getElement(objName)))
						notSet = true;
				} else if(key.toLowerCase().contains("imagefile")) {
					/*if (!CommonMethods.uploadFile(objName, value))
						notSet = true; */
				} else if(key.toLowerCase().contains("birthday")) {
					if (!CommonMethods.setDate(ORparser.getElement(objName), ORparser.getObjectProperty("contacts.calendarBox").split(":")[1], value))
						notSet = true;
				} else if(key.toLowerCase().contains("companylookup")) {
					if (!CommonMethods.clickOnWebElement(ORparser.getElement(objName)) || !searchInLookUpWindow("Company lookup", value))
						notSet = true;
					//CommonMethods.switchToFrame("mainpanel", "name");
				} else {
					if (key.toLowerCase().contains("firstname"))
						FName = value;
					else if (key.toLowerCase().contains("surname"))
						LName = value;
					
					if (!CommonMethods.setElementText(ORparser.getElement(objName), value))
						notSet = true;
				}
			}
			
			if(!notSet) {
				CommonMethods.clickOnWebElement(ORparser.getElement("contacts.newContactSave"));
				CommonMethods.clickOnWebElement(ORparser.getElement("home.contactsLink"));
				return searchContact(FName + " " + LName);
			} else {
				return -1;
			}	
		} catch(Exception e) {
			throw new Exception("Exception from method ContactPage.addNewContact: " + e.getMessage());
		} finally {
			CommonMethods.switchFrame("default", "", null);
		}
		
	}
	
	public boolean editContact(String ContactNameToEdit, String ContactDetails) throws Exception {
		try {
			
			CommonMethods.switchFrame("name", "mainpanel", null);
		
			String[] ContactDetailsArr = ContactDetails.split(",");
			HashMap<String, String> ContactDetailMap = new HashMap<String, String>();
			
			for (String info : ContactDetailsArr) {
				String[] arrInfo = info.split("/");
				ContactDetailMap.put(arrInfo[0], arrInfo[1]);
			}
			
			boolean notSet = false;
			
			wait.until(ExpectedConditions.visibilityOf(ORparser.getElement("contacts.newContactTitle")));
				
			for (Entry<String, String> e: ContactDetailMap.entrySet()) {
				String key = e.getKey();
				String value = e.getValue();
				String objName = "contacts." + key;
				
				//CommonMethods.FigureOutInputTypeAndSetValue(objName, ContactDetailMap.get(key));
				
				if (key.toLowerCase().contains("title") || key.toLowerCase().contains("suffix")) {
					if (!CommonMethods.selectFromDropDown(ORparser.getElement(objName), value))
						notSet = true;
				} else if (key.toLowerCase().contains("receiveemail")) {
					if (!CommonMethods.clickOnWebElement(ORparser.getElement(objName)))
						notSet = true;
				} else if(key.toLowerCase().contains("imagefile")) {
					/*if (!CommonMethods.uploadFile(objName, value))
						notSet = true; */
				} else if(key.toLowerCase().contains("birthday")) {
					if (!CommonMethods.setDate(ORparser.getElement(objName), ORparser.getObjectProperty("contacts.calendarBox").split(":")[1], value))
						notSet = true;
				} else if(key.toLowerCase().contains("companylookup")) {
					if (!CommonMethods.clickOnWebElement(ORparser.getElement(objName)) || !searchInLookUpWindow("Company lookup", value))
						notSet = true;
				} else {
					if (!CommonMethods.setElementText(ORparser.getElement(objName), value))
						notSet = true;
				}
			}
			
			if (!notSet) {
				CommonMethods.clickOnWebElement(ORparser.getElement("contacts.newContactSave"));
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			throw new Exception("Exception from method ContactPage.rightClickAndEditContact: " + e.getMessage());
		}
		
		finally {
			CommonMethods.switchFrame("default", "", null);
		}
	}
	
	public boolean searchInLookUpWindow(String winTitle, String value) throws Exception {
		
		boolean found = false;
		try {
			String parentHandle = driver.getWindowHandle();
			Set<String> handles = driver.getWindowHandles();
			
			for (String handle : handles) {
				if(!handle.equals(parentHandle)) {
					driver.switchTo().window(handle);
					driver.manage().window().maximize();
					break;
				}
			}
			
			String title = CommonMethods.getElementText(ORparser.getElement("searchWin.title"));
			
			if (CommonMethods.compareText(title.toLowerCase(), winTitle.toLowerCase(), "contains")) {
				
				CommonMethods.setElementText(ORparser.getElement("searchWin.searchBox"), "");
				CommonMethods.setElementText(ORparser.getElement("searchWin.searchBox"), value);
				CommonMethods.clickOnWebElement(ORparser.getElement("searchWin.searchBtn"));
				
				Thread.sleep(1000);
				List<WebElement> allLinks = driver.findElements(By.linkText(value));
				
				if (!allLinks.isEmpty()) {
					allLinks.get(0).click();
					found = true;
				}else {
					driver.close();
				}
			}
			driver.switchTo().window(parentHandle);
			return found;
			
		} catch(Exception e) {
			String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			throw new Exception("Exception from method " + methodName + ": " + e.getMessage());
		}
	}
	
	public int searchForContact(String contactName) throws Exception {
		try {
			CommonMethods.switchFrame("name", "mainpanel", null);
			return searchContact(contactName);
		} catch(Exception e) {
			throw e;
		} finally {
			CommonMethods.switchFrame("default", "", null);
		}
	}
	
	public boolean clickOnEditForContact(String ContactName) throws Exception {
		try {
			
			boolean foundContact = false;
			CommonMethods.switchFrame("name", "mainpanel", null);
			
			CommonMethods.clickOnWebElement(ORparser.getElement("home.contactsLink"));
			wait.until(ExpectedConditions.visibilityOf(ORparser.getElement("contacts.advancedSearchBtn")));
			int ContactRowToEdit = searchContact(ContactName);
			
			if (ContactRowToEdit > 0) {
				String editBtnProp = ORparser.getObjectProperty("contacts.editContact");
				editBtnProp = editBtnProp.replace("rownum", String.valueOf(ContactRowToEdit));
				
				//WebElement contact = findContactRow(ContactNameToEdit, PageNumbers);
				
				WebElement editBtn = driver.findElement(By.xpath(editBtnProp.split(":")[1]));
				CommonMethods.scrollElementIntoView(editBtn);
				wait.until(ExpectedConditions.elementToBeClickable(editBtn));
					
				editBtn.click();
				foundContact = true;
				
				wait.until(ExpectedConditions.visibilityOf(ORparser.getElement("contacts.newContactTitle")));
			} 
			return foundContact;
		} catch(Exception e) {
			throw e;
		} finally {
			CommonMethods.switchFrame("default", "", null);
		}
	}
	
	public boolean verifyEditedChanges(String ContactName, String ContactDetails) throws Exception {
		try {

			boolean notSet = false;
			CommonMethods.switchFrame("name", "mainpanel", null);
			
			CommonMethods.clickOnWebElement(ORparser.getElement("home.contactsLink"));
			if (selectContact(ContactName)) {
				String[] ContactDetailsArr = ContactDetails.split(",");
				HashMap<String, String> ContactDetailMap = new HashMap<String, String>();
				
				for (String info : ContactDetailsArr) {
					String[] arrInfo = info.split("/");
					ContactDetailMap.put(arrInfo[0], arrInfo[1]);
				}
	
				for (Entry<String, String> e: ContactDetailMap.entrySet()) {
					String key = e.getKey();
					String value = e.getValue();
					
					List<WebElement> AllRows = driver.findElements(ORparser.getBy("contacts.AllContactDetails"));
					if (!AllRows.isEmpty()) {
						for (int j=0;j<AllRows.size();j++) {
							List<WebElement> AllData = AllRows.get(j).findElements(By.tagName("td"));
							if(!AllData.isEmpty()) {
								int number = -1;
								for (int i=0; i<AllData.size();i=i+2) {
									List<WebElement> colNames = AllData.get(i).findElements(By.tagName("strong"));
									if (!colNames.isEmpty()) {
										String ColName = colNames.get(0).getText();
										if (ColName.equalsIgnoreCase(key)) {
											number = i;
											break;
										}
									}
								}
								
								if (number > 0) {
									if (!AllData.get(number+1).getText().equalsIgnoreCase(value)) {
										notSet = true;
										break;
									}
								}
								
							}
						}
					}
					
				}
			}
			
			return notSet;
		} catch(Exception e) {
			throw e;
		} finally {
			CommonMethods.switchFrame("default", "", null);
		}
		
	}
	
	public boolean selectContact(String ContactName) throws Exception {
		try {
			int contactToSelect = searchContact(ContactName);
			if (contactToSelect > 0) {
				String contactProp = ORparser.getObjectProperty("contacts.contactColumnInTable").replace("rownum", String.valueOf(contactToSelect));
				
				WebElement ContactLink = driver.findElement(By.xpath(contactProp.split(":")[1]));
				CommonMethods.scrollElementIntoView(ContactLink);
				CommonMethods.clickOnWebElement(ContactLink);
				return true;
			} else {
				return false;
			}	
		} catch(Exception e) {
			throw e;
		}
	}
}
