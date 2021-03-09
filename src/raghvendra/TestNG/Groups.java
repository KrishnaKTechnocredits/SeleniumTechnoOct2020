package raghvendra.TestNG;

import org.testng.annotations.Test;

public class Groups {

	@Test (groups={"Smoke","Sanity"})
	void m1() {
		System.out.println("Grooup m1");
	}
	
	@Test(groups="regression")
	void m2() {
		System.out.println("Grooup m2");
	}
	
	@Test(groups="regression")
	void m3() {
		System.out.println("Grooup m3");
	}
}
