package hardcodeedTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateEvettests {

	public static void main(String[] args) {
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
			System.out.println("Home page is not found");
		
		
		driver.findElement(By.xpath("//a[text()='Calendar']")).click();
		
		if(driver.getTitle().contains("Calendar"))
			System.out.println("Caleder page is displayed");
		else
			System.out.println("calender page not found");
		
		driver.findElement(By.xpath("//a[text()='Day']")).click();
		
		WebElement add=driver.findElement(By.className("calAddButton"));
		Actions a=new Actions(driver);
		a.moveToElement(add).perform();
	    
		driver.findElement(By.id("addcall")).click();
		driver.findElement(By.name("subject")).sendKeys("Event2");
		
		WebElement dropDown=driver.findElement(By.id("eventstatus"));
		Select s=new Select(dropDown);
		s.selectByValue("Held");
		WebElement s1=s.getFirstSelectedOption();
		System.out.println(s1.getText());
		
		driver.findElement(By.xpath("//input[@value='Save' and contains(@name,'eventsave')]")).click();
		if(driver.getTitle().contains("Calendar"))
			System.out.println("Event added successfully");
		else
			System.out.println("Event not added");
		
		WebElement Admin=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		a.moveToElement(Admin).perform();
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		driver.quit();
	
	}

}
