package technoCredits.testngExamples.parametersExamples;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Example1 {

	@Parameters({ "browser" })
	@Test
	public void m1(@Optional("chrome") String v1) {
		System.out.println(v1);
	}
}
