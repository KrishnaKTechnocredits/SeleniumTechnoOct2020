package prasad;
/*Assignment 14

Form: Enable_And_Disable_Display_Hide_Form

Script 1: check element's clickability using explicit wait
Script 2: check element's visibility using explicit wait
*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
	static WebDriver driver;

	void validateWait() {
		System.out.println("Step 1: Checking element's clickability using explicit wait");
		System.out.println("Clicked on Enable & Disable button to disable input text box");
		driver.findElement(By.xpath("//button[text()='Enable & Disable Button']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 3);
		try {
			System.out.println("In try block, waiting for input text box to become clickable");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='myText']"))).click();
		} catch (Exception te) {
			System.out.println("In catch block printing error msg:- ");
			String msg = te.getMessage();
			System.out.println("");
			System.out.println(msg);
		} finally {
			System.out.println("");
			System.out.println("Step 2: Check element's visibility using explicit wait");
			System.out.println("Clicked on button to hide text in the panel");
			driver.findElement(By.xpath("//button[text()='Visiable & Hidden Button']")).click();
			WebElement element = driver.findElement(By.xpath("//div[@id='myDIV']"));
			try {
				System.out.println("In try block, waiting for panel text to become visible");
				wait.until(ExpectedConditions.visibilityOf(element));
			} catch (Exception ee) {
				System.out.println("In catch block printing error msg:- ");
				String msg = ee.getMessage();
				System.out.println("");
				System.out.println(msg);
			}
		}
	}

	public static void main(String[] arg) {
		ExplicitWait eWait = new ExplicitWait();
		driver = StaticResources.start(
				"file:///C:/Users/Prasad%20Chitale/Documents/java_selenium/SeleniumTechnoOct2020/resources/forms/Enable_And_Disable_%26_Display_%26_Hide_Form.html");
		eWait.validateWait();
	}

}
