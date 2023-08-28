package advanceselenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetSizePractice {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.swiggy.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement phoneimg=driver.findElement(By.xpath("//img[@class=\"_3QGpR\"]"));
		Dimension d=phoneimg.getSize();
		int height = d.getHeight();
		int width = d.getWidth();
		 System.out.println("Height: "+height+"\nWidth: "+width);
		 driver.close();

	}

}
