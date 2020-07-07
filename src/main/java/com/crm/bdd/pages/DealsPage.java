package com.crm.bdd.pages;

import java.util.Hashtable;
import java.util.Map.Entry;

import org.openqa.selenium.WebDriver;

import com.crm.bdd.pagebase.PageBase;

public class DealsPage extends PageBase{

	private String dealId;
	public DealsPage(WebDriver driver) throws Exception {
		super(driver);
	}
	
	public boolean createNewDeal(String dealDetails) throws Exception {
		try {
			
			CommonMethods.switchFrame("name", "mainpanel", null);
			String[] allData = dealDetails.split(",");
			Hashtable<String, String> dataTable = new Hashtable<String, String>();
			for (String data: allData) {
				dataTable.put(data.split("/")[0], data.split("/")[1]);
			}
			
			CommonMethods.performAction("HoverAndClick", ORparser.getBy("home.DealsLink"), ORparser.getBy("home.newDealLink"));
			
			dealId = ORparser.getElement("deal.newDealId").getAttribute("value");
			
			boolean SomethingNotSet = false;
			
			for(Entry<String, String> e: dataTable.entrySet()) {
				String key = e.getKey();
				String value = e.getValue();
				
				String objName = "deal."+key;
				
				if (CommonMethods.compareText(key, "Product", "contains") || CommonMethods.compareText(key, "Type", "contains")) {
					if (!CommonMethods.selectFromDropDown(ORparser.getElement(objName), value)){ SomethingNotSet = true;}	
				} else {
					if (!CommonMethods.setElementText(ORparser.getElement(objName), value)) { SomethingNotSet = true; }
				}				
			}
			
			if (!SomethingNotSet) {
				CommonMethods.clickOnWebElement(ORparser.getElement("deal.newDealSave"));
				return true;
			} else {
				return false;
			}
		} catch(Exception e) {
			throw e;
		} finally {
			CommonMethods.switchFrame("default", "", null);
		}	
	}
	
	public boolean verifyDealId() throws Exception {
		try {
			CommonMethods.switchFrame("name", "mainpanel", null);
	    	String value = ORparser.getElement("deal.FinalDealId").getText();
	    	return value.equals(dealId);
		} catch(Exception e) {
			throw e;
		} finally {
			CommonMethods.switchFrame("default", "", null);
		}
	}
}
