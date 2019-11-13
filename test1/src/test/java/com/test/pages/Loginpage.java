package com.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage {

	WebDriver driver;
	
	public Loginpage(WebDriver ldriver)
	
	{
		this.driver=ldriver;
	}
	        @FindBy(xpath="//button[@class='btn2']") WebElement loginButton;
			@FindBy(xpath="//input[@name='email']") WebElement emailId;
			@FindBy(xpath="//input[@name='password']") WebElement Password;
			@FindBy(xpath="//button[@data-radium='true']") WebElement Loginapp;
			public void loginToCt(String email, String password)
			{
			    try {
			        Thread.sleep(4000);
			    } catch (InterruptedException e) {
			        
			    }
			    loginButton.click();
			    emailId.sendKeys(email);
			    Password.sendKeys(password);
			    Loginapp.click();
			}
	
}
