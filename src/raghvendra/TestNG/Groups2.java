package raghvendra.TestNG;

import org.testng.annotations.Test;

public class Groups2 {

	@Test (alwaysRun=true, dependsOnMethods="m2")
	void m1() {
		System.out.println("Grooup m1");
	}
	
	@Test(groups="Smoke")
	void m2() {
		throw new RuntimeException();
	}
}
