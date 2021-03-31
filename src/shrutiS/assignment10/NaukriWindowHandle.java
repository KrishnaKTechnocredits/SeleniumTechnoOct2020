package shrutiS.assignment10;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class NaukriWindowHandle {
	static WebDriver driver;

	static void login(WebDriver driver) {
		System.out.println("Step1: Getting base window handle");
		String baseWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandle = driver.getWindowHandles();
		for (String window : allWindowHandle) {
			driver.switchTo().window(window);
			if (!window.equals(baseWindowHandle)) {
				System.out.println("Step2: Closing Window " + driver.getTitle());
				driver.close();
			}
		}
		System.out.println("Step3: Back to Main Window ");
		driver.switchTo().window(baseWindowHandle);
		System.out.println("Title of main window : " + driver.getTitle());
		if (driver.getTitle().contains("Naukri.com"))
			System.out.println("Test passed");
		else
			System.out.println("Test Failed");
		driver.close();
	}

	public static void main(String[] args) {
		//driver = LauchBrowser.start("https://www.naukri.com/");
		login(driver);
	}
}
