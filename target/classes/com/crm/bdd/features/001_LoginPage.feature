#Author: u286368@wellsfargo.com
#Keywords Summary :
#Feature: Free CRM Application Login page features

Feature: Free CRM Application Login feature - positive scenario

  @SmokeTest @RegressionTest
  Scenario: Login to application positive case
    Given User is already navigated to Free CRM Login Page "https://classic.crmpro.com/" and Page title is "CRMPRO - CRM software for customer relationship management, sales, and support."
    When User enters Username and password and clicks on Login button
    Then I will land up in Home Page which has page title "CRMPRO"


  @RegressionTest
	Scenario Outline: Login to application negative case
	
	Given Title of Login page is "CRMPRO - CRM software for customer relationship management, sales, and support."
	When User enters Username "<Username>" which is unregistered and clicks on Login button
	Then User remains on Login Page and the title remains "CRMPRO - CRM software for customer relationship management, sales, and support."
	
	Examples:
		| Username |
		| aparna12.rao |
		| aparna_m |
		| abc_cd |