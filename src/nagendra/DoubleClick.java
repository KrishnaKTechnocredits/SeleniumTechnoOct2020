package nagendra;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import nagendra.base.PredefinedActions;
/*
2. Double Click on (AutomationByKrishna)
*/

public class DoubleClick {

	static WebDriver driver;

	public static void performDoubleClickOperation() {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.id("basicelements")).click();
		System.out.println("STEP - Sroll down till element");
		JavascriptExecutor ja = (JavascriptExecutor) driver;
		ja.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		System.out.println("STEP - Identify The Locator");
		WebElement element = driver.findElement(By.xpath("//a[text()='Double-click on me']"));
		System.out.println("STEP - Perform Double Click Operation");
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
		
	}

	public static void main(String[] args) {
		System.out.println("STEP - Initialize WebDriver ");
		driver = PredefinedActions.start("http://automationbykrishna.com/index.html#");
		performDoubleClickOperation();
		System.out.println("STEP - Close The Driver");
		driver.close();
		System.out.println("STEP - Test Case Passed!!");
	}
}
