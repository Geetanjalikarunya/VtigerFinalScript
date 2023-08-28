package GroupsExecution;

import org.testng.annotations.Test;

public class Test4 {


	@Test(groups="smoke")
	public void demo1() {
		System.out.println("Test4 - demo1 - smoke");
	}
	
	@Test(groups={"regression","smoke","functional","system"})
	public void demo2() {
		System.out.println("Test4 - demo2 - regression");
	}
	
	@Test(groups={"system","regression","functional"})
	public void demo3() {
		System.out.println("Test4 - demo2 - smoke and regression");
	}
}
