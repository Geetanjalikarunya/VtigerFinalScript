package hardcodeedTests;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOraganizationAndIndustry {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		if(driver.getTitle().contains("Home"))
			System.out.println("Home page displayed");
		else
		System.out.println("Home page not found");
	
		driver.findElement(By.xpath("//a[text()='Organizations' and contains(@href,'action=index')]")).click();
		if(driver.getTitle().contains("Organizations"))
			System.out.println("Organizations page is display");
		else
			System.out.println("Organizations page not found");
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		WebElement CreateOrg=driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
		if(CreateOrg.isDisplayed())
		System.out.println("Creating New Organization page found");
		else
			System.out.println("Creating New Organization page not found");
		
		
		Random random=new Random();
		int randomNum=random.nextInt();
		
		String OrgName="TCS12"+randomNum;
		
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		
		WebElement industryDropdown=driver.findElement(By.name("industry"));
		WebElement typeDropdown=driver.findElement(By.xpath("//select[@name=\"accounttype\"]"));
		Select s=new Select(industryDropdown);
		s.selectByValue("Energy");
		Select s1=new Select(typeDropdown);
		s1.selectByValue("Integrator");
		WebElement industry=s.getFirstSelectedOption();
		System.out.println(industry.getText());
		WebElement type=s1.getFirstSelectedOption();
		System.out.println(type.getText());
		
		
		driver.findElement(By.xpath("//input[normalize-space(@value)='Save']")).click();
		
		String NewOrgName=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(NewOrgName.contains(OrgName))
		System.out.println("Oraganization and industry created successfully");
		else
			System.out.println("Oraganization and industry failed");
		WebElement adminstratorOptions=driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		Actions a=new Actions(driver);
		a.moveToElement(adminstratorOptions).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();
		
	}

}
