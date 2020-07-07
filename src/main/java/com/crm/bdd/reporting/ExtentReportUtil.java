package com.crm.bdd.reporting;

import java.io.File;
import java.time.LocalDateTime;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.crm.bdd.utils.TestStatus;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentBDDReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.bdd.utils.ConfigFileReader;


public class ExtentReportUtil {
	
	private static ExtentTest feature;
	private static ExtentTest scenario;
	private static ExtentReports extent;
	private ConfigFileReader ConfigReader;
	
	public ExtentReportUtil() throws Exception {
		ConfigReader = new ConfigFileReader();
	}
	
	public void createReport() throws Exception {
		try {
			
			ExtentHtmlReporter htmlReporter;
			String AppName = ConfigReader.getAppName();
			String TestRunID = AppName + "_" + LocalDateTime.now().toString().replace(":", "_").replace(".", "_");
			String path = ConfigReader.getHtmlReportPath() + File.separator  + "ExecutionReport_" + TestRunID + ".html";
			
			htmlReporter = new ExtentHtmlReporter(path);
			ExtentBDDReporter bddReporter = new ExtentBDDReporter(path);
			extent = new ExtentReports();  //create object of ExtentReports
			extent.attachReporter(htmlReporter);
			extent.attachReporter(bddReporter);
	
			htmlReporter.config().setDocumentTitle(AppName + ": Automation Execution Report"); // Title of Report
			htmlReporter.config().setReportName(AppName + ": Automation Execution Report"); // Name of the report
			htmlReporter.config().setTheme(Theme.STANDARD);//Default Theme of Report
	
			// General information related to application
			extent.setSystemInfo("Application Name", AppName);
			extent.setSystemInfo("User Name", System.getProperty("user.name"));
			extent.setSystemInfo("Envirnoment", "SIT");
			
		} catch(Exception e) {
			throw new Exception("Exception while creating HtmlReport: " + e.getMessage());
		}
	}
	
	public void flushReport() {
		extent.flush();
	}
	
	public void addScenarioStepDetails(WebDriver driver, GherkinKeyword keyword, String stepName, String Actual, TestStatus status) throws Exception {
		
		ExtentTest step = scenario.createNode(keyword, stepName, "");
		
		if(status == TestStatus.FAIL)
		{
			
			step.log(Status.FAIL, MarkupHelper.createLabel(Actual, ExtentColor.RED));
			String screenshotPath = takeScreeshot(driver);
			//To add it in the extent report 

			step.fail("Snapshot " + step.addScreenCaptureFromPath(screenshotPath));
			System.out.println(step.getStatus().toString());
		} else if(status == TestStatus.WARNING)
			step.log(Status.PASS, MarkupHelper.createLabel(Actual, ExtentColor.GREEN));

		else if(status == TestStatus.PASS)
		{
			step.log(Status.PASS, MarkupHelper.createLabel(Actual, ExtentColor.GREEN));
		}
	}
	
	public String takeScreeshot(WebDriver driver) throws Exception {
		try {
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			
			FileUtils FileUtil = FileUtils.getFileUtils();
			String FileName = System.currentTimeMillis() + ".png";
			FileUtil.copyFile(srcFile, new File(FileName));
			return FileName;
		} catch(Exception e) {
			throw new Exception("Exception while taking screenshot: " + e.getMessage());
		}
		
	}
	
	public void addScenarioNode(String scenarioName) {
		scenario = feature.createNode(scenarioName);
	}
	
	public void addFeatureNode(String featureName) {
		feature = extent.createTest(featureName);
	}
	
	public void skipTest(String scenarioName) {
		feature.createNode(scenarioName).skip("Skipped");
	}
}
