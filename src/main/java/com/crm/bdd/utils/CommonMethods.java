package com.crm.bdd.utils;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public CommonMethods(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public void switchFrame(String By, String FrameNameOrId, WebElement element) throws Exception {
		try {
			switch (By.toLowerCase()) {
				
			case "name":
				driver.switchTo().frame(FrameNameOrId);
				break;
				
			case "webelement":;
				driver.switchTo().frame(element);
				break;
				
			case "id":
				driver.switchTo().frame(Integer.parseInt(FrameNameOrId));
				break;		
				
			default:
				driver.switchTo().defaultContent();
				break;
			}
		} catch(Exception e) {
			String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			throw new Exception("Exception from method " + methodName + ": " + e.getMessage());
		}
	}
	
	public void performAction(String ActionType, By by1, By by2) throws Exception {
		try {
			
			
			Actions actions = new Actions(driver);
			switch(ActionType) {
			case "HoverAndClick":
				WebElement ElementToHover = driver.findElement(by1);
				wait.until(ExpectedConditions.elementToBeClickable(ElementToHover));
				actions.moveToElement(ElementToHover).perform();
				
				WebElement ElementToClick = driver.findElement(by2);
				wait.until(ExpectedConditions.elementToBeClickable(ElementToClick));
				ElementToClick.click();
				
			}
		} catch(Exception e) {
			String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			throw new Exception("Exception from method " + methodName + ": " + e.getMessage());			
		}
	}
	
	public boolean setElementText(WebElement element, String valueToSet) throws Exception {
		try {
			//WebDriverWait wait = new WebDriverWait(driver, 20);
			//wait.until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(Keys.CONTROL + "a");
			element.sendKeys(Keys.DELETE);
			element.sendKeys(valueToSet);
			Thread.sleep(1000);
			return element.getAttribute("value").equals(valueToSet);
		} catch(Exception e) {
			String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			throw new Exception("Exception from method " + methodName + ": " + e.getMessage());				
		}
	}
	
	public boolean selectFromDropDown(WebElement element, String valueToSelect) throws Exception {
		try {
			Select DropDown = new Select(element);
			DropDown.selectByVisibleText(valueToSelect);
			List<WebElement> selected = DropDown.getAllSelectedOptions();
			return ((selected.size() == 1) && selected.get(0).getText().equals(valueToSelect));
		} catch(Exception e) {
			String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			throw new Exception("Exception from method " + methodName + ": " + e.getMessage());	
		}
	}
	
	public boolean clickOnWebElement(WebElement element) throws Exception {
		
		try {
			//WebDriverWait wait = new WebDriverWait(driver, 20);
			//wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			return true;
		} catch(Exception e) {
			String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			throw new Exception("Exception from method " + methodName + ": " + e.getMessage());				
		}
	}
	
	public boolean elementExists(WebElement element) throws Exception {
		
		boolean isDisplayed = false;
		try {
			isDisplayed = element.isDisplayed();
			return isDisplayed;
		} catch(Exception e) {
			throw new Exception("Exception from method CommonMethods.elementExists: " + e.getMessage());
		}
	}
	
	public boolean compareText(String BaseText, String CompareText, String TypeOfComparison) throws Exception {
		
		switch(TypeOfComparison.toLowerCase()) {
		
		case "equals":
			return BaseText.equals(CompareText);
			
		case "equalsignorecase":
			return BaseText.equalsIgnoreCase(CompareText);
			
		case "contains":
			return BaseText.contains(CompareText);
			
		case "matches":
			return BaseText.matches(CompareText);
			
		case "startswith":
			return BaseText.startsWith(CompareText);
			
		case "endswith":
			return BaseText.endsWith(CompareText);
			
		case "isempty":
			return BaseText.isEmpty();
			
		default:
			throw new Exception("From method CommonMethods.CompareText: Could not recognize the Type of comparison");
			
		}
	}
	
	
	public boolean uploadFile(WebElement elementToClick, String filePath) throws Exception {
		
		boolean uploaded = false;
		try {
			if (clickOnWebElement(elementToClick)) {
				
				//create Robot class
				Robot robot = new Robot();
				robot.setAutoDelay(2000);
				
				//select string which is the file path. Put it in clipboard which simulates Ctrl+C action
				StringSelection selectedString = new StringSelection(filePath);
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selectedString, null);
				
				robot.setAutoDelay(1000);
				
				//simulation of Ctrl+V
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyRelease(KeyEvent.VK_V);
				
				//simulation of clicking on "Upload" button
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				uploaded = true;
			}
			
		} catch (Exception e) {
			throw new Exception("Exception from uploadFile method: " + e.getMessage());
		}
		
		return uploaded;
	}
	
	public boolean setDate(WebElement objToClick, String CalBoxXPath, String Date) throws Exception {
		
		boolean DateSet = false;
		try {
			if (clickOnWebElement(objToClick)) {
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(CalBoxXPath))));
				DateFormat formatter = new SimpleDateFormat("d-MMM-yyyy");
				Date date = formatter.parse(Date);

				String CalTitle = "/table/thead/tr[1]/td[@class='title']";
				String CalBoxProp = CalBoxXPath + CalTitle;
				WebElement title = driver.findElement(By.xpath(CalBoxProp));
				String titleText = title.getText();
				WebElement Btn;
				long year = Integer.parseInt(Date.split("-")[2]);
				
				//move to required Year	
				if (year < Integer.parseInt(Year.now().toString())) {

					String PrevYearBtn = "/table/thead/tr[@class='headrow']/td[1]/div";
					String BtnProp = CalBoxXPath + PrevYearBtn;
					Btn = driver.findElement(By.xpath(BtnProp));
					while (!compareText(titleText, year + "", "contains")) {
						Btn.click();
						Thread.sleep(1000);
						titleText = title.getText();
					}
				}
					
				//move to required month
				@SuppressWarnings("deprecation")
				String month = Month.of(date.getMonth()+1).toString().toLowerCase();
				
				if (date.getMonth()+1 < (getTime(System.currentTimeMillis()).getMonth()+1)) {
					String prevMonthBtn = "/table/thead/tr[@class='headrow']/td[2]/div";
					String LeftBtnProp = CalBoxXPath + prevMonthBtn;
					Btn = driver.findElement(By.xpath(LeftBtnProp));
					while(!compareText(titleText.toLowerCase(), month, "contains")) {
						Btn.click();
						Thread.sleep(1000);
						titleText = title.getText();
					}
				} else {
					String nextMonthBtn = "/table/thead/tr[@class='headrow']/td[4]/div";
					String RightBtnProp = CalBoxXPath + nextMonthBtn;
					Btn = driver.findElement(By.xpath(RightBtnProp));
					while(!compareText(titleText.toLowerCase(), month, "contains")) {
						Btn.click();
						Thread.sleep(1000);
						titleText = title.getText();
					}
				}
				
				//traverse through calendar days and click on required day
				if (compareText(titleText, year + "", "contains") && compareText(titleText.toLowerCase(), month, "contains")) {
				
					String daysRow = "/table/tbody/tr";
					String rowsProp = CalBoxXPath + daysRow;
					List<WebElement> allRows = driver.findElements(By.xpath(rowsProp));
					String Day = String.valueOf(date.getDate());
				
					if (!allRows.isEmpty()) {
						for (WebElement row : allRows) {
							List<WebElement> cells = row.findElements(By.tagName("td"));
							if (!cells.isEmpty()) {
								for (WebElement cell : cells) {
									if (cell.getText().equals(Day) && !cell.getAttribute("class").equals("day wn")) {
										cell.click();
										DateSet = true;
										break;
									}
								}
							}		
							if (DateSet)
								break;
						}
					}
				}
			}
		} catch(Exception e) {
			throw new Exception("Exception from method CommonMethods.setDate: " + e.getMessage());
		}
		
		return DateSet;
	}
	
	public boolean hoverMouseAndClick(WebElement mouseHoverObj, By objToClick) throws Exception {
		
		boolean clicked = false;
		try {
			
			Actions actions = new Actions(driver);
			wait.until(ExpectedConditions.elementToBeClickable(mouseHoverObj));
			actions.moveToElement(mouseHoverObj).perform();
			
			WebElement ElementToClick = driver.findElement(objToClick);
			wait.until(ExpectedConditions.elementToBeClickable(ElementToClick));
			ElementToClick.click();
			clicked = true;
			
		} catch (Exception e) {
			throw new Exception("Exception from method CommonMethods.hoverMouseAndClick: " + e.getMessage());
		}
		
		return clicked;
	}
	
	public void scrollElementIntoView(WebElement element) throws Exception {
		try {
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", element);
		} catch(Exception e) {
			String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			throw new Exception("Exception from method " + methodName + ": " + e.getMessage());
		}
	}
	
	public Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
	
	/****************************************************************
	 * getElementText
	 * @param String ObjectName
	 * @return String which is the text value of the object
	 */
	public String getElementText(WebElement ObjName) throws Exception {
		
		try {
			return ObjName.getText();
		} catch(Exception e) {
			throw new Exception("Exception from method CommonMethods.getElementText: " + e.toString());
		}
		
	}
}
