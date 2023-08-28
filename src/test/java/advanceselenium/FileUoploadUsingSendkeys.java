package advanceselenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUoploadUsingSendkeys {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.foundit.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//div[normalize-space(text())='Upload Resume']")).click();
		driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\91733\\Downloads\\Ashu Resume.docx");

		
		Thread.sleep(3000);
		driver.quit();
	}

}
