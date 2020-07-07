#Author: u286368@wellsfargo.com

Feature: Contacts Page features

	@SmokeTest @RegressionTest
  Scenario: Add new Contact
    Given User is on Home Page
    When User clicks on CONTACTS -> New Contact, enters all the given details and clicks on Save
    Then new contact should get saved successfully and come up when searched for the same

  @RegressionTest @Ignore
  Scenario: Edit an existing contact
    Given User is on Home Page
    When User searches for given existing contact and clicks on Edit button
    When User enters all the required details and clicks on Save
    Then all the new changes should be saved successfully
