package com.crm.bdd.stepdefinitions;

import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.crm.bdd.pages.ContactsPage;
import com.crm.bdd.pages.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ContactsPageStepDef {

	private WebDriver driver;
	private Hashtable<String, String> TestParams = new Hashtable<String, String>();
	private ContactsPage contactsPage;
	
	public ContactsPageStepDef() throws Exception {
		driver = Hook.getDriver();
		TestParams = Hook.getTestParams();
		contactsPage = new ContactsPage(driver);
	}
	
	@Given("^User is on Home Page$")
	public void user_has_already_logged_in_to_application_with_given_username_and_password() throws Throwable {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(TestParams.get("Username"), TestParams.get("Password"));
	}
	
	@When("^User clicks on CONTACTS -> New Contact, enters all the given details and clicks on Save$")
	public void user_clicks_on_CONTACTS_New_Contact_enters_all_the_given_details_and_clicks_on_Save() throws Throwable {
		contactsPage.addNewContact(TestParams.get("NewContactDetails"));
	}

	@Then("^new contact should get saved successfully and come up when searched for the same$")
	public void new_contact_should_get_saved_successfully_and_come_up_when_searched_for_the_same() throws Throwable {
		boolean result = false;
		if (contactsPage.searchForContact(TestParams.get("ContactNameToSearch")) > 0)
			result = true;
		Assert.assertEquals(result, true);
	}

	@When("^User searches for given existing contact and clicks on Edit button$")
	public void searches_for_given_existing_contact() throws Throwable {
		Assert.assertTrue(contactsPage.clickOnEditForContact(TestParams.get("ContactNameToEdit")));
	}

	@When("^User enters all the required details and clicks on Save$")
	public void user_clicks_on_Edit_button_in_the_contact_row_and_enters_all_the_required_details_and_clicks_on_Save() throws Throwable {
		Assert.assertTrue(contactsPage.editContact(TestParams.get("ContactNameToEdit"), TestParams.get("ContactDetailsToEdit")));
	}

	@Then("^all the new changes should be saved successfully$")
	public void all_the_new_changes_should_be_saved_successfully() throws Throwable {
		Assert.assertTrue(contactsPage.verifyEditedChanges(TestParams.get("ContactNameToVerify"), TestParams.get("EditedChanges")));
	}

}
