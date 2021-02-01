package technoCredits.testngExamples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametesExample {

	@Parameters({ "browser", "env" })
	@Test
	public void m1(String browser, String env) {
		System.out.println("ParametesExample m1 : " + browser);
		System.out.println("ParametesExample m1 : " + env);
	}
}
