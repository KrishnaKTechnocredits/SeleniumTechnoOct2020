/*
 * Program 3-Drag And Drop on (https://demos.telerik.com/kendo-ui/dragdrop/index)
 */

package yogita.Assignment_13;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DranAndDropAction {
	static WebDriver driver;

	static void launchBrowser() {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("Website open successfully.");
		driver.manage().window().maximize();
	}

	static void performDranAndDrop() {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,200)");

		System.out.println("STEP-Finding Draggable Element");
		WebElement dragElement = driver.findElement(By.xpath("//div[@data-role='draggable']"));
		System.out.println("STEP-Finding Target Element");
		WebElement targetElement = driver.findElement(By.xpath("//div[text()='Drag the small circle here.']"));

		System.out.println("STEP-Perform Drag & Drop Action");
		Actions action = new Actions(driver);
		action.dragAndDrop(dragElement, targetElement).build().perform();
	}

	public static void main(String[] args) {
		DranAndDropAction.launchBrowser();
		DranAndDropAction.performDranAndDrop();
		System.out.println("STEP-Closing Browser");
		driver.close();
	}

}
