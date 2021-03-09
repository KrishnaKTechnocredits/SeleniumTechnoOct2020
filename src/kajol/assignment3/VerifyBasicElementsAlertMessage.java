/*Program-2: 
 Go to Basic Elements Page, 
 	a) verify alert message on Alert button.
	b) verify label message on JavaScript Confirmation button
	c) verify label message on JavaScript prompt button
*/

package kajol.assignment3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import kajol.predefinedMethods.DriverMethods;

public class VerifyBasicElementsAlertMessage {
	
	static WebDriver driver;
	
	public static void verfiyAlert(String expectedMsg) {
		System.out.println("1.Click on Alert Button");
		driver.findElement(By.id("javascriptAlert")).click();
		System.out.println("2.Validate Alert Message");
		Alert alert=driver.switchTo().alert();
		if(alert.getText().equals(expectedMsg))
			System.out.println("Test Passed....Displayed Message: "+expectedMsg);
		else
			System.out.println("Test Failed");
		alert.accept();
		
	}
	
	public static void verifyJavaScriptConfirmation(String expectedConfirmationMsg) {
		System.out.println("1. Click on JavaScript Confirmation Button");
		driver.findElement(By.id("javascriptConfirmBox")).click();
		System.out.println("2. Click on OK or Cancel");
		Alert alert=driver.switchTo().alert();
		if(expectedConfirmationMsg.contains("OK"))
			alert.accept();
		else if (expectedConfirmationMsg.contains("Cancel"))
			alert.dismiss();
		if(driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText().equals(expectedConfirmationMsg))
		System.out.println("Test Passed....."+expectedConfirmationMsg);
		else
		System.out.println("Test Failed");	
	}
	
	public static void verifyJavaScriptPrompt(String name ) {
		System.out.println("1. Click on JavaScript Prompt Button");
		driver.findElement(By.id("javascriptPromp")).click();
		Alert alert=driver.switchTo().alert();
		System.out.println("2.Enter name in alert text Box");
		alert.sendKeys(name);
		alert.accept();
		if(driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText().contains(name))
			System.out.println("Test Passed....Displayed Message Contains your name "+name);
		else
			System.out.println("Test Failed");	
	}
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Opening Browser");
		driver=DriverMethods.start();
		System.out.println("Click on Basic Elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)");
		System.out.println();
		
		System.out.println("Test 1: Verify Alert");
		verfiyAlert("You must be TechnoCredits student!!");
		System.out.println();
		
		System.out.println("Test 2: Verify JavaScript Confirmation");
		verifyJavaScriptConfirmation("You pressed OK!");
		verifyJavaScriptConfirmation("You pressed Cancel!");
		System.out.println();
		
		System.out.println("Test 3: Verify JavaScript Prompt");
		verifyJavaScriptPrompt("Kajol");
		driver.close();	
		System.out.println("Browser Closed");
	}
}
