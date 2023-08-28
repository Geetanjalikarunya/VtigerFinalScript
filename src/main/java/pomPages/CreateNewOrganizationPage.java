package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;

public class CreateNewOrganizationPage 
{
    //Declaration
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement pageHeader;
	@FindBy(name="accountname")
	private WebElement orgNameTF;
	@FindBy(name="industry")
	private WebElement industryDropDown;
	@FindBy(name="accounttype")
	private WebElement typeDropDown;
	@FindBy(xpath="//input[normalize-space(@value)='Save']")
	private WebElement saveButton;
	
	//Initialization
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	public void setOrgName(String orgName)
	{
		orgNameTF.sendKeys(orgName);
	}
	
	public void selectIndustry(WebDriverUtility web,String value) {
		web.selectFromDropDown(industryDropDown,value);
	}
	
	public void selectTypeDropDown(WebDriverUtility web,String value) {
		web.selectFromDropDown(typeDropDown,value);
	}
	
	public void clickSaveButton() {
		saveButton.click();
	}
	
}
