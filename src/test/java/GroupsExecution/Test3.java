package GroupsExecution;

import org.testng.annotations.Test;

public class Test3 {


	@Test(groups="system")
	public void demo1() {
		System.out.println("Test3 - demo1 - system");
	}
	
	@Test(groups="regression")
	public void demo2() {
		System.out.println("Test3 - demo2 - regression");
	}
	
	@Test(groups="system and regression")
	public void demo3() {
		System.out.println("Test3 - demo2 - system and regression");
	}
}
