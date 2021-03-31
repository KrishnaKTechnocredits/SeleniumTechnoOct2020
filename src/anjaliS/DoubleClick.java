package anjaliS;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DoubleClick {

	static WebDriver driver;

	void doubleClick() throws InterruptedException {

		System.out.println("Automationbykrishna link opened successfully");
		driver.get("http://automationbykrishna.com/");

		System.out.println("Click on basic elements tab");
		driver.findElement(By.id("basicelements")).click();

		Thread.sleep(3000);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollTo(0,document.body.scrollHeight)");

		Actions actions = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//a[text()='Double-click on me']"));

		actions.doubleClick(ele).build().perform();
	}

	public static void main(String[] args) throws InterruptedException {
		//driver = Driver.start();
		DoubleClick dc = new DoubleClick();
		dc.doubleClick();
	}

}
