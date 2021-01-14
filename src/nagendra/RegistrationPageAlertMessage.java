package nagendra;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import nagendra.base.PredefinedActions;

/*
Program - 1 : Verify alert message on Registration Page -> login.
*/

public class RegistrationPageAlertMessage {

	static void verifyRegistrationPageAlertMessage(WebDriver driver) {
		System.out.println("STEP - Applied implicit wait to driver instance");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		System.out.println("STEP -Click on Registration Page ");
		driver.findElement(By.xpath("//a[text()='Registration']")).click();
		System.out.println("STEP -Enter User Name");
		WebElement userName=driver.findElement(By.xpath("//input[@id='unameSignin']"));
		userName.sendKeys("Test123");
		System.out.println("STEP -Enter Password");
		WebElement password=driver.findElement(By.xpath("//input[@id='pwdSignin']"));
		password.sendKeys("Test123");
		System.out.println("STEP -Click on Right Button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		System.out.println("STEP -Switch to Alert");
		Alert alert = driver.switchTo().alert();
		System.out.println("STEP -Get the text from Alert");
		String alertMessage = alert.getText();
		System.out.println("----" + alertMessage);
		String expectedAlertMessage = "Failed! please enter strong password";
		System.out.println("STEP -Accept the Alert");
		alert.accept();
		if (alertMessage.equals(expectedAlertMessage)) {
			System.out.println("PASSED ---->The Alert message Matces with the expected Alert");
		} else {
			System.out.println("FAILED ---->The Alert message Does Not  Matche with the expected Alert");
		}
	}

	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start();
		verifyRegistrationPageAlertMessage(driver);
		driver.close();
		System.out.println("Browser is Closed");
	}

}
