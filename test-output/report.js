$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("001_LoginPage.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: u286368@wellsfargo.com"
    },
    {
      "line": 2,
      "value": "#Keywords Summary :"
    },
    {
      "line": 3,
      "value": "#Feature: Free CRM Application Login page features"
    }
  ],
  "line": 5,
  "name": "Free CRM Application Login feature - positive scenario",
  "description": "",
  "id": "free-crm-application-login-feature---positive-scenario",
  "keyword": "Feature"
});
formatter.before({
  "duration": 14072215500,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "Login to application positive case",
  "description": "",
  "id": "free-crm-application-login-feature---positive-scenario;login-to-application-positive-case",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 7,
      "name": "@SmokeTest"
    },
    {
      "line": 7,
      "name": "@RegressionTest"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "User is already navigated to Free CRM Login Page \"https://classic.crmpro.com/\" and Page title is \"CRMPRO - CRM software for customer relationship management, sales, and support.\"",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "User enters Username and password and clicks on Login button",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I will land up in Home Page which has page title \"CRMPRO\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "https://classic.crmpro.com/",
      "offset": 50
    },
    {
      "val": "CRMPRO - CRM software for customer relationship management, sales, and support.",
      "offset": 98
    }
  ],
  "location": "LoginPageStepDef.user_is_already_navigated_to_Free_CRM_Login_Page_and_Page_title_is(String,String)"
});
formatter.result({
  "duration": 386273700,
  "status": "passed"
});
formatter.match({
  "location": "LoginPageStepDef.user_enters_Username_and_password_and_clicks_on_Login_button()"
});
formatter.result({
  "duration": 8350880100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "CRMPRO",
      "offset": 50
    }
  ],
  "location": "LoginPageStepDef.i_will_land_up_in_Home_Page_which_has_page_title(String)"
});
formatter.result({
  "duration": 53332000,
  "status": "passed"
});
formatter.after({
  "duration": 6050071300,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 15,
  "name": "Login to application negative case",
  "description": "",
  "id": "free-crm-application-login-feature---positive-scenario;login-to-application-negative-case",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 14,
      "name": "@RegressionTest"
    }
  ]
});
formatter.step({
  "line": 17,
  "name": "Title of Login page is \"CRMPRO - CRM software for customer relationship management, sales, and support.\"",
  "keyword": "Given "
});
formatter.step({
  "line": 18,
  "name": "User enters Username \"\u003cUsername\u003e\" which is unregistered and clicks on Login button",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "User remains on Login Page and the title remains \"CRMPRO - CRM software for customer relationship management, sales, and support.\"",
  "keyword": "Then "
});
formatter.examples({
  "line": 21,
  "name": "",
  "description": "",
  "id": "free-crm-application-login-feature---positive-scenario;login-to-application-negative-case;",
  "rows": [
    {
      "cells": [
        "Username"
      ],
      "line": 22,
      "id": "free-crm-application-login-feature---positive-scenario;login-to-application-negative-case;;1"
    },
    {
      "cells": [
        "aparna12.rao"
      ],
      "line": 23,
      "id": "free-crm-application-login-feature---positive-scenario;login-to-application-negative-case;;2"
    },
    {
      "cells": [
        "aparna_m"
      ],
      "line": 24,
      "id": "free-crm-application-login-feature---positive-scenario;login-to-application-negative-case;;3"
    },
    {
      "cells": [
        "abc_cd"
      ],
      "line": 25,
      "id": "free-crm-application-login-feature---positive-scenario;login-to-application-negative-case;;4"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 10876331100,
  "status": "passed"
});
formatter.scenario({
  "line": 23,
  "name": "Login to application negative case",
  "description": "",
  "id": "free-crm-application-login-feature---positive-scenario;login-to-application-negative-case;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 14,
      "name": "@RegressionTest"
    }
  ]
});
formatter.step({
  "line": 17,
  "name": "Title of Login page is \"CRMPRO - CRM software for customer relationship management, sales, and support.\"",
  "keyword": "Given "
});
formatter.step({
  "line": 18,
  "name": "User enters Username \"aparna12.rao\" which is unregistered and clicks on Login button",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "User remains on Login Page and the title remains \"CRMPRO - CRM software for customer relationship management, sales, and support.\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "CRMPRO - CRM software for customer relationship management, sales, and support.",
      "offset": 24
    }
  ],
  "location": "LoginPageStepDef.title_of_Login_page_is(String)"
});
formatter.result({
  "duration": 7852500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "aparna12.rao",
      "offset": 22
    }
  ],
  "location": "LoginPageStepDef.user_enters_Username_which_is_unregistered(String)"
});
formatter.result({
  "duration": 7482610100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "CRMPRO - CRM software for customer relationship management, sales, and support.",
      "offset": 50
    }
  ],
  "location": "LoginPageStepDef.title_of_Login_page_is(String)"
});
formatter.result({
  "duration": 10435000,
  "status": "passed"
});
formatter.after({
  "duration": 4718604500,
  "status": "passed"
});
formatter.before({
  "duration": 10015807000,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "Login to application negative case",
  "description": "",
  "id": "free-crm-application-login-feature---positive-scenario;login-to-application-negative-case;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 14,
      "name": "@RegressionTest"
    }
  ]
});
formatter.step({
  "line": 17,
  "name": "Title of Login page is \"CRMPRO - CRM software for customer relationship management, sales, and support.\"",
  "keyword": "Given "
});
formatter.step({
  "line": 18,
  "name": "User enters Username \"aparna_m\" which is unregistered and clicks on Login button",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "User remains on Login Page and the title remains \"CRMPRO - CRM software for customer relationship management, sales, and support.\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "CRMPRO - CRM software for customer relationship management, sales, and support.",
      "offset": 24
    }
  ],
  "location": "LoginPageStepDef.title_of_Login_page_is(String)"
});
formatter.result({
  "duration": 6413200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "aparna_m",
      "offset": 22
    }
  ],
  "location": "LoginPageStepDef.user_enters_Username_which_is_unregistered(String)"
});
formatter.result({
  "duration": 6983420400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "CRMPRO - CRM software for customer relationship management, sales, and support.",
      "offset": 50
    }
  ],
  "location": "LoginPageStepDef.title_of_Login_page_is(String)"
});
formatter.result({
  "duration": 21016600,
  "status": "passed"
});
formatter.after({
  "duration": 5447267800,
  "status": "passed"
});
formatter.before({
  "duration": 10494948600,
  "status": "passed"
});
formatter.scenario({
  "line": 25,
  "name": "Login to application negative case",
  "description": "",
  "id": "free-crm-application-login-feature---positive-scenario;login-to-application-negative-case;;4",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 14,
      "name": "@RegressionTest"
    }
  ]
});
formatter.step({
  "line": 17,
  "name": "Title of Login page is \"CRMPRO - CRM software for customer relationship management, sales, and support.\"",
  "keyword": "Given "
});
formatter.step({
  "line": 18,
  "name": "User enters Username \"abc_cd\" which is unregistered and clicks on Login button",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "User remains on Login Page and the title remains \"CRMPRO - CRM software for customer relationship management, sales, and support.\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "CRMPRO - CRM software for customer relationship management, sales, and support.",
      "offset": 24
    }
  ],
  "location": "LoginPageStepDef.title_of_Login_page_is(String)"
});
formatter.result({
  "duration": 12790500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "abc_cd",
      "offset": 22
    }
  ],
  "location": "LoginPageStepDef.user_enters_Username_which_is_unregistered(String)"
});
formatter.result({
  "duration": 6778821400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "CRMPRO - CRM software for customer relationship management, sales, and support.",
      "offset": 50
    }
  ],
  "location": "LoginPageStepDef.title_of_Login_page_is(String)"
});
formatter.result({
  "duration": 16301400,
  "status": "passed"
});
formatter.after({
  "duration": 5313206700,
  "status": "passed"
});
formatter.uri("002_HomePage.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: u286368@wellsfargo.com"
    }
  ],
  "line": 3,
  "name": "Home Page features",
  "description": "",
  "id": "home-page-features",
  "keyword": "Feature"
});
formatter.before({
  "duration": 10070670600,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "Search in Home Page",
  "description": "",
  "id": "home-page-features;search-in-home-page",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@SmokeTest"
    },
    {
      "line": 5,
      "name": "@RegressionTest"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "User has already logged in to application with given username and password",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Logged in UserId is as expected",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "User enters \"Google\" in Quick search box, selects Search target as \"CRM\" and clicks on Search",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "\"Google\" should appear under CompanyName column",
  "keyword": "Then "
});
formatter.match({
  "location": "HomePageStepDef.user_has_already_logged_in_to_application_with_given_username_and_password()"
});
formatter.result({
  "duration": 8016420900,
  "status": "passed"
});
formatter.match({
  "location": "HomePageStepDef.logged_in_UserId_is_as_expected()"
});
formatter.result({
  "duration": 88487700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Google",
      "offset": 13
    },
    {
      "val": "CRM",
      "offset": 68
    }
  ],
  "location": "HomePageStepDef.user_enters_in_Quick_search_box_selects_Search_target_as_and_clicks_on_Search(String,String)"
});
formatter.result({
  "duration": 2837707600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Google",
      "offset": 1
    }
  ],
  "location": "HomePageStepDef.should_appear_under_CompanyName_column(String)"
});
formatter.result({
  "duration": 219700,
  "status": "passed"
});
formatter.after({
  "duration": 5360078200,
  "status": "passed"
});
formatter.before({
  "duration": 11128109900,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Quick Contact create",
  "description": "",
  "id": "home-page-features;quick-contact-create",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 12,
      "name": "@RegressionTest"
    }
  ]
});
formatter.step({
  "line": 14,
  "name": "User has already logged in to application with given username and password",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "User clicks on QuickCreate link and adds given contact details",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "Contact search should display the added users details",
  "keyword": "Then "
});
formatter.match({
  "location": "HomePageStepDef.user_has_already_logged_in_to_application_with_given_username_and_password()"
});
formatter.result({
  "duration": 9117825400,
  "status": "passed"
});
formatter.match({
  "location": "HomePageStepDef.user_clicks_on_QuickCreate_link_and_adds_given_contact_details()"
});
formatter.result({
  "duration": 9335882200,
  "status": "passed"
});
formatter.match({
  "location": "HomePageStepDef.contact_search_should_display_the_added_user_s_details()"
});
formatter.result({
  "duration": 49669651100,
  "status": "passed"
});
formatter.after({
  "duration": 1751334500,
  "status": "passed"
});
formatter.before({
  "duration": 12644517800,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "Add Quick access box to Home Page",
  "description": "",
  "id": "home-page-features;add-quick-access-box-to-home-page",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 18,
      "name": "@SmokeTest"
    },
    {
      "line": 18,
      "name": "@RegressionTest"
    }
  ]
});
formatter.step({
  "line": 20,
  "name": "User has already logged in to application with given username and password",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "User clicks on AddBox link and adds the given box in the given location",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "the box should be added in the specified location in Home Page",
  "keyword": "Then "
});
formatter.match({
  "location": "HomePageStepDef.user_has_already_logged_in_to_application_with_given_username_and_password()"
});
formatter.result({
  "duration": 8055813300,
  "status": "passed"
});
formatter.match({
  "location": "HomePageStepDef.user_clicks_on_AddBox_link_and_adds_the_given_box_in_the_given_location()"
});
formatter.result({
  "duration": 2472305500,
  "status": "passed"
});
formatter.match({
  "location": "HomePageStepDef.the_box_should_be_added_in_the_specified_location_in_Home_Page()"
});
formatter.result({
  "duration": 2476708000,
  "status": "passed"
});
formatter.after({
  "duration": 6077746300,
  "status": "passed"
});
formatter.uri("003_ContactsPage.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: u286368@wellsfargo.com"
    }
  ],
  "line": 3,
  "name": "Contacts Page features",
  "description": "",
  "id": "contacts-page-features",
  "keyword": "Feature"
});
formatter.before({
  "duration": 10650529800,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "Add new Contact",
  "description": "",
  "id": "contacts-page-features;add-new-contact",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@SmokeTest"
    },
    {
      "line": 5,
      "name": "@RegressionTest"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "User is on Home Page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "User clicks on CONTACTS -\u003e New Contact, enters all the given details and clicks on Save",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "new contact should get saved successfully and come up when searched for the same",
  "keyword": "Then "
});
formatter.match({
  "location": "ContactsPageStepDef.user_has_already_logged_in_to_application_with_given_username_and_password()"
});
formatter.result({
  "duration": 7851465900,
  "status": "passed"
});
formatter.match({
  "location": "ContactsPageStepDef.user_clicks_on_CONTACTS_New_Contact_enters_all_the_given_details_and_clicks_on_Save()"
});
formatter.result({
  "duration": 59360075700,
  "status": "passed"
});
formatter.match({
  "location": "ContactsPageStepDef.new_contact_should_get_saved_successfully_and_come_up_when_searched_for_the_same()"
});
formatter.result({
  "duration": 1421255200,
  "status": "passed"
});
formatter.after({
  "duration": 2259543000,
  "status": "passed"
});
formatter.before({
  "duration": 10551532600,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Edit an existing contact",
  "description": "",
  "id": "contacts-page-features;edit-an-existing-contact",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 11,
      "name": "@RegressionTest"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "User is on Home Page",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "User searches for given existing contact and clicks on Edit button",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "User enters all the required details and clicks on Save",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "all the new changes should be saved successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "ContactsPageStepDef.user_has_already_logged_in_to_application_with_given_username_and_password()"
});
formatter.result({
  "duration": 7998061400,
  "status": "passed"
});
formatter.match({
  "location": "ContactsPageStepDef.searches_for_given_existing_contact()"
});
formatter.result({
  "duration": 3976620100,
  "status": "passed"
});
formatter.match({
  "location": "ContactsPageStepDef.user_clicks_on_Edit_button_in_the_contact_row_and_enters_all_the_required_details_and_clicks_on_Save()"
});
formatter.result({
  "duration": 11241972500,
  "status": "passed"
});
formatter.match({
  "location": "ContactsPageStepDef.all_the_new_changes_should_be_saved_successfully()"
});
formatter.result({
  "duration": 265384810800,
  "error_message": "java.lang.AssertionError: expected [true] but found [false]\r\n\tat org.testng.Assert.fail(Assert.java:94)\r\n\tat org.testng.Assert.failNotEquals(Assert.java:513)\r\n\tat org.testng.Assert.assertTrue(Assert.java:42)\r\n\tat org.testng.Assert.assertTrue(Assert.java:52)\r\n\tat com.crm.bdd.stepdefinitions.ContactsPageStepDef.all_the_new_changes_should_be_saved_successfully(ContactsPageStepDef.java:58)\r\n\tat ✽.Then all the new changes should be saved successfully(003_ContactsPage.feature:16)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 1877522500,
  "status": "passed"
});
formatter.uri("004_DealsPage.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: u286368@wellsfargo.com"
    }
  ],
  "line": 3,
  "name": "Free CRM Deal creation",
  "description": "",
  "id": "free-crm-deal-creation",
  "keyword": "Feature"
});
formatter.before({
  "duration": 11238207200,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "Simple new deal creation",
  "description": "",
  "id": "free-crm-deal-creation;simple-new-deal-creation",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@RegressionTest"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "User is on Home page after logging in",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "User hovers mouse on DEALS link and clicks on New Deal link and enters new deal details and clicks on Save",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "New Deal ID is generated and displayed on first row",
  "keyword": "Then "
});
formatter.match({
  "location": "DealsPageStepDef.user_has_already_logged_in_to_application_with_given_username_and_password()"
});
formatter.result({
  "duration": 23469199300,
  "status": "passed"
});
formatter.match({
  "location": "DealsPageStepDef.user_hovers_mouse_on_DEALS_link_and_clicks_on_New_Deal_link()"
});
formatter.result({
  "duration": 66907020800,
  "status": "passed"
});
formatter.match({
  "location": "DealsPageStepDef.new_Deal_ID_is_generated_and_displayed_on_first_row()"
});
formatter.result({
  "duration": 47971160200,
  "error_message": "java.lang.AssertionError: expected [true] but found [false]\r\n\tat org.testng.Assert.fail(Assert.java:94)\r\n\tat org.testng.Assert.failNotEquals(Assert.java:513)\r\n\tat org.testng.Assert.assertTrue(Assert.java:42)\r\n\tat org.testng.Assert.assertTrue(Assert.java:52)\r\n\tat com.crm.bdd.stepdefinitions.DealsPageStepDef.new_Deal_ID_is_generated_and_displayed_on_first_row(DealsPageStepDef.java:40)\r\n\tat ✽.Then New Deal ID is generated and displayed on first row(004_DealsPage.feature:10)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 1576543300,
  "status": "passed"
});
});