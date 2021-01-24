/*Assignment - 8 : Missing_Link & Multiwindow_Handle
1. Print missing link button text
Note: use missing link form from resources folder
2. Verify that by click on any button on form new window is opening
Note: use Window_Handling Form from resources
*/

package ankita.assignment.assignment8;

import ankita.base.PredefinedActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Set;

public class MissingLinkAndMultihandleWindow {

	public static void printMissingLinkButton(WebDriver driver) {
		System.out.println("Program 1");
		System.out.println("Step : Print missing Link");
		List<WebElement> listOfLinks = driver.findElements(By.xpath("//a"));
		for (WebElement element : listOfLinks) {
			if (element.getAttribute("href") == null || element.getAttribute("href").length() == 0)
				System.out.println(element.getText());
		}
	}

	public static void handleWindow(WebDriver driver) {
		System.out.println("Program 2");
		System.out.println("Step : Verify that by click on any button on form new window is opening");

		driver.get("H:\\JAVA selenium\\Selenium\\SeleniumTechnoOct2020\\resources\\forms\\Window_Handling_Form.html");
		String windowHandle = driver.getWindowHandle();

		driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("windows open : " + windowHandles);

		if (windowHandles.size() > 1) {
			for (String handle : windowHandles) {
				if (!handle.equals(windowHandle)) {
					System.out.println("Opened this window : " + handle);
					driver.switchTo().window(handle);
					driver.close();
				}
			}
			driver.switchTo().window(windowHandle);
			System.out.println("Test passed");
		} else
			System.out.println("Test Failed");
	}

	public static void main(String[] args) {
		WebDriver driver = PredefinedActions
				.start("H:\\JAVA selenium\\Selenium\\SeleniumTechnoOct2020\\resources\\forms\\MissingLink.html");
		printMissingLinkButton(driver);
		handleWindow(driver);
		System.out.println("Step : Closing Browser");
		driver.close();
	}
}