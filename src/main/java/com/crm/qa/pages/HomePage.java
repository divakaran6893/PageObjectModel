package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//page factory (or) object repository
	
	@FindBy(xpath="//span[@class='user-display']")
	WebElement userlabel;
	
	@FindBy(xpath="//a[@href='/contacts']")
	WebElement contactslink;

	@FindBy(xpath="//a[@href='/deals']")
	WebElement dealslink;
	
	@FindBy(xpath="//a[@href='/tasks']")
	WebElement taskslink;

	//initializing the page object
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	//actions 
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
		
	}
	public boolean verifyCorrectUsername() {
		return userlabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
		contactslink.click();
		return new ContactsPage();
	}

	public DealsPage clickOnDealsLink() {
		dealslink.click();
		return new DealsPage();
	}
	public TasksPage clickOnTasksLink() {
		taskslink.click();
		return new TasksPage();
	}
	
	}