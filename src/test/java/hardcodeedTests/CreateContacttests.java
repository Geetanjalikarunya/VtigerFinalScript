package hardcodeedTests;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateContacttests {

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
			System.out.println("Home page is not found");
		
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		if(driver.getTitle().contains("Contacts"))
			System.out.println("Contacts page is found");
		else
			System.out.println("Contacts page is not found");
		
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		WebElement CreateCont=driver.findElement(By.xpath("//span[text()='Creating New Contact']"));
		
		if(CreateCont.isDisplayed())
			System.out.println("Creating New Contact page is found");
		else
			System.out.println("Creating New Contact page not found");
		
		WebElement name=driver.findElement(By.name("salutationtype"));
		Select s=new Select(name);
		s.selectByValue("Mrs.");
		 Thread.sleep(2000);
		WebElement s1=s.getFirstSelectedOption();
		System.out.println(s1.getText());
		
		Random random=new Random();
		int randomNum=random.nextInt(100);
		
		String Lastname="Karunya"+randomNum;
		System.out.println(Lastname);
		driver.findElement(By.name("lastname")).sendKeys(Lastname);
		
		driver.findElement(By.xpath("//input[normalize-space(@value)='Save']")).click();
		
		WebElement s2=driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
	    if(s2.getText().contains("Contact Information"))
	    	System.out.println("[ CON1 ] karunya - Contact Information is created successfully");
	    else
	    	System.out.println("Contact not created");
	    
	    WebElement AdminIcon=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	    Actions a=new Actions(driver);
	    a.moveToElement(AdminIcon).perform();
	    
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	    Thread.sleep(2000);
	    driver.quit();
	    
	    
		
	}

}
