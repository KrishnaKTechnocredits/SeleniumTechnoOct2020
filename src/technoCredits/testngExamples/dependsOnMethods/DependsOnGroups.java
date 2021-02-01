package technoCredits.testngExamples.dependsOnMethods;

import org.testng.annotations.Test;

public class DependsOnGroups {

	@Test(groups = "smoke")
	public void m1() {
		System.out.println("smoke m1");
	}

	@Test(groups = { "regression", "sanity" })
	public void m2() {
		System.out.println("regression m2");
	}

	@Test(groups = "sanity")
	public void m3() {
		System.out.println("sanity m3");
	}

}
