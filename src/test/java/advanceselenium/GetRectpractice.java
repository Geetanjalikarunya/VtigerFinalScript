package advanceselenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetRectpractice {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement shoes=driver.findElement(By.xpath("//span[contains(@class,'sprites-headerUser')]"));
		Rectangle rect=shoes.getRect();
		int x=rect.getX();
		int y=rect.getY();
		int h=rect.getHeight();
		int w=rect.getWidth();
		System.out.println("x coordinate: "+x+"\ny coordinate: "+y+"\nHeight: "+h+"\nWidth: "+w);
		driver.quit();

	}

}
