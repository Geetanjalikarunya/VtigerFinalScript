package VtigerFinalTestScript;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import genericLibraries.IConstantPath;

public class CreateLeadTest extends BaseClass{

	//String lastName;
	@Test
	public void createLeadTest() {
		
		SoftAssert soft=new SoftAssert();
		home.clickLeads();
		soft.assertTrue(driver.getTitle().contains("Leads"));
		lead.clickPlusButton();
		soft.assertEquals(createLead.getPageHeader(), "Creating New Lead");
		Map<String,String> map=excel.readFromExcel("Sheet3", "Create lead");
		String lastName= map.get("Last Name")+jutil.generateRandomNum(100);
		excel.writeToExcel("Sheet3", 11, 3, lastName, IConstantPath.Excel_Path);
		//lastName=map.get("Last Name")+jutil.generateRandomNum(100);
		createLead.setLastName(lastName);
		createLead.setCompanyName(map.get("Company"));
		createLead.clickSaveButton();
		
		soft.assertTrue(newLeadInfo.getPageHeader().contains(lastName));
		if(newLeadInfo.getPageHeader().contains(lastName))
			excel.writeToExcel("Sheet3", "Create lead", "Pass", IConstantPath.Excel_Path);
		else
			excel.writeToExcel("Sheet3", "Create lead", "Fail", IConstantPath.Excel_Path);
		
		soft.assertAll();
	}
}
