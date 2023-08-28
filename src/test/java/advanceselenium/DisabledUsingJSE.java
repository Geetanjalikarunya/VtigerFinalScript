package advanceselenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DisabledUsingJSE {

	public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("file:///C:/Users/91733/OneDrive/Desktop/disabled.html");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	//driver.findElement(By.id("abc")).sendKeys("selenium");
	WebElement text=driver.findElement(By.id("abc"));
	
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].value=arguments[1]",text,"selenium");
	Thread.sleep(2000);
	driver.quit();
	

	}

}
