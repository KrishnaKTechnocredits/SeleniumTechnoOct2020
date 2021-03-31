/*Form: Enable_And_Disable_Display_Hide_Form
Script 1: check element's clickability using explicit wait
Script 2: check element's visibility using explicit wait
*/

package ankita.assignment.assignment14;

import ankita.base.PredefinedActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
	static WebDriver driver = PredefinedActions.start(
			"H:\\JAVA selenium\\Selenium\\SeleniumTechnoOct2020\\resources\\forms\\Enable_And_Disable_&_Display_&_Hide_Form.html");

	public static void explicitWaitTime1() {
		System.out.println("Script 1: check element's clickability using explicit wait\r\n");
		driver.findElement(By.xpath("//button[@onclick='disable()']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id=\"myText\"]")));
	}

	public static void explicitWaitTime2() {
		System.out.println("Script 2: check element's visibility using explicit wait\r\n");
		driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='myDIV']")));
	}

	public static void main(String[] args) {
		// explicitWaitTime1();
		explicitWaitTime2();
		System.out.println("Step : Closing browser");
		driver.close();
	}
}