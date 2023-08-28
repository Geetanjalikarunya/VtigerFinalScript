package VtigerFinalTestScript;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import genericLibraries.IConstantPath;

public class CreateNewEventTest extends BaseClass {

	@Test
	public void createNewEventTest() {
		SoftAssert soft = new SoftAssert();
		Map<String, String> map = excel.readFromExcel("Sheet4", "Create New Event");
		home.selectFromquickCreate(web, map.get("Quick Create"));
		soft.assertEquals(createEvent.getPageHeader(), "Create To Do");
		String subject = map.get("Subject") + jutil.generateRandomNum(100);
		createEvent.setSubject(subject);
		createEvent.clickOnStartDate();
		createEvent.chooseRequiredDate(web, map.get("Start Date"), jutil);
		createEvent.clickOnDueDate();
		createEvent.chooseRequiredDate(web, map.get("Due Date"), jutil);
		createEvent.clickSaveButton();

		soft.assertTrue(newEventInfo.getPageHeader().contains(subject));
		if (newEventInfo.getPageHeader().contains(subject))

			excel.writeToExcel("Sheet4", "Create New Event", "Pass", IConstantPath.Excel_Path);
		else
			excel.writeToExcel("Sheet4", "Create New Event", "Fail", IConstantPath.Excel_Path);

		soft.assertAll();
	}
}
