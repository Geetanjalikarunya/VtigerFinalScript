package TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGADD {

	@Test
	@Parameters({"i","j"})
	public void add(int a,int b) {
		System.out.println("add:"+(a+b));
	}
	@Test
	@Parameters({"i","j"})
	public void multi(int a,int b) {
		System.out.println("multi:"+(a*b));
	}
	@Test
	@Parameters({"i","j"})
	public void sub(int a,int b) {
		System.out.println("sub:"+(a-b));
	}
}
