package technoCredits.testngExamples.parametersExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertExample {

	@Test
	public void m1() throws InterruptedException {
		int exp = 4;
		int act = 8;

		Assert.assertTrue(4 > 8, "mismatch in title");
		System.out.println("End");
	}
}
