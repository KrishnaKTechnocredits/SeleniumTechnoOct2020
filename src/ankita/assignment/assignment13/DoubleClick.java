//2. Double Click on (AutomationByKrishna)
package ankita.assignment.assignment13;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import ankita.base.PredefinedActions;

public class DoubleClick {

	public static void doubleClick() throws InterruptedException {
		}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.start();

		driver.findElement(By.id("basicelements")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//a[text()='Double-click on me']"));

		act.doubleClick(element).build().perform();

	}
}