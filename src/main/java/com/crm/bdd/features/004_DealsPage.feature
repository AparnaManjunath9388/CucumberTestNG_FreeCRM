#Author: u286368@wellsfargo.com

Feature: Free CRM Deal creation

  @RegressionTest
  Scenario: Simple new deal creation

    Given User is on Home page after logging in
    When User hovers mouse on DEALS link and clicks on New Deal link and enters new deal details and clicks on Save
    Then New Deal ID is generated and displayed on first row
