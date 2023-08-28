package annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	@BeforeSuite
	public void suiteTearUp() {
		System.out.println("Before suite");
	}
	
	@BeforeTest
	public void testtearUp() {
		System.out.println("Before test");
	}
	
	@BeforeClass
	public void classTearUp() {
		System.out.println("Before class");
	}
	
	@BeforeMethod
	public void methodTearUp() {
		System.out.println("Before method");
	}
	
	@AfterMethod
	public void methodTearDown() {
		System.out.println("After Method");
	}
	
	
	@AfterClass
	public void classTearDown() {
		System.out.println("After class");
	}
	
	
	@AfterTest
	public void testTearDown() {
		System.out.println("After test");
	}

	
	@AfterSuite
	public void suiteTearDown() {
		System.out.println("After suite");
	}
	
}
