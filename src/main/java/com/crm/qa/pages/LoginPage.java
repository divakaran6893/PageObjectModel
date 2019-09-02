package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//page factory (or) object repository
	
	@FindBy(xpath="//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")
	WebElement loginbtn;
	@FindBy(name="email")
	WebElement username;
	@FindBy(name="password")
	WebElement password;
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement submit;
	@FindBy(xpath="//a[@class='btn btn-sm btn-white btn-icon btn-icon-left btn-shadow btn-border btn-rect offset-sm-top-60 offset-top-30']")
    WebElement signup;
	@FindBy(xpath="//img[@title='app for freecrm android']")
	WebElement androidlogo;
	
	
	//initializing the page object
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//actions
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateAndroidLogo() throws InterruptedException {
		Thread.sleep(3000);
		return androidlogo.isDisplayed();
	}
	
	public HomePage login(String un,String pwd) {
		loginbtn.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		submit.click();
		return new HomePage();
	}
	
}
