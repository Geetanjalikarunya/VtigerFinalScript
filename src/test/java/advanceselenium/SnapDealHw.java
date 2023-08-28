package advanceselenium;
 
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.github.dockerjava.api.model.Frame;

public class SnapDealHw {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement snap=driver.findElement(By.xpath("//span[text()='Sign In']"));
		Actions a=new Actions(driver);
		a.moveToElement(snap).perform();
		
	
		driver.findElement(By.xpath("//a[text()='login']")).click();
		Thread.sleep(1000);
		driver.switchTo().frame("loginIframe");
		
		driver.findElement(By.xpath("//input[@placeholder=\"Mobile Number/ Email\"]")).sendKeys("7337850125");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//i[@class=\"sd-icon sd-icon-delete-sign fnt-22\"]")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.id("inputValEnter")).sendKeys("Toys");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@class=\"sd-icon sd-icon-search-under-catagory lfloat\"]")).click();
		Thread.sleep(2000);
		driver.quit();
	}

}
