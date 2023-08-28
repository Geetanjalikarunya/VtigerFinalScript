package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pomPages.ContactsPage;
import pomPages.CreateContactInfoPage;
import pomPages.CreateNewContactPage;
import pomPages.CreateNewEventPage;
import pomPages.CreateNewEvetInfoPage;
import pomPages.CreateNewLeadInfoPage;
import pomPages.CreateNewLeadPage;
import pomPages.CreateNewOrganizationPage;
import pomPages.DuplicatingLeadPage;
import pomPages.HomePage;
import pomPages.LeadsPage;
import pomPages.NewOrgInfoPage;
import pomPages.OrganizationsPage;
import pomPages.VtigerLogin;

public class BaseClass {
//*genericUtilities instances
	
	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected JavaUtility jutil;
	protected WebDriverUtility web;
	protected WebDriver driver;
	
	//pomPages instances
	
	protected VtigerLogin login;
	protected HomePage home;
	protected OrganizationsPage org;
	protected ContactsPage contacts;
	protected LeadsPage lead;
	protected CreateNewOrganizationPage createOrg;
	protected CreateNewContactPage createContact;
	protected CreateNewEventPage createEvent;
	protected CreateNewLeadPage createLead;
	protected NewOrgInfoPage newOrgInfo;
	protected CreateContactInfoPage newContactInfo;
	protected CreateNewLeadInfoPage newLeadInfo;
	protected CreateNewEvetInfoPage newEventInfo;
	protected DuplicatingLeadPage duplicatingLead;
	
	public static WebDriver sdriver;
	public static JavaUtility sjutil;
	
	//@BeforeSuite
	//@BeforeTest
	
	@BeforeClass
	public void classSetup() {
		property=new PropertiesUtility();
		excel=new ExcelUtility();
		jutil=new JavaUtility();
		web =new WebDriverUtility();
		
		property.propertiesinitialization(IConstantPath.properties_Path);
		driver=web.launchBrowser(property.readFromProperties("browser"));
		web.maximizeBrowser();
		web.waitTillElementFound(Long.parseLong(property.readFromProperties("time")));
		
		sdriver=driver;
		sjutil=jutil;
	}
	
	@BeforeMethod
	public void methodSetup() {
		excel.excelInitialization(IConstantPath.Excel_Path);
		
		login=new VtigerLogin(driver);
		home=new HomePage(driver);
		org=new OrganizationsPage(driver);
		contacts=new ContactsPage(driver);
		lead=new LeadsPage(driver);
		createOrg=new CreateNewOrganizationPage(driver);
		createContact=new CreateNewContactPage(driver);
		createLead=new CreateNewLeadPage(driver);
		createEvent=new CreateNewEventPage(driver);
		newOrgInfo=new NewOrgInfoPage(driver);
		newContactInfo=new CreateContactInfoPage(driver);
		newLeadInfo=new CreateNewLeadInfoPage(driver);
		newEventInfo=new CreateNewEvetInfoPage(driver);
		duplicatingLead=new DuplicatingLeadPage(driver);
		
		web.navigateToApp(property.readFromProperties("url"));
		Assert.assertTrue(driver.getTitle().contains("vtiger"));
		login.loginToApp(property.readFromProperties("username"),property.readFromProperties("password"));
		Assert.assertTrue(driver.getTitle().contains("Home"));
	}
	
	
	@AfterMethod
	public void methodTearDown() {
		home.signOutOfVtiger(web);
		excel.excelClose();
	}
	
	@AfterClass
	public void classTearDown() {
		web.quitAllWindows();
	}
	
	
	//@AfterTest
	//@AfterSuite
	
}
