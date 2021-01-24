/*
  Program 1
 Open Naukri.com website
 Close all other windows apart from main window.
 Switch to main window in the end.
Hint : find main window by title.
 */

package yogita.Assignment_10;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiWindowClosing {
	static WebDriver driver;

	static void launchBrowser() {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		System.out.println("STEP-Go to Naukri.com");
		driver.get("https://www.naukri.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Website open successfully.");
		driver.manage().window().maximize();

	}

	static void closingMultiWindow() {
		System.out.println("STEP-Finding Main Window");
		String mainWindow = driver.getWindowHandle();
		String mainWindowTitle = driver.getTitle();
		Set<String> listOfWindow = driver.getWindowHandles();
		System.out.println("STEP-Closing Other windows apart from main window");
		for (String window : listOfWindow) {
			if (!(mainWindow.equals(window))) {
				driver.switchTo().window(window);
				System.out.println("Title of closing window: " + driver.getTitle());
				driver.close();
			}
		}
		System.out.println("STEP-Switch to main window");
		driver.switchTo().window(mainWindow);
		System.out.println("STEP-Get Title Of Main Window");
		String titleAfterSwitch = driver.getTitle();
		if (mainWindowTitle.equals(titleAfterSwitch))
			System.out.println("Testcase Passed");
		else
			System.out.println("Testcase Failed");
	}

	public static void main(String[] args) {
		MultiWindowClosing.launchBrowser();
		MultiWindowClosing.closingMultiWindow();
		driver.close();

	}
}
