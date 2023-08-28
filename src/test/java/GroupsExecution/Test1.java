package GroupsExecution;

import org.testng.annotations.Test;

public class Test1 {

	@Test(groups="smoke")
	public void demo1() {
		System.out.println("Test1 - demo1 - smoke");
	}
	
	@Test(groups="regression")
	public void demo2() {
		System.out.println("Test1 - demo2 - regression");
	}
	
	@Test(groups="smoke and regression")
	public void demo3() {
		System.out.println("Test1 - demo2 - smoke and regression");
	}
}
