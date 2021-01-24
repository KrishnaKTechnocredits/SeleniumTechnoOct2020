package technoCredits.testngExamples;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Example3 {
	@BeforeClass
	void beforeClass(){
		System.out.println("beforeclass");
	}

	@BeforeMethod
	public void beforeMethod(){
		System.out.println("*");
	}

	@Test
	public void firstTest(){
		System.out.println(1);
	}

	@Test
	public void secondTest(){
		System.out.println(2);
	}

	@AfterMethod
	public void afterMethod(){
		System.out.println("&");
	}

	@AfterClass
	void afterClass(){
		System.out.println("afterclass");
	}

}
