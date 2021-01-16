package raghvendra.Selenium.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import raghvendra.base.ConstantAction;

public class JavaExecutor1 {
	 static WebDriver driver=ConstantAction.url();
	public static void main(String[] args) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		JavascriptExecutor je=(JavascriptExecutor)driver;
		driver.findElement(By.xpath("//a[contains(@id,'basic')]")).click();
		WebElement element=driver.findElement(By.partialLinkText("Double-click on me"));
		System.out.println(element.getText());
		//driver.findElement(By.xpath("//a[contains(@class,'btn-info')]")).click(); 
		//driver.findElement(By.xpath("//input[@placeholder='placeholder']")).sendKeys("Test");
		//je.executeScript("window.scrollBy(0,950)");
		//argument 0 i current page, argument 1 is page before ciutreent and so on, true is by default in below even if you dont write
		je.executeScript("arguments[0].scrollIntoView(true)", element);
		Actions action = new Actions(driver);
		Thread.sleep(56789);
		action.doubleClick(element).perform();
		driver.findElement(By.partialLinkText("Double-click on me")).click();
		driver.findElement(By.partialLinkText("Double-click on me")).click();

		System.out.println("Scroll by coordinates (down y by 150 )");
	}

}