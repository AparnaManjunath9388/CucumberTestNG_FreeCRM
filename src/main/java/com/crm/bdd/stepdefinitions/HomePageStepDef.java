package com.crm.bdd.stepdefinitions;

import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.crm.bdd.pages.HomePage;
import com.crm.bdd.pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageStepDef {
	
	private WebDriver driver;
	private LoginPage loginPage;
	private Hashtable<String, String> TestParams = new Hashtable<String, String>();
	private HomePage homePage;
	
	public HomePageStepDef() throws Exception {
		driver = Hook.getDriver();
		TestParams = Hook.getTestParams();
		homePage = new HomePage(driver);
	}
	
	@Given("^User has already logged in to application with given username and password$")
	public void user_has_already_logged_in_to_application_with_given_username_and_password() throws Throwable {
		loginPage = new LoginPage(driver);
		homePage = loginPage.login(TestParams.get("Username"), TestParams.get("Password"));
	}

	@Given("^Logged in UserId is as expected$")
	public void logged_in_UserId_is_as_expected() throws Throwable {
		Assert.assertEquals(homePage.AssertLoggedInUser(TestParams.get("ExpectedUsername")), true);
	}

	@When("^User enters \"([^\"]*)\" in Quick search box, selects Search target as \"([^\"]*)\" and clicks on Search$")
	public void user_enters_in_Quick_search_box_selects_Search_target_as_and_clicks_on_Search(String SearchString, String SearchTarget) throws Throwable {
		homePage.search(SearchString, SearchTarget);
	}

	@Then("^\"([^\"]*)\" should appear under CompanyName column$")
	public void should_appear_under_CompanyName_column(String arg1) throws Throwable {

	}

	@When("^User clicks on QuickCreate link and adds given contact details$")
	public void user_clicks_on_QuickCreate_link_and_adds_given_contact_details() throws Throwable {
		homePage.quickContactCreate(TestParams.get("Company"), TestParams.get("FirstName"), TestParams.get("LastName"));
	}

	@Then("^Contact search should display the added users details$")
	public void contact_search_should_display_the_added_user_s_details() throws Throwable {
		Assert.assertTrue(homePage.searchInContacts(TestParams.get("FirstName"), TestParams.get("LastName")));
	}

	@When("^User clicks on AddBox link and adds the given box in the given location$")
	public void user_clicks_on_AddBox_link_and_adds_the_given_box_in_the_given_location() throws Throwable {
		homePage.addBox(TestParams.get("BoxToAdd"), TestParams.get("Location"));
	}

	@Then("^the box should be added in the specified location in Home Page$")
	public void the_box_should_be_added_in_the_specified_location_in_Home_Page() throws Throwable {
		boolean result = homePage.verifyAddedBox(TestParams.get("BoxToAdd"), TestParams.get("Location"));
		Assert.assertEquals(result, true);
	}

}
