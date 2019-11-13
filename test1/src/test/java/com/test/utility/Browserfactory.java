package com.test.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browserfactory {
public static WebDriver startApplication(WebDriver driver, String browserName, String appURL) throws InterruptedException {
		
		if(browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			 driver= new ChromeDriver();
	       }
		else  
		{
			System.out.println("We do not support this browser");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	public static void quitBrowser(WebDriver driver) {
		
			driver.close();
	}	

}
