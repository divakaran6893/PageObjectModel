package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	//page factory (or) object repository

	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement contactslabel;
	
	@FindBy(xpath="//a[@href='/contacts/new']")
	WebElement newcontact;
	
	@FindBy(name="first_name")
	WebElement firstname;
	
	@FindBy(name="last_name")
	WebElement lastname;
	
	@FindBy(xpath="//input[@class='search']")
	WebElement company;
	
	@FindBy(name="value")
	WebElement email;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement savebtn;
	
	
	
	//initializing the page object
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
//actions
	
	public boolean verifyContactsLabel() {
		return contactslabel.isDisplayed();
	}
	
public void selectContactsByName(String name) {
	driver.findElement(By.xpath("//td[text()='"+name+"']//preceding-sibling::td//div[@class='ui fitted read-only checkbox']")).click();
}
	public void clickOnNewContactLink() {
		newcontact.click(); 
	}
	
	public void createNewContact(String fname,String lname,String comp,String eml) {
		newcontact.click();
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		company.sendKeys(comp);
		email.sendKeys(eml);
		savebtn.click();
		
	}
 
}
