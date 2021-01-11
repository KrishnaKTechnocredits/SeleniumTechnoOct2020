package milind.assignment_3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VerifyAlertOnRegistrationPage {
	
	WebDriver driver = PredifinedActions.start();
	
	void verifyPasswordFail() {
		System.out.println("STEP : Redirect to Registration Page");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		System.out.println("STEP : Find User name text box field on UI and Clear it");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).clear();
		System.out.println("STEP : Enter User name");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("milindChavhan");
		System.out.println("STEP : Find password textbox on UI and Clear it");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).clear();
		System.out.println("STEP : Enter password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("abcd");
		System.out.println("STEP : Click to login button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		System.out.println("STEP : Switch to alert");
		Alert alert = driver.switchTo().alert();
		System.out.println("STEP : Capture Message From alert");
		String actualAlertMessage = alert.getText();
		String expectedAlertMessage = "Failed! please enter strong password";
		System.out.println("STEP : Verify alert message on wrong password");
		if(actualAlertMessage.equals(expectedAlertMessage)) {
			System.out.println("=====Pass=====");
		}else {
			System.out.println("=====Fail=====");
		}
		System.out.println("STEP : Accept the alert message ");
		alert.accept();
	}
	
	void verifyPasswordFailWith8() {
		System.out.println("STEP : Redirect to Registration Page");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		System.out.println("STEP : Find User name text box field on UI and Clear it");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).clear();
		System.out.println("STEP : Enter User name");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("milindChavhan");
		System.out.println("STEP : Find password textbox on UI and Clear it");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).clear();
		System.out.println("STEP : Enter password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("abcdefgh");
		System.out.println("STEP : Verify entered password length");
		String enteredPassword = driver.findElement(By.xpath("//input[@id='pwdSignin']")).getAttribute("value");
		int enteredPsswordLength = enteredPassword.length();
		if(enteredPsswordLength == 8) {
			System.out.println("Entered password length is 8");
		}else {
			System.out.println("Entered password length is not 8");
		}
		System.out.println("STEP : Click to login button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		System.out.println("STEP : Switch to alert");
		Alert alert = driver.switchTo().alert();
		System.out.println("STEP : Capture Message From alert");
		String actualAlertMessage = alert.getText();
		String expectedAlertMessage = "Failed! please enter strong password";
		System.out.println("STEP : Verify alert message on wrong password");
		if(actualAlertMessage.equals(expectedAlertMessage)) {
			System.out.println("=====Pass=====");
		}else {
			System.out.println("=====Fail=====");
		}
		System.out.println("STEP : Accept the alert message ");
		alert.accept();
	}
	
	void verifyPasswordPass() {
		System.out.println("STEP : Redirect to Registration Page");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		System.out.println("STEP : Find User name text box field on UI and Clear it");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).clear();
		System.out.println("STEP : Enter User name");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("milindChavhan");
		System.out.println("STEP : Find password textbox on UI and Clear it");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).clear();
		System.out.println("STEP : Enter password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("abcdefghi");
		System.out.println("STEP : Verify entered password length");
		String enteredPassword = driver.findElement(By.xpath("//input[@id='pwdSignin']")).getAttribute("value");
		int enteredPsswordLength = enteredPassword.length();
		if(enteredPsswordLength > 8) {
			System.out.println("Entered password length is more than 8");
		}else {
			System.out.println("Entered password length is not more than 8");
		}
		System.out.println("STEP : Click to login button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		System.out.println("STEP : Switch to alert");
		Alert alert = driver.switchTo().alert();
		System.out.println("STEP : Capture Message From alert");
		String actualAlertMessage = alert.getText();
		String expectedAlertMessage = "Success!";
		System.out.println("STEP : Verify alert message on wrong password");
		if(actualAlertMessage.equals(expectedAlertMessage)) {
			System.out.println("=====Pass=====");
		}else {
			System.out.println("=====Fail=====");
		}
		System.out.println("STEP : Accept the alert message ");
		alert.accept();
	}
	
	public static void main(String[] args) {
		VerifyAlertOnRegistrationPage verifyAlertOnRegistrationPage = new VerifyAlertOnRegistrationPage();
		verifyAlertOnRegistrationPage.verifyPasswordFail();
		verifyAlertOnRegistrationPage.verifyPasswordFailWith8();
		verifyAlertOnRegistrationPage.verifyPasswordPass();
		System.out.println("Close Browser");
		verifyAlertOnRegistrationPage.driver.close();
	}

	
}
