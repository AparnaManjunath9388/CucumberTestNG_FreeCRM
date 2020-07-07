package com.crm.bdd.reporting;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

	ExtentReportUtil ReportingUtil;
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("on test start " + result.getTestName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("on test success " + result.getTestName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("on test failure " + result.getTestName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		try {
			ReportingUtil = new ExtentReportUtil();
			ReportingUtil.skipTest(result.getTestName());
			System.out.println("on test skipped " + result.getTestName());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("on start: " + context.getName());
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("on finish: " + context.getName());
		
	}

}
