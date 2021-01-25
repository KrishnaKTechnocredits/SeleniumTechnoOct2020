package nagendra;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import nagendra.base.PredefinedActions;

/*
 Assignment : 10
1. Open Naukri.com website
2. Close all other windows apart from main window.
3. Switch to main window in the end.
Hint : find main window by title.
*/
public class MultipleWindowHandle {

	public static WebDriver driver;
	
	public static void verifyMainWndow(){
		System.out.println("STEP: Store Parent Window Title");
		String parentWindow = driver.getWindowHandle();
		Set<String> totalWindows = driver.getWindowHandles();
		System.out.println("STEP: Close All Window ");

		for (String window : totalWindows) {
			driver.switchTo().window(window);
			if (!window.equals(parentWindow)) {
				driver.close();
			}
		}
		System.out.println("STEP: Back to Main Window ");
		driver.switchTo().window(parentWindow);
		System.out.println("Title of main window : " + driver.getTitle());
		if (driver.getTitle().contains("Naukri.com"))
			System.out.println("Passed ");
		else
			System.out.println("Failed");
	}

	public static void main(String[] args) {
		System.out.println("STEP - Initlize The Driver");
		driver = PredefinedActions.start("https://www.naukri.com/");
		verifyMainWndow();
		System.out.println("STEP - Close the driver");
		driver.close();
		System.out.println("STEP - Test Completed");
	}

}
