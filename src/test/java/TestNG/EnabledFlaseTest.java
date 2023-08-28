package TestNG;

import org.testng.annotations.Test;

public class EnabledFlaseTest {

	
	@Test(invocationCount=1)
	public void test1() {
    System.out.println("test1");
	}
	@Test(enabled=false)
	public void test2() {
	    System.out.println("test2");
		}
}
