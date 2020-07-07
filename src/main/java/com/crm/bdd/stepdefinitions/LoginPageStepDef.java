package com.crm.bdd.stepdefinitions;

import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.GherkinKeyword;
import com.crm.bdd.pages.HomePage;
import com.crm.bdd.pages.LoginPage;
import com.crm.bdd.reporting.ExtentReportUtil;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.crm.bdd.utils.TestStatus;
public class LoginPageStepDef {
	
	private WebDriver driver;
	private Hashtable<String, String> TestParams = new Hashtable<String, String>();
	private ExtentReportUtil ReportingUtil;
	
	private LoginPage loginPage;
	private HomePage homePage;
	private String StepName;
	private String Actual;
	private TestStatus status;
	private GherkinKeyword keyword;
	
	public LoginPageStepDef() throws Exception {
		driver = Hook.getDriver();
		TestParams = Hook.getTestParams();
		ReportingUtil = new ExtentReportUtil();
		loginPage = new LoginPage(driver);
	}
	
	@Given("^User is already navigated to Free CRM Login Page \"([^\"]*)\" and Page title is \"([^\"]*)\"$")
	public void user_is_already_navigated_to_Free_CRM_Login_Page_and_Page_title_is(String expectedUrl, String expectedPageTitle) throws Throwable {
		
		StepName = "Assert Login Page URL and Page title";
		keyword = new GherkinKeyword("Given");
		try {
			String url = loginPage.getCurrentURL();
			boolean URLAssert = url.equals(expectedUrl);
		    
			String Pagetitle = loginPage.getPageTitle();
			boolean TitleAssert = Pagetitle.equals(expectedPageTitle);
			
			if (TitleAssert && URLAssert) {
				Actual = "Both URL and Page title are as expected";
				status = TestStatus.PASS;
			} else {
				Actual = "Either URL or Page Title are not as expected";
			}
			
		} catch(Exception e) {
			Actual = "Exception encountered: " + e.getMessage();
		} finally {
			ReportingUtil.addScenarioStepDetails(driver, keyword, StepName, Actual, status);
		}
	}

	@When("^User enters Username and password and clicks on Login button$")
	public void user_enters_Username_and_password_and_clicks_on_Login_button() throws Throwable {
		StepName = "User enters Username and password and clicks on Login button";
		keyword = new GherkinKeyword("When");
		Actual = "";
		status = TestStatus.FAIL;
		try {
		    homePage = loginPage.login(TestParams.get("Username"), TestParams.get("Password"));
		    Actual = "Logged in with given username and password";
		    status = TestStatus.PASS;
		} catch(Exception e) {
			Actual = "Exception encountered: " + e.getMessage();
		} finally {
			ReportingUtil.addScenarioStepDetails(driver, keyword, StepName, Actual, status);
		}

	}

	@Then("^I will land up in Home Page which has page title \"([^\"]*)\"$")
	public void i_will_land_up_in_Home_Page_which_has_page_title(String ExpectedPageTitle) throws Throwable {
		StepName = "Home Page title assertion";
		keyword = new GherkinKeyword("Then");
		Actual = "";
		status = TestStatus.FAIL;
		try {
			String title = homePage.getPageTitle();
			if (title.equals(ExpectedPageTitle)) {
				Actual = "Home page Title as expected";
				status = TestStatus.PASS;
			} else {
				Actual = "Home Page title not as expected";
			}
		} catch(Exception e) {
			Actual = "Exception occured: " + e.getMessage();
		} finally {
			ReportingUtil.addScenarioStepDetails(driver, keyword, StepName, Actual, status);
		}
	}

	@Given("^Title of Login page is \"([^\"]*)\"$")
	public void title_of_Login_page_is(String ExpectedTitle) throws Throwable {
		StepName = "Title of the Login page is: " + ExpectedTitle;
		keyword = new GherkinKeyword("Given");
		Actual = "";
		status = TestStatus.FAIL;
		try {
			String title = loginPage.getPageTitle();
			if (title.equals(ExpectedTitle)) {
				Actual = "Page title as expected";
				status = TestStatus.PASS;
			} else {
				Actual = "Page title not as expected";
			}
				
		} catch(Exception e) {
			Actual = "Exception occured: " + e.getMessage();
		} finally {
			ReportingUtil.addScenarioStepDetails(driver, keyword, StepName, Actual, status);
		}
		
	}	
	
	@Then("^User remains on Login Page and the title remains \"([^\"]*)\"$")
	public void user_remains_on_Login_page_is(String ExpectedTitle) throws Throwable {
		StepName = "User remains on Login page with Page title: " + ExpectedTitle;
		Actual = "";
		status = TestStatus.FAIL;
		keyword = new GherkinKeyword("Then");
		try {
			String title = loginPage.getPageTitle();
			if (title.equals(ExpectedTitle)) {
				Actual = "User is o Login Page as expected";
				status = TestStatus.PASS;
			} else {
				Actual = "Login Page title is not as expected";
			}
		} catch(Exception e) {
			Actual = "Exception occured: " + e.getMessage();
		} finally {
			ReportingUtil.addScenarioStepDetails(driver, keyword, StepName, Actual, status);
		}
		
	}

	@When("^User enters Username \"([^\"]*)\" which is unregistered and clicks on Login button$")
	public void user_enters_Username_which_is_unregistered(String Username) throws Throwable {
		StepName = "User enters unregistered Username: " + Username;
		Actual = "";
		status = TestStatus.FAIL;
		keyword = new GherkinKeyword("When");
		try {
			homePage = loginPage.login(Username, "");
			Actual = "Entered Usename successfully";
			status = TestStatus.PASS;
		} catch(Exception e) {
			Actual = "Exception occured: " + e.getMessage();
		} finally {
			ReportingUtil.addScenarioStepDetails(driver, keyword, StepName, Actual, status);
		}
		
	}
	
	@BeforeMethod
	public void beforeEachMethod() {
		StepName = "";
		Actual = "";
		keyword = null;
		status = TestStatus.FAIL;
	}
	
	@AfterMethod
	public void afterEachMethod() throws Exception {
		ReportingUtil.addScenarioStepDetails(driver, keyword, StepName, Actual, status);
	}
}
