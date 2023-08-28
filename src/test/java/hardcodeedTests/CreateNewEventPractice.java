package hardcodeedTests;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateNewEventPractice {

	

	public static void main(String[] args) {
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
		
		
		WebElement QuickAccess=driver.findElement(By.id("qccombo"));
		Select s=new Select(QuickAccess);
		s.selectByValue("Events");
		String CreateTodo=driver.findElement(By.xpath("//b[text()='Create To Do']")).getText();
		if(CreateTodo.contains("Create To Do"))
			{
			System.out.println("Create To Do page displayed");
			}
			else {
				System.out.println("Create To Do page not found");
			}
		
		Random random=new Random();
		int randomNum=random.nextInt(100);
		
		String sub="Meet"+randomNum;
		driver.findElement(By.name("subject")).sendKeys(sub);
		driver.findElement(By.id("jscal_field_date_start")).click();
		
		String reqDate="19";
		int reqMonth=10;
		int reqyear=2025;
		
			//String commonPath="//div[@class='calendar' and contains(@style,'block')]/descendant::td[%s]";
				
				
		String actMonthYear= driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[@class='title']")).getText();
		System.out.println(actMonthYear);
		
	String[] str=actMonthYear.split(", ");
	int actyear = Integer.parseInt(str[1]);
		
		while(actyear<reqyear) 
		{
			driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[text()='»']")).click();
			actMonthYear= driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[@class='title']")).getText();
			System.out.println(actMonthYear);
			
		str=actMonthYear.split(", ");
		 actyear = Integer.parseInt(str[1]);
			
		}
		
		int actMonth = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str[0]).get(ChronoField.MONTH_OF_YEAR);
		System.out.println(actMonth);
		
		while(actMonth<reqMonth)
		{
			driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[text()='›']")).click();
			 actMonthYear= driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[@class='title']")).getText();
			System.out.println(actMonthYear);
			
		 str=actMonthYear.split(", ");
		
		 actMonth = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str[0]).get(ChronoField.MONTH_OF_YEAR);
			System.out.println(actMonth);
			
		}
		while(actMonth>reqMonth)
		{
			driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[text()='‹']")).click();
			actMonthYear= driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[@class='title]")).getText();
			System.out.println(actMonthYear);
			
		 str=actMonthYear.split(", ");
		
		 actMonth = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str[0]).get(ChronoField.MONTH_OF_YEAR);
			System.out.println(actMonth);
		}
		
		driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[text()='"+reqDate+"'")).click();
		driver.quit();

	}
	

}
