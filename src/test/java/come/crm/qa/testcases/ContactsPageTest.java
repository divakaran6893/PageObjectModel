package come.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	String sheetname="contacts";
	
	public ContactsPageTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
				
		initialization();
		contactspage= new ContactsPage();
		loginpage= new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
        homepage.clickOnContactsLink();
        Thread.sleep(3000);
}
	
	
	  @Test(priority=1) public void verifyContactsLabelTest() { boolean
	  label=contactspage.verifyContactsLabel(); Assert.assertTrue(label);
	  
	  }
	  
	  @Test(priority=2) public void selectContactsTest() {
	  contactspage.selectContactsByName("tom cat"); 
	  }
	 
	  @Test(priority=3) public void selectMultipleContactsTest() {
	  contactspage.selectContactsByName("tom cat");
	  contactspage.selectContactsByName("diva kar");
	 

	}
	
	@Test(priority=4)
	public void validateCreateNewContactLink() {
		contactspage.clickOnNewContactLink();
		
	}
	@DataProvider
	public Object[][] getCRMTestData() {
	
		Object data[][]=TestUtil.getTestData(sheetname);
		return data;
	}
	
	@Test(priority=5,dataProvider="getCRMTestData")
	public void validateNewContact(String firstname,String lastname,String company,String email) {
		
		contactspage.createNewContact(firstname,lastname,company,email);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
