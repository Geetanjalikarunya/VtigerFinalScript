package hardcodeedTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateContactWithExistingOrgtests {

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
			System.out.println("Home page not displayed");
		
		driver.findElement(By.xpath("//a[text()='Organizations' and contains(@href,'action=index')]")).click();
		if(driver.getTitle().contains("Organizations"))
			System.out.println("Oraganizations page displayed");
		else
		{
			System.out.println("Organizations page not found");
		}
		
		driver.findElement(By.xpath("//a[@href=\"index.php?module=Accounts&parenttab=Marketing&action=DetailView&record=2\"]")).click();
		if(driver.getTitle().contains("Organizations"))
			System.out.println("existing Org page displayed");
		else
			System.out.println("existing org page not found");
		
		driver.findElement(By.xpath("//a[text()='More Information']")).click();
		if(driver.getTitle().contains("Organizations"))
			System.out.println("Organization More Information page displayed");
		else
			System.out.println("Organization More Information page not found");
			
		driver.findElement(By.id("show_Accounts_Contacts")).click();
		driver.findElement(By.xpath("//input[@value='Add Contact']")).click();
		if(driver.getTitle().contains("Contacts"))
			System.out.println("Creating New Contact page displayed");
		else
			System.out.println("Creating New Contact page not found");
		
		WebElement dropDown=driver.findElement(By.name("salutationtype"));
		Select s=new Select(dropDown);
		s.selectByValue("Ms.");
		WebElement s1=s.getFirstSelectedOption();
		System.out.println(s1.getText());
		
		driver.findElement(By.name("lastname")).sendKeys("Anjali");
		driver.findElement(By.xpath("//input[normalize-space(@value)='Save']")).click();
		
		Thread.sleep(2000);
		WebElement adminIcon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a = new Actions(driver);
		a.moveToElement(adminIcon).perform();

		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		Thread.sleep(2000);
		driver.quit();

		
	}

}
