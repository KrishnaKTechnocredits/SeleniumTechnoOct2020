package technoCredits.testngExamples;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Example4 {
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("****Before Suite****");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class - Example4 - Open Browser");
	}
	
	@Test(priority=1)
	void example4Test1() {
		System.out.println("Example4 Test1");
	}
}
