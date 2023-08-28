package advanceselenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsEnabled {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.instagram.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement login=driver.findElement(By.xpath("//button[.='Log in']"));
		if(login.isEnabled())
		{
			System.out.println("Enabled");
			
		}
		else
		{
			System.out.println("disabled");
		}
		
		driver.findElement(By.name("username")).sendKeys("233545657742");
		driver.findElement(By.name("password")).sendKeys("34566687276");
		
		if(login.isEnabled())
		{
			System.out.println("Enabled");
			login.click();
		}
		else
		{
			System.out.println("Disabled");
		}
		
		driver.quit();

	}

}
