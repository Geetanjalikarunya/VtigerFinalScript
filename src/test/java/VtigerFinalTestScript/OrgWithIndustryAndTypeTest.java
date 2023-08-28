package VtigerFinalTestScript;

import java.util.Map;

import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import genericLibraries.IConstantPath;

public class OrgWithIndustryAndTypeTest extends BaseClass{

	public void createOrgWithIndustryAndTypeTest() {
		
	
	SoftAssert soft=new SoftAssert();
	home.clickOrganizations();
	soft.assertTrue(driver.getTitle().contains("Organizations"));
	org.clickPlusButton();
	soft.assertTrue(createOrg.getPageHeader().equals("Creating New Organization"));
	Map<String,String> map=excel.readFromExcel("Sheet1", "Create Organisation");
	String orgName=map.get("Organisation Name")+jutil.generateRandomNum(100);
	createOrg.setOrgName(orgName);
	createOrg.selectIndustry(web, map.get("industry"));
	createOrg.selectTypeDropDown(web, map.get("Type"));
	createOrg.clickSaveButton();
	
	soft.assertTrue(newOrgInfo.getPageHeader().contains(orgName));
	if(newOrgInfo.getPageHeader().contains(orgName))
	{
		excel.writeToExcel("Sheet1", "Create Organisation With Industry And Type", "Pass", IConstantPath.Excel_Path);
	}
	else
	{
		excel.writeToExcel("Sheet1", "Create Organisation With Industry And Type", "Fail", IConstantPath.Excel_Path);
	}
	
	
	soft.assertAll();
	
}
}
