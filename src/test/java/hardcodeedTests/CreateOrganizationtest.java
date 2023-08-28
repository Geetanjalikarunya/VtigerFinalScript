package hardcodeedTests;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganizationtest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		if(driver.getTitle().contains("vtiger"))
			System.out.println("Login page is displayed");
		else
			System.out.println("Login page is not found");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).submit();
		
		if(driver.getTitle().contains("Home"))
			System.out.println("Home page is displayed");
		else
			System.out.println("Home page is not found");
		
		driver.findElement(By.xpath("//a[text()='Organizations' and contains(@href,'action=index')]")).click();
		if(driver.getTitle().contains("Organizations"))
			System.out.println("Oraganizations page displayed");
		else
		{
			System.out.println("Organizations page not found");
		}
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		WebElement CreateOrg=driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
		if(CreateOrg.getText().equals("Creating New Organization"))
				System.out.println("Creating New Organizations page is displayed");
		else
			System.out.println("Creating New Organizations not found");
		
		Random random=new Random();
		int randomNum=random.nextInt(100);
		
		String OrgName="TCS"+randomNum;
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		driver.findElement(By.xpath("//input[normalize-space(@value)='Save']")).click();
		
		String NewOrgName=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(NewOrgName.contains(OrgName))
			System.out.println("Organizations created successfully");
		else
		System.out.println("Organizations not found");
		
		WebElement adminIcon=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a=new Actions(driver);
		a.moveToElement(adminIcon).perform();
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();
	}

}
