package deepak.assignment3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import deepak.methods.UtilityMethods;

public class Program2 {

	public static void verifyAlertMessageOnAlert(WebDriver driver) {
		
		String expectedAlertMessage = "You must be TechnoCredits student!!";
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		
		try {
			driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
		}
		catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[@id='javascriptAlert']")));
		  }
		
		Alert alert = driver.switchTo().alert();
		String actualAlertMessage = alert.getText();
		
		if(actualAlertMessage.equals(expectedAlertMessage)) {
			System.out.println("------------Test Pass------------------");
		}
		else
			System.out.println("------------Test Fail------------------");
		alert.accept();
	}
	
	public static void verifyLabelMessageUpanAlertConfirmation(WebDriver driver) {
		
		String expectedText = "You pressed OK!";
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		
		try{
			driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		}catch(Exception e) {
			
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")));
		}
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		String actualText = driver.findElement(By.xpath("//p[text()='You pressed OK!']")).getText();
		
		if(actualText.equals(expectedText)) {
			System.out.println("------------Test Pass---------------");
		}
		else
			System.out.println("------------Test Fail---------------");
	} 
	
	public static void verifyAlertMessageOnJavaScriptPrompt(WebDriver driver) {
		
		String value= "Deepak";
		String message = "Hello "+ value + "! How are you today?";
		
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		
		try{
			driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		}catch(Exception e) {
			
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click()", driver.findElement(By.xpath("//button[@id='javascriptPromp']")));
		}
		
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);
		alert.accept();
		
		WebElement element = driver.findElement(By.xpath("//p[@id='pgraphdemo']"));
		String textAfterAlertAccept = element.getText();
		
		if(textAfterAlertAccept.contains(value) && textAfterAlertAccept.equalsIgnoreCase(message)) {
			
			System.out.println("--------------Test Pass-----------------");
		}
		else
			System.out.println("--------------Test Fail-----------------");
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = UtilityMethods.start();
		
		verifyAlertMessageOnAlert(driver);
		verifyLabelMessageUpanAlertConfirmation(driver);
		verifyAlertMessageOnJavaScriptPrompt(driver);
		driver.close();
	
	}

}
