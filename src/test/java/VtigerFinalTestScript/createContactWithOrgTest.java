package VtigerFinalTestScript;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import genericLibraries.IConstantPath;

public class createContactWithOrgTest extends BaseClass
{
@Test
public void createContactWithOrgTest() {
	
	SoftAssert soft=new SoftAssert();
	home.clickContacts();
	soft.assertTrue(driver.getTitle().contains("Contacts"));
	contacts.clickPlusButton();
	soft.assertEquals(createContact.getPageHeader(), "Creating New Contact");
	
	Map<String,String> map=excel.readFromExcel("Sheet2", "Create Contact");
	String lastName=map.get("Last Name")+jutil.generateRandomNum(100);
	createContact.setLastName(lastName);
	createContact.selectExistingorg(web, map.get("Organisation Name"));
	createContact.clickSaveButton();
	soft.assertTrue(newContactInfo.getPageHeader().contains(lastName));
	if(newContactInfo.getPageHeader().contains(lastName))
		excel.writeToExcel("Sheet2", "Create Contact With Organisation", "Pass", IConstantPath.Excel_Path);
	else
		excel.writeToExcel("Sheet2", "Create Contact With Organisation", "Fail", IConstantPath.Excel_Path);
	
	soft.assertAll();
}
  
	
}
