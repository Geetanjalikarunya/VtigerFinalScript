package genericLibraries;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	/**
	 * This class contains all reusable methods to perform driver related operations
	 * 
	 * @author HP
	 *
	 */
	

		private WebDriver driver;
		private WebDriverWait wait;

		/**
		 * This method is used to launch specified browser
		 * 
		 * @param browser
		 * @return
		 */
		public WebDriver launchBrowser(String browser) {

			switch (browser) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
				driver = new ChromeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			default:
				System.out.println("Invalid Browser info");

			}
			return driver;
		}

		/**
		 * This method is used to maximize the browser
		 */
		public void maximizeBrowser() {
			driver.manage().window().maximize();
		}

		/**
		 * This method is used to navigate to the specified application
		 * 
		 * @param Url
		 */
		public void navigateToApp(String url) {
			driver.get(url);
		}

		/**
		 * This method is used to wait until till the element is found
		 * 
		 * @param time
		 */
		public void waitTillElementFound(long time) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		}

		/**
		 * This method is used to wait until element is vissible to access
		 * 
		 * @param time
		 * @param element
		 * @return
		 */
		public WebElement explicitWait(long time, WebElement element) {
			wait = new WebDriverWait(driver, Duration.ofSeconds(time));
			return wait.until(ExpectedConditions.visibilityOf(element));
		}

		/**
		 * This method is used to wait until element is enabled to receive click
		 * 
		 * @param element
		 * @param time
		 * @return
		 */
		public WebElement explicitWait(WebElement element, long time) {
			wait = new WebDriverWait(driver, Duration.ofSeconds(time));
			return wait.until(ExpectedConditions.elementToBeClickable(element));
		}

		/**
		 * This method is used to wait until web page title appears
		 * 
		 * @param title
		 * @param time
		 * @return
		 */
		public Boolean explicitWait(String title, long time) {
			wait = new WebDriverWait(driver, Duration.ofSeconds(time));
			return wait.until(ExpectedConditions.titleContains(title));
		}

		/**
		 * This method is used to mouse hover on an element
		 * 
		 * @param element
		 */

		public void mouseHover(WebElement element) {
			Actions action = new Actions(driver);
			action.moveToElement(element).perform();
		}

		/**
		 * This method is used to right click on an element
		 * 
		 * @param element
		 */
		public void rightClick(WebElement element) {
			Actions action = new Actions(driver);
			action.contextClick(element).perform();
		}

		/**
		 * This method is used to double click on an element
		 * 
		 * @param element
		 */
		public void doubleClickOnElement(WebElement element) {
			Actions action = new Actions(driver);
			action.doubleClick(element).perform();
		}

		/**
		 * This method is used to drag and drop the element to the target
		 * 
		 * @param element
		 * @param target
		 */
		public void dragAndDrop(WebElement element, WebElement target) {
			Actions action = new Actions(driver);
			action.dragAndDrop(element, target).perform();
		}

		/**
		 * This method is used to select an element from drop down based on index
		 * 
		 * @param element
		 * @param index
		 */
		public void selectFromDropDown(WebElement element, int index) {
			Select select = new Select(element);
			select.selectByIndex(index);
		}

		/**
		 * This method is used to select an element from drop down based on value
		 * 
		 * @param element
		 * @param value
		 */

		public void selectFromDropDown(WebElement element, String value) {
			Select select = new Select(element);
			select.selectByValue(value);
		}

		/**
		 * This method is used to select an element from the drop down based on visible
		 * Text
		 * 
		 * @param visibleText
		 * @param element
		 */
		public void selectFromDropDown(String visibleText, WebElement element) {
			Select select = new Select(element);
			select.selectByVisibleText(visibleText);
		}

		/**
		 * This method is used to switch the control to frame based on frame index
		 * 
		 * @param index
		 */

		public void switchToFrame(int index) {
			driver.switchTo().frame(index);
		}

		/**
		 * This method is used to switch the control to frame based on id or string
		 * 
		 * @param idOrName
		 */
		public void switchToFrame(String idOrName) {
			driver.switchTo().frame(idOrName);
		}

		/**
		 * This method is used to switch the control to frame on main web page
		 * 
		 * @param frameElement
		 */
		public void switchToFrame(WebElement frameElement) {
			driver.switchTo().frame(frameElement);
		}

		/**
		 * This method is used to switch back from frame to main web page
		 */

		public void switchBackFromFram() {
			driver.switchTo().defaultContent();
		}

		/**
		 * This method is used to take screenshot of the web page and generic image file
		 * 
		 * @param className
		 * @param jUtil
		 * @return
		 */

		public String takeScreenshot(String className, JavaUtility jUtil, WebDriver driver) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File("./Screenshot/" + className + "_" + jUtil.getCurrentTime() + ".png");
			try {
				FileUtils.copyFile(src, dest);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dest.getAbsolutePath();
		}

		/**
		 * This method is used to take the screenshot of the web page and generic BASE64
		 * image
		 * 
		 * @return
		 */
		public String takeScreenshot() {
			TakesScreenshot ts = (TakesScreenshot) driver;
			return ts.getScreenshotAs(OutputType.BASE64);
		}

		/**
		 * This method is used to scroll till the specified web element
		 * 
		 * @param element
		 */
		public void scrollToElement(WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)", element);
		}

		/**
		 * This method handles alert popup
		 * 
		 * @param status
		 */
		public void handleAlert(String status) {
			Alert alert = driver.switchTo().alert();
			if (status.equalsIgnoreCase("ok")) {
				alert.accept();
			} else {
				alert.dismiss();
			}
		}

		/**
		 * This method is used to switch to child browser
		 */
		public void switchToChildWindow() {
			Set<String> set = driver.getWindowHandles();
			for (String window : set) 
			{
				driver.switchTo().window(window);
			}

		}

		/**
		 * This method is used to switch to the specified window
		 * 
		 * @param windowID
		 */
		public void switchToWindow(String windowID) {
			driver.switchTo().window(windowID);
		}

		/**
		 * This method is used to get the parent window address
		 * 
		 * @return
		 */
		public String getParentWindowID() 
		{
			return driver.getWindowHandle();
		}
		
		/**
		 * This method is used to close the current window
		 */
		public void closeCurrentWindow()
		{
			driver.close();
		}
		
		/**
		 * This method is used to quit all the windows
		 */
		public void quitAllWindows()
		{
			driver.quit();
		}

		/**
		 * This method is used to String to Dynamic xpath
		 * @param commonpath
		 * @param replaceData
		 * @return
		 */
		public WebElement convertStringToDynamicXpath(String commonpath,int replaceData) {
			String requiredPath=String.format(commonpath, replaceData);
			return driver.findElement(By.xpath(requiredPath));
		}

		public WebElement convertStringToDynamicXpath(String commonPath, String replaceData) {
			String requiredPath=String.format(commonPath, replaceData);
			return driver.findElement(By.xpath(requiredPath));
		}
		
	
	
}
