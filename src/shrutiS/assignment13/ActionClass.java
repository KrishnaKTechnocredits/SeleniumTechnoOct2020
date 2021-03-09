
/*Assignment - 13 Actions class methods to perform
1. Drag And Drop on (https://demos.telerik.com/kendo-ui/dragdrop/index)
2. Double Click on (AutomationByKrishna)
3. Mouse hover on Amazon(Verify how many links available under Account & Lists)
*/
package shrutiS.assignment13;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import shrutiS.util.LaunchBrowser;

public class ActionClass {
	static WebDriver driver;

	public void performDragAndDrop(String message) {
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		System.out.println("Find Traget element");
		WebElement target = driver.findElement(By.id("droptarget"));
		System.out.println("Scroll to source element");
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,250)");
		System.out.println("Find source element");
		WebElement source = driver.findElement(By.id("draggable"));
		Actions action = new Actions(driver);
		System.out.println("Dropped source element to target");
		action.dragAndDrop(source, target).build().perform();
		System.out.println(target.getText());
		if (message.equals(target.getText()))
			System.out.println("Test Pass");
		else
			System.out.println("Test Fail");

	}

	public void performDoubleClickAction() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		driver.get("http://automationbykrishna.com/");
		System.out.println("Navigate to AutomationByKrishna and click on basic Element link");
		driver.findElement(By.id("basicelements")).click();
		System.out.println("Scroll tp bottom of page");
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Actions action = new Actions(driver);
		System.out.println("Find element 'Double-click on me' and click on it ");
		WebElement link = driver.findElement(By.xpath("//a[text()=\"Double-click on me\"]"));
		System.out.println(link.getText());
		action.doubleClick(link).build().perform();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		if (alert.getText().equals("You successfully double clicked it")) {
			System.out.println("Test Passed");
			alert.accept();
		} else
			System.out.println("Test Failed");
	}

	public static void findLinks() {
		driver.get("https://www.snapdeal.com/");
		System.out.println("Navigate to snapdeal website ");
		System.out.println("Step: Hover on 'All Offers'");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[text()='All Offers']")));
		System.out.println("Step: Count number of links under 'All Offers'");
		System.out.println(driver.findElements(By.cssSelector("#category1Data .linkTest")).size());
	}

	public static void main(String[] args) throws InterruptedException {
		driver = LaunchBrowser.start("https://demos.telerik.com/kendo-ui/dragdrop/index");
		ActionClass action = new ActionClass();
		action.performDragAndDrop("You did great!");
		action.performDoubleClickAction();
		action.findLinks();
	}
}
