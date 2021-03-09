/*Program-1: Verify Alert Message on Registration Page.*/
package kajol.assignment3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyAlert {
	static WebDriver driver;
	public static void verifyAlertMessage(String userName, String password,String expectedmsg) {
		System.out.println("Verifying Alert Message.......");
		System.out.println("Enter Username");
		WebElement nameElement=driver.findElement(By.xpath("//input[@id='unameSignin']"));//By.id("unameSignin");
		nameElement.clear();
		nameElement.sendKeys(userName);
		
		System.out.println("Enter Password");
		WebElement passwordElement=driver.findElement(By.id("pwdSignin"));//By.xpath("//input[@id='pwdSignin']")
		passwordElement.clear();
		passwordElement.sendKeys(password);
		
		System.out.println("Click on Login");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		
		Alert alert=driver.switchTo().alert();
		if(alert.getText().equals(expectedmsg)) {
			System.out.println("Expected Result matches with Actual result");
			System.out.println("Test Passed");
		}
		else {
			System.out.println("Expected Result does not match with Actual result");
			System.out.println("Test Failed");
		}
		alert.accept();	
	}
	
	public static void main(String[] args) {
		System.out.println("Opening Browser.");
		//driver=DriverMethods.start();
		System.out.println("1. Click on  Registration ");
		driver.findElement(By.xpath("//a[@id='registration2']")).click(); //driver.findElement(By.linkText("Registration")).click();
		if (driver.findElement(By.xpath("//h1[@class='sign-title' and contains(text(),'Login')]")).isDisplayed()) {
			System.out.println("2. Navigated to Login Page");
			System.out.println();
			System.out.println("Validating TEST 1: ");
			verifyAlertMessage("mkanani", "m123", "Failed! please enter strong password");
			System.out.println();
			System.out.println("Validating TEST 2: ");
			verifyAlertMessage("maulik.kanani", "hjp123", "Failed! please enter strong password");
			System.out.println();
			System.out.println("Validating TEST 3: ");
			verifyAlertMessage("mkanani", "mk12312312", "Success!");			
		}
		else {
			System.out.println("Login Page is not Visible...Try Again");
		}
		driver.close();
		System.out.println();
		System.out.println("Browser Closed.");
	}
}
