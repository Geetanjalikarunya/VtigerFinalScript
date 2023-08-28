package advanceselenium;

import java.time.Duration;
 
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPromptPractice {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		
		Alert al=driver.switchTo().alert();
		System.out.println(al.getText());
		al.sendKeys("GeetaKarunyam");
		Thread.sleep(2000);
		al.accept();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.id("result")).getText());
		
		driver.quit();

	}

}
