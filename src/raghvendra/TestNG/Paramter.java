package raghvendra.TestNG;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Paramter {
	
	@Parameters("browser")
	@Test
	void m1(@Optional("chrome") String  browser) {
		System.out.println("Browser name:"+browser);
	}

	
}
