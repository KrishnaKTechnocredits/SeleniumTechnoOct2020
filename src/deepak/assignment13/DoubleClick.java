/*
 * Assignment - 13 Actions class methods to perform
1. Drag And Drop on (https://demos.telerik.com/kendo-ui/dragdrop/index)
2. Double Click on (AutomationByKrishna)
3. Mouse hover on Amazon(Verify how many links available under Account & Lists)
 */

package deepak.assignment13;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import deepak.methods.UtilityMethods;

public class DoubleClick {
	
	static WebDriver driver;
	
	public static void DoubleClickDemo() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
		//Step1: Click on Basic Elements
		System.out.println("Step1: Click on Basic Elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		
		//Step2: Scrolling till bottom of the page
		System.out.println("Step2: Scrolling till bottom of the page");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
		//Step3: Find the web element on which you have to perform mouse action
		System.out.println("Step3: Find the web element on which you have to perform mouse action");
		WebElement link = driver.findElement(By.xpath("//a[text()='Double-click on me']"));
		
		//Step4: Use action class to double click
		Actions action = new Actions(driver);
		action.doubleClick(link).build().perform();
		
		System.out.println("--DOUBLE CLICK DONE--");
		
		//Step5: Verify Double click successful 
		System.out.println("Step5: Verify Double click successful");
		
		String expectedAlertMsg = "You successfully double clicked it";
		Alert alert = driver.switchTo().alert();
		String alertTxt = alert.getText();
		alert.accept();
		if(alertTxt.equals(expectedAlertMsg)) {
			
			System.out.println("--------Test Pass-----------");
		}
		else
			System.out.println("--------Test Fail-----------");	
	}

	public static void main(String[] args) throws InterruptedException {
		
		driver = UtilityMethods.start();
		DoubleClickDemo();
		driver.close();
	}
}
