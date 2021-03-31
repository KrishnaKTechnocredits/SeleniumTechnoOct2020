package suresh;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickExample {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://automationbykrishna.com/#");
		driver.findElement(By.id("basicelements")).click();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		WebElement data = driver.findElement(By.xpath("//div[@class='form-group']/a"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", data);
		Actions action = new Actions(driver);
		action.doubleClick(data).perform();
		Alert alert = driver.switchTo().alert();
		
		System.out.println("Alert Text:\n" +alert.getText());
		alert.accept();
		driver.quit();
	}
}
