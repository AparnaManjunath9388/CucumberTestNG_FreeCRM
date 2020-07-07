#Author: u286368@wellsfargo.com

Feature: Home Page features

  @SmokeTest @RegressionTest
  Scenario: Search in Home Page
    Given User has already logged in to application with given username and password 
    And Logged in UserId is as expected
    When User enters "Google" in Quick search box, selects Search target as "CRM" and clicks on Search
    Then "Google" should appear under CompanyName column

  @RegressionTest
  Scenario: Quick Contact create
    Given User has already logged in to application with given username and password
    When User clicks on QuickCreate link and adds given contact details
    Then Contact search should display the added users details
    
  @SmokeTest @RegressionTest
  Scenario: Add Quick access box to Home Page
  Given User has already logged in to application with given username and password
  When User clicks on AddBox link and adds the given box in the given location
  Then the box should be added in the specified location in Home Page
