package advanceselenium;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChildBrowserPopUp {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//closing the login window
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		Thread.sleep(2000);
		//search for mobiles
		driver.findElement(By.name("q")).sendKeys("mobiles");
		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
		Thread.sleep(2000);
		//click on first mobile
		driver.findElement(By.xpath("//div[text()='realme 11 Pro 5G (Oasis Green, 128 GB)']")).click();
		Thread.sleep(2000);
		//New window opens, collect parent and child window address
		String parentId=driver.getWindowHandle();
		Set<String> allWindows=driver.getWindowHandles();
		
		//SwithTo child window
		for(String s:allWindows)
		{
			driver.switchTo().window(s);
		}
		Thread.sleep(2000);
		//click on add to cart
		driver.findElement(By.xpath("//button[@class=\"_2KpZ6l _2U9uOA _3v1-ww\"]")).click();
		Thread.sleep(2000);
		driver.close();
		
		//Switch to parent Window and Refresh
		driver.switchTo().window(parentId);
		driver.navigate().refresh();
		
		//Validate The cart button
		WebElement cartIcon=driver.findElement(By.xpath("//div[@class='KK-o3G']"));
		if(cartIcon.getText().contains("1"))
		{
			System.out.println("Item Added To The Cart");
			
		}
		else
		{
			System.out.println("Added To The Cart Failed");
		}
		Thread.sleep(2000);
		driver.quit();
	}

}
