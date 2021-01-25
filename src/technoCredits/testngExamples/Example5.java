package technoCredits.testngExamples;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Example5 {
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("BeforeTest");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class - Example5 - Open Browser");
	}
	
	@Test(priority=-1)
	void example5Test1() {
		System.out.println("Example5 Test1");
	}
}
