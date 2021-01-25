package anjaliS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomateWithExplicitWait {

	static WebDriver driver;

	void explicitWait1() {

		try {

			System.out.println("Step 1:Enable_And_Disable web page opened successfully");
			driver.get(
					"file:///C:/Users/anjal/SeleniumTechnoOct2020/resources/forms/Enable_And_Disable_%26_Display_%26_Hide_Form.html");

			System.out.println("First method: Check element's clickability using explicit wait");
			driver.findElement(By.xpath("//button[@onclick='disable()']")).click();
			WebDriverWait wait1 = new WebDriverWait(driver, 3);
			wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id=\"myText\"]")));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		driver = Driver.start();
		AutomateWithExplicitWait wait = new AutomateWithExplicitWait();
		wait.explicitWait1();

	}
}
