package technoCredits.testngExamples.dependsOnMethods;

import org.testng.annotations.Test;

public class Example1 {

	@Test(alwaysRun = true, dependsOnMethods = "m2")
	public void m1() {
		System.out.println("smoke m1");
	}

	@Test()
	public void m2() {
		throw new RuntimeException();
	}

}
