package ankita.practice;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Ex1 {
	@Parameters({"browser", "env"})
	@Test(enabled = true)
	public void assertNotEquals(@Optional("FF")String v , @Optional("test") String va) {
	System.out.println("Browser : " + v + " _" + va);
	}
}
