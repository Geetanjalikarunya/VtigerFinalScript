package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class SamleTest {

	@Test
	public void demo()
	{
		Reporter.log("Hello World!", true);
	}
}
