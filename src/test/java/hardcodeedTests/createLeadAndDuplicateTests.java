package hardcodeedTests;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class createLeadAndDuplicateTests {

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
		
		driver.findElement(By.xpath("//a[text()='Leads' and contains(@href,'action=index')]")).click();
		if(driver.getTitle().contains("Leads"))
		{
			System.out.println("Leads page is displayed");
		}
			else
			{
				System.out.println("Leads page not found");
		}
 
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		WebElement Leadpage=driver.findElement(By.xpath("//span[text()='Creating New Lead']"));
		if(Leadpage.isDisplayed())
			System.out.println("Creating New Lead page displayed");
		else
			System.out.println("Creating New Lead page not displayed");
		
		
		WebElement dropDown=driver.findElement(By.name("salutationtype"));
		Select s=new Select(dropDown);
		s.selectByValue("Ms.");
		WebElement s1=s.getFirstSelectedOption();
		System.out.println(s1.getText());
		
		Random r=new Random();
		int rNum=r.nextInt();
		
		String Leadname="GEETA"+rNum;
		System.out.println(Leadname);
		String CompanyName="ECIL"+rNum;
		System.out.println(CompanyName);
		driver.findElement(By.name("lastname")).sendKeys(Leadname);
		Thread.sleep(2000);
		driver.findElement(By.name("company")).sendKeys(CompanyName);
        Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@type='radio']")).click();
		driver.findElement(By.xpath("//input[normalize-space(@value)='Save']")).click();
		
		WebElement text=driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]"));
		if(text.isDisplayed())
		System.out.println("Lead page created Successfully");
		else
			System.out.println("Lead page not created");
		
		driver.findElement(By.name("Duplicate")).click();
		driver.findElement(By.xpath("//input[normalize-space(@value)='Save']")).click();
		//driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		
		/*if(G.contains("Lead Information"))
			System.out.println("Lead Duplicated successfully");
		else
			System.out.println("Lead not duplicated");*/
		
		WebElement AdminIcon=driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		Actions a=new Actions(driver);
		a.moveToElement(AdminIcon).perform();
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		Thread.sleep(2000);
		driver.quit();

	}

}
