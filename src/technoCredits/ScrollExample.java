package technoCredits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import technoCredits.base.PredefinedActions;

public class ScrollExample {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.start();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		System.out.println("STEP - click on Basic Elements");
		driver.findElement(By.linkText("Basic Elements")).click();
		
		System.out.println("STEP - Scroll by coordinates");
		/*JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("window.scrollBy(0,250)"); 
		*/
		
		WebElement modalElement = driver.findElement(By.xpath("//a[contains(@class,'btn-success')]"));
		/*JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true);", modalElement);
		*/
		Thread.sleep(3000);
		System.out.println("STEP - click on Form in modal 2");	
		modalElement.click();
		
		System.out.println("STEP - enter email id");
		driver.findElement(By.xpath("//input[@id='inputEmail4']")).sendKeys("kanani.maulik@gmail.com");
	}
}
