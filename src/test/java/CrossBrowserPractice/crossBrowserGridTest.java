package CrossBrowserPractice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
@Test

public class crossBrowserGridTest {
	WebDriver driver;
    @Parameters("BROWSER")
	@BeforeMethod
	public void googleTest(String browser) throws MalformedURLException
	{
		URL url=new URL("http://192.168.128.158:7777/wd/hub");
		DesiredCapabilities cap=new DesiredCapabilities();
		
		switch(browser) {
		case "chrome":
			cap.setBrowserName("chrome");
			break;
		case "firefox":
			cap.setBrowserName("firefox");
			break;
		case "msedge":
			cap.setBrowserName("msedge");
			break;
		}
	
		cap.setPlatform(Platform.WINDOWS);
		RemoteWebDriver driver=new RemoteWebDriver(url, cap);
	}
    @Test
    public void test1() throws InterruptedException {
    	driver.manage().window().maximize();
    	driver.get("https://www.google.co.in/");
    	
    	Thread.sleep(3000);
    }
    
    @AfterMethod
    public void methodClose() {
    	driver.close();
    }
}

