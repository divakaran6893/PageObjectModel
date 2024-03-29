package come.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{

	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	
	public HomePageTest() {
		super();
		
	}

	@BeforeMethod
	public void setUp() {
		
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));

	}

	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
	String homepagetitle=homepage.verifyHomePageTitle();
	Assert.assertEquals(homepagetitle, "CRM");
	}
	
	@Test(priority=2)
	public void verifyCorrectUsernameTest() {
		boolean label=homepage.verifyCorrectUsername();
		Assert.assertTrue(label);
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		contactspage=homepage.clickOnContactsLink();
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}