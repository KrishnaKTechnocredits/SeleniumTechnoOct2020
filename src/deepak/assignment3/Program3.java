package deepak.assignment3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import deepak.methods.UtilityMethods;

public class Program3 {
	
	static String userFirstName = "Deepak";
	static String userLastName = "Latad";
	static String userCompanyName = "Digital River";
	static String expectedAlertMessage = userFirstName + " and "+ userLastName + " and "+ userCompanyName;
	
	public static void verifyAlertMessage(WebDriver driver) {
		
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys(userFirstName);
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys(userLastName);
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys(userCompanyName);
		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();
		
		Alert alert = driver.switchTo().alert();
		String alerMessage = alert.getText();
		
		if(alerMessage.equalsIgnoreCase(expectedAlertMessage)) {
			alert.accept();
			System.out.println("----------Test Pass--------------");
		}
		else {
			alert.dismiss();
			System.out.println("----------Test Fail--------------");
		}
	}
	
	public static void main(String[] args) {
	
		WebDriver driver = UtilityMethods.start();
		verifyAlertMessage(driver);
		driver.close();
	}
}
