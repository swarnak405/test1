package com.test.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.test.utility.Browserfactory;
import com.test.utility.ConfigdataProvider;
import com.test.utility.Helper;

public class BaseClass {
	public WebDriver driver;
	public ConfigdataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite()
	public void setUpSuit() throws IOException
	{
		Reporter.log("Setting up reports and Test Started", true);
		config=new ConfigdataProvider();
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/Clicktool_"+Helper.getCurrentDateTime()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);
		Reporter.log("Setting Done- Test can be started", true);
	}
	@BeforeClass
	public void Setup() throws InterruptedException
	{
		Reporter.log("Trying to start browser and Getting application ready", true);
		driver=Browserfactory.startApplication(driver,config.getBrowser(),config.getStagingURL());	
		Reporter.log("Browser and application is running", true);
	}
	@AfterClass
	public void Closebrowser(){
		Browserfactory.quitBrowser(driver);
	}
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
		Reporter.log("Test is about to end", true);
		if(result.getStatus()==ITestResult.FAILURE){
			Helper.captureScreenshot(driver);
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		
		else if(result.getStatus()==ITestResult.SUCCESS){
			logger.pass("Test passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			
		}
		report.flush();
		Reporter.log("Test completed>>>Reports generated", true);
	}

}
