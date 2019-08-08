package com.employeeapi.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.exceptions.ExtentTestInterruptedException;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Listener implements ITestListener {
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	public void onTestStart(ITestResult result) {
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/myReport.html");
		htmlReporter.config().setDocumentTitle("Rest Assured Test Report");
		htmlReporter.config().setReportName("API Testing");
		htmlReporter.config().setTheme(Theme.DARK);
		extent=new ExtentReports();
		test=extent.createTest("Test Report");
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Project Name","MY Project");
		
		
	}

	public void onTestSuccess(ITestResult result) {
		//test=extent.createTest(result.getName());
		test.log(Status.PASS, "Test Case Passed is ..."+result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		//test=extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Case Failed is ..."+result.getName());
		test.log(Status.FAIL, "Test Case Failed is ..."+result.getThrowable());
		
	}

	public void onTestSkipped(ITestResult result) {
		//test=extent.createTest(result.getName());
		test.log(Status.SKIP, "Test Case Skipped is ..."+result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}
