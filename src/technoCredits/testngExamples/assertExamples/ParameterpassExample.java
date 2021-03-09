package technoCredits.testngExamples.assertExamples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterpassExample {

	@Parameters("browser")
	@Test
	public void openBrowser(String v1) {
		System.out.println(v1);
	}
}
