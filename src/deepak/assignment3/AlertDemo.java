/*
 * Program - 1 : Verify alert message on Registration Page -> login.
 */
package deepak.assignment3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import deepak.methods.UtilityMethods;

public class AlertDemo {
	
	public static void verifyAlertMessage(WebDriver driver) {
		
		final String successMessage = "Success!";
		
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("Deepak");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("abcdef12345");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		
		//Handling Alert : Alert is a interface
		Alert alert = driver.switchTo().alert();
		String actualAlertMessage = alert.getText();
		alert.accept();
	
		if(actualAlertMessage.equalsIgnoreCase(successMessage)) {
			
			System.out.println("You are logged in successfully : Test Pass ");
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = UtilityMethods.start();
		verifyAlertMessage(driver);
		driver.close();
	}
}
