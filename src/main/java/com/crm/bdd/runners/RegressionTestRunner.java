package com.crm.bdd.runners;

	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Listeners;
	import org.testng.annotations.Test;
	
	import com.crm.bdd.reporting.ExtentReportUtil;
	
	//import io.cucumber.gherkin.*;
	
	import io.cucumber.testng.AbstractTestNGCucumberTests;
	import io.cucumber.testng.CucumberFeatureWrapper;
	import io.cucumber.testng.CucumberOptions;
	import io.cucumber.testng.TestNGCucumberRunner;
	import io.cucumber.testng.PickleEventWrapper;
	//import gherkin.events.PickleEvent;
	
	import io.cucumber.gherkin.pickles.PickleCompiler;
	
	
	
	
	@CucumberOptions(
			features="C:\\Users\\aparn\\eclipse-workspace\\CucumberTestNG_FreeCRM\\src\\main\\java\\com\\crm\\bdd\\features"
			,glue= {"com.crm.bdd.stepdefinitions"}
			,monochrome = true
			,dryRun = false
			,strict = true
			,tags = {"@RegressionTest", "~@Ignore"}												//{"@SmokeTest", "@RegressionTest"} - execute both SmokeTest AND RegressionTest tags
			,plugin = "json:target/cucumber-reports/CucumberTestReport.json"		//{"@SmokeTest, @RegressionTest"} - execute all of these - SmokeTest, RegressionTest - tags
																					//{"~@SmokeTest", "@RegressionTest"} - IGNORE SmokeTest tag
	)
	
	@Listeners(com.crm.bdd.reporting.TestListener.class)
	public class RegressionTestRunner {
		
		private TestNGCucumberRunner testNGCucumberRunner;
		private ExtentReportUtil ReportingUtil;
		
		@BeforeClass(alwaysRun = true)
		public void setUpClasss() throws Exception {
			testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
			ReportingUtil = new ExtentReportUtil();
			ReportingUtil.createReport();
		}
		
		@Test(groups = "cucumber", description = "Runs cucumber Scenarios", dataProvider = "scenarios")
		public void scenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {
			testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());
		}
		
		@DataProvider
		public Object[][] scenarios() {
		    return testNGCucumberRunner.provideScenarios();
		}
		
		@AfterClass(alwaysRun = true)
		public void tearDownClass() {
			testNGCucumberRunner.finish();
			ReportingUtil.flushReport();
		}
	
	}
