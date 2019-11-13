package com.test.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.test.pages.BaseClass;
import com.test.pages.Loginpage;

public class Logintest extends BaseClass {

	
	@Test
	public void loginApp() throws InterruptedException 
	{
		System.out.println(driver.getTitle());
		logger=report.createTest("Login to clicktool");
		Loginpage loginpage=PageFactory.initElements(driver, Loginpage.class);
		logger.info("Starting Application");
		loginpage.loginToCt("swarna123@gmail.com", "12343");
		logger.pass("Login Success");
		
	}
	
}

