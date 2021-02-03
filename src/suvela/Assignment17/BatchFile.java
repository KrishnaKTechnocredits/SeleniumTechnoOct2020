package suvela.Assignment17;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BatchFile {
	@Parameters("browser")
	@Test(priority=1)
	public void openBrowser(String browser) {
		System.out.println("Browser is :" + browser);
		
	}
}
