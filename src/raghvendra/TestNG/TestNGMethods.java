package raghvendra.TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGMethods {
	
	@Test(dependsOnMethods= {"m2","m3"})
	void m1() {
		System.out.println("Its m1");
	}
	
	@Test (dependsOnMethods= {"m3"})
	void m2() {
		System.out.println("its m2");
	}
	
	@Test 
	void m3() {
		System.out.println("its m3");
	}
	
	@Test (alwaysRun=true)
	void m4() {
		System.out.println("its m4");
	}
	@Test (enabled=false)
	void m5() {
		System.out.println("its m5");
	}
	
	@Parameters({ "browser" })
	@Test(enabled=true)
	void m6(String browser) {
		System.out.println("its m6"+browser);
	}
}
