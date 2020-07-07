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
  "duration": 39936938700,
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
  "duration": 997959700,
  "status": "passed"
});
formatter.match({
  "location": "LoginPageStepDef.user_enters_Username_and_password_and_clicks_on_Login_button()"
});
formatter.result({
  "duration": 9778678300,
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
  "duration": 114943300,
  "status": "passed"
});
formatter.after({
  "duration": 7943144800,
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
  "duration": 14196487700,
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
  "duration": 12415800,
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
  "duration": 6996364800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "CRMPRO - CRM software for customer relationship management, sales, and support.",
      "offset": 50
    }
  ],
  "location": "LoginPageStepDef.user_remains_on_Login_page_is(String)"
});
formatter.result({
  "duration": 24674700,
  "status": "passed"
});
formatter.after({
  "duration": 6131986700,
  "status": "passed"
});
formatter.before({
  "duration": 40240598400,
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
  "duration": 5591300,
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
  "duration": 8065003800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "CRMPRO - CRM software for customer relationship management, sales, and support.",
      "offset": 50
    }
  ],
  "location": "LoginPageStepDef.user_remains_on_Login_page_is(String)"
});
formatter.result({
  "duration": 20689800,
  "status": "passed"
});
formatter.after({
  "duration": 4588197000,
  "status": "passed"
});
formatter.before({
  "duration": 13300794200,
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
  "duration": 11272300,
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
  "duration": 6513902600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "CRMPRO - CRM software for customer relationship management, sales, and support.",
      "offset": 50
    }
  ],
  "location": "LoginPageStepDef.user_remains_on_Login_page_is(String)"
});
formatter.result({
  "duration": 23904600,
  "status": "passed"
});
formatter.after({
  "duration": 5426531000,
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
  "duration": 15818664700,
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
  "duration": 8716755300,
  "status": "passed"
});
formatter.match({
  "location": "HomePageStepDef.logged_in_UserId_is_as_expected()"
});
formatter.result({
  "duration": 110860900,
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
  "duration": 2444663200,
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
  "duration": 88300,
  "status": "passed"
});
formatter.after({
  "duration": 5561335600,
  "status": "passed"
});
formatter.before({
  "duration": 18861985900,
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
  "duration": 9026342600,
  "status": "passed"
});
formatter.match({
  "location": "HomePageStepDef.user_clicks_on_QuickCreate_link_and_adds_given_contact_details()"
});
formatter.result({
  "duration": 7694183700,
  "error_message": "java.lang.Exception: Exception from method clickOnWebElement: Element \u003cinput class\u003d\"button\" type\u003d\"button\"\u003e is not clickable at point (732,177) because another element \u003cdiv id\u003d\"ibox_content\"\u003e obscures it\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027LAPTOP-JOPOHLMU\u0027, ip: \u0027192.168.43.175\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_221\u0027\nDriver info: org.openqa.selenium.firefox.FirefoxDriver\nCapabilities {acceptInsecureCerts: true, browserName: firefox, browserVersion: 77.0.1, javascriptEnabled: true, moz:accessibilityChecks: false, moz:buildID: 20200602222727, moz:geckodriverVersion: 0.24.0, moz:headless: false, moz:processID: 4716, moz:profile: C:\\Users\\aparn\\AppData\\Loca..., moz:shutdownTimeout: 60000, moz:useNonSpecCompliantPointerOrigin: false, moz:webdriverClick: true, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, platformVersion: 10.0, rotatable: false, setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}\nSession ID: 25e82369-e967-4552-9b8a-46e03164218c\r\n\tat com.crm.bdd.utils.CommonMethods.clickOnWebElement(CommonMethods.java:119)\r\n\tat com.crm.bdd.pages.HomePage.quickContactCreate(HomePage.java:95)\r\n\tat com.crm.bdd.stepdefinitions.HomePageStepDef.user_clicks_on_QuickCreate_link_and_adds_given_contact_details(HomePageStepDef.java:50)\r\n\tat ✽.When User clicks on QuickCreate link and adds given contact details(002_HomePage.feature:15)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "HomePageStepDef.contact_search_should_display_the_added_user_s_details()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 5537486500,
  "status": "passed"
});
formatter.before({
  "duration": 78104372100,
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
  "duration": 10021885200,
  "status": "passed"
});
formatter.match({
  "location": "HomePageStepDef.user_clicks_on_AddBox_link_and_adds_the_given_box_in_the_given_location()"
});
formatter.result({
  "duration": 41596434600,
  "error_message": "java.lang.Exception: Exception from method HomePage.addBoxAndVerify: Exception from method selectFromDropDown: Cannot locate element with text: Quick Create Form\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027LAPTOP-JOPOHLMU\u0027, ip: \u0027192.168.43.175\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_221\u0027\nDriver info: driver.version: unknown\r\n\tat com.crm.bdd.pages.HomePage.addBox(HomePage.java:167)\r\n\tat com.crm.bdd.stepdefinitions.HomePageStepDef.user_clicks_on_AddBox_link_and_adds_the_given_box_in_the_given_location(HomePageStepDef.java:60)\r\n\tat ✽.When User clicks on AddBox link and adds the given box in the given location(002_HomePage.feature:21)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "HomePageStepDef.the_box_should_be_added_in_the_specified_location_in_Home_Page()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 2199488800,
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
  "duration": 13881067400,
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
  "duration": 8354493800,
  "status": "passed"
});
formatter.match({
  "location": "ContactsPageStepDef.user_clicks_on_CONTACTS_New_Contact_enters_all_the_given_details_and_clicks_on_Save()"
});
formatter.result({
  "duration": 59120373100,
  "status": "passed"
});
formatter.match({
  "location": "ContactsPageStepDef.new_contact_should_get_saved_successfully_and_come_up_when_searched_for_the_same()"
});
formatter.result({
  "duration": 1469644300,
  "status": "passed"
});
formatter.after({
  "duration": 2130297400,
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
  "duration": 11324637500,
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
  "duration": 16843463800,
  "status": "passed"
});
formatter.match({
  "location": "DealsPageStepDef.user_hovers_mouse_on_DEALS_link_and_clicks_on_New_Deal_link()"
});
formatter.result({
  "duration": 7856824900,
  "status": "passed"
});
formatter.match({
  "location": "DealsPageStepDef.new_Deal_ID_is_generated_and_displayed_on_first_row()"
});
formatter.result({
  "duration": 443074100,
  "status": "passed"
});
formatter.after({
  "duration": 5423283500,
  "status": "passed"
});
});