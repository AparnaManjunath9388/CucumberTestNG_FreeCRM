package com.crm.bdd.stepdefinitions;

import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.GherkinKeyword;
import com.crm.bdd.pages.DealsPage;
import com.crm.bdd.pages.LoginPage;
import com.crm.bdd.reporting.ExtentReportUtil;
import com.crm.bdd.utils.TestStatus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DealsPageStepDef {
	
	private WebDriver driver;
	private DealsPage dealsPage;
	private Hashtable<String, String> TestParams = new Hashtable<String, String>();
	private ExtentReportUtil ReportingUtil;
	private String StepName;
	private String Actual;
	private GherkinKeyword keyword;
	private TestStatus status;
	
	public DealsPageStepDef() throws Exception {
		driver = Hook.getDriver();
		TestParams = Hook.getTestParams();
		dealsPage = new DealsPage(driver);
		ReportingUtil = new ExtentReportUtil();
	}
	
	@Given("^User is on Home page after logging in$")
	public void user_has_already_logged_in_to_application_with_given_username_and_password() throws Throwable {
		StepName = "User has already logged in to application with given Username and password";
		Actual = "";
		status = TestStatus.FAIL;
		keyword = new GherkinKeyword("Given");
		
		try {
			LoginPage loginPage = new LoginPage(driver);
			loginPage.login(TestParams.get("Username"), TestParams.get("Password"));
			Actual = "Logged in to application successfully";
			status = TestStatus.PASS;
		} catch(Exception e) {
			Actual = "Exception occured: " + e.getMessage();
		} finally {
			ReportingUtil.addScenarioStepDetails(driver, keyword, StepName, Actual, status);
		}
	}

	@When("^User hovers mouse on DEALS link and clicks on New Deal link and enters new deal details and clicks on Save$")
	public void user_hovers_mouse_on_DEALS_link_and_clicks_on_New_Deal_link() throws Throwable {
		StepName = "Create new Deal with given deal data";
		status = TestStatus.FAIL;
		Actual = "";
		keyword = new GherkinKeyword("When");
		try {
			dealsPage.createNewDeal(TestParams.get("DealDetails"));
			Actual = "New deal created successfully";
			status = TestStatus.PASS;
		} catch(Exception e) {
			Actual = "Exception occured: " + e.getMessage();
		} finally {
			ReportingUtil.addScenarioStepDetails(driver, keyword, StepName, Actual, status);
		}
		
	}

	@Then("^New Deal ID is generated and displayed on first row$")
	public void new_Deal_ID_is_generated_and_displayed_on_first_row() throws Throwable {
		StepName = "New Deal Id is generated and is equal to initial deal Id assigned";
		status = TestStatus.FAIL;
		Actual = "";
		keyword = new GherkinKeyword("Then");
		try {
			if (dealsPage.verifyDealId()) {
				Actual = "Deal Id is as expected";
				status = TestStatus.PASS;
			} else {
				Actual = "Deal ID is not as expected";
			}
			
		} catch(Exception e) {
			Actual = "Exception occured";
		} finally {
			ReportingUtil.addScenarioStepDetails(driver, keyword, StepName, Actual, status);
		}
		
	}

}
