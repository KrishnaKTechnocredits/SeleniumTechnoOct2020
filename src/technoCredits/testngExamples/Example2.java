package technoCredits.testngExamples;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Example2 {
	
	
	@BeforeMethod
	void setUp(){
		System.out.println("Setup");
	}
	
	@Test(priority=12222)
	void secondTest() {
		System.out.println("secondTest");
	}
	
	@Test(priority=-1)
	void lastTest() {
		System.out.println("lastTest");
	}
	
	@Test
	void alastTest() {
		System.out.println("alastTest");
	}
	
	
	@AfterMethod
	void tearDown() {
		System.out.println("Teardown");
	}
}
