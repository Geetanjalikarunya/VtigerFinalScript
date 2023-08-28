package advanceselenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class explicitWaitElementToBeClickable {

	public static void main(String[] args) {
	    WebDriver driver= new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://www.instagram.com/");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    WebElement LoginButton=driver.findElement(By.xpath("//button[.='Log in']"));
	    
	    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	     
	    try {
	    	wait.until(ExpectedConditions.elementToBeClickable(LoginButton)).click();
	    
	    }catch(Exception e) {
	    	System.out.println("element disabled");
	    }
	     
	    driver.findElement(By.name("username")).sendKeys("spkumar0414");
	    driver.findElement(By.name("password")).sendKeys("7337850125");
	    WebElement Login=driver.findElement(By.xpath("//button[.='Log in']"));
	    
	    WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(30));
	    
	    try {
	    	wait1.until(ExpectedConditions.elementToBeClickable(Login)).click();
	    }catch(Exception a) {
	    	System.out.println("Login failed");
	    }
   driver.quit();
	}

}
