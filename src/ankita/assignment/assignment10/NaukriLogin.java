/*Assignment : 10
1. Open Naukri.com website
2. Close all other windows apart from main window.
3. Switch to main window in the end.
Hint : find main window by title.*/

package ankita.assignment.assignment10;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ankita.base.PredefinedActions;

public class NaukriLogin {
	static void login(WebDriver driver) {
		System.out.println("Step : Getting base window handle");
		String baseWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandle = driver.getWindowHandles();
		for (String window : allWindowHandle) {
			driver.switchTo().window(window);
			if (!window.equals(baseWindowHandle)) {
				System.out.println("Step : Closing Window " + driver.getTitle());
				driver.close();
			}
		}
		System.out.println("Step : Back to Main Window ");
		driver.switchTo().window(baseWindowHandle);
		System.out.println("Title of main window : " + driver.getTitle());
		if (driver.getTitle().contains("Naukri.com"))
			System.out.println("Test passed");
		else
			System.out.println("Test Failed");
	}

	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start("https://www.naukri.com/");
		login(driver);
		System.out.println("Step : Closing Browser");
		driver.close();
	}
}