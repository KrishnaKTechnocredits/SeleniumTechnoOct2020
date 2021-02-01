package technoCredits.testngExamples.assertExamples;

import org.testng.annotations.Test;

public class ExcptionHandle {

	@Test(expectedExceptions = RuntimeException.class)
	public void m1() {
		throw new RuntimeException();
	}

}
