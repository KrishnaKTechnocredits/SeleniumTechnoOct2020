//2. Double Click on (AutomationByKrishna)
package ankita.assignment.assignment13;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import ankita.base.PredefinedActions;

public class DoubleClick {

	static WebDriver driver = PredefinedActions.start();

	public static void doubleClick() throws InterruptedException {
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

		Actions act = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//a[text()='Double-click on me']"));

		act.doubleClick(element).build().perform();
		Alert alert = driver.switchTo().alert();
		String expectedMsg = "You successfully double clicked it";
		String actualMessage = alert.getText();
		alert.accept();

		if (expectedMsg.equals(actualMessage))
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
	}

	public static void main(String[] args) throws InterruptedException {
		doubleClick();
		System.out.println("Step : closing browser");
		driver.close();
	}
}