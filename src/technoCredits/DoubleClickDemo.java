package technoCredits;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import technoCredits.base.PredefinedActions;

public class DoubleClickDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.start();

		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
		Actions act = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//a[text()='Double-click on me']"));

		act.doubleClick(ele).build().perform();
	}
}
