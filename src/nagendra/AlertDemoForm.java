package nagendra;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import nagendra.base.PredefinedActions;

/*
Program - 3 : Go to Basic element page,
a) verify alert message on "Alert demo" form.
*/

public class AlertDemoForm {

	static void verifyAlertDemoFormMessage(WebDriver driver) {

		System.out.println("STEP - Applied implicit wait to driver instance");
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		System.out.println("STEP -Click on Basic Elements  Page ");
		driver.findElement(By.xpath("//a[text()='Basic Elements']")).click();
		System.out.println("STEP -Input First User Name");
		driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys("Nagendra");
		System.out.println("STEP -Input Last Name");
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys("Tiwari");
		System.out.println("STEP -Input Last Name");
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys("TCS");
		System.out.println("STEP -Click on Submit Button");
		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println("STEP -Get The Input Box Message");
		String message = alert.getText();
		System.out.println("-->"+message);
		String expectedMessage = "Nagendra and Tiwari and TCS";
		System.out.println("STEP -Accept the Alert");
		alert.dismiss();
		if (message.equals(expectedMessage)) {
			System.out.println("PASSED - Test Case Is Passed");
		} else {
			System.out.println("FAILED - Test Case Is FAILED");
		}
	}

	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start();
		verifyAlertDemoFormMessage(driver);
		driver.close();
		System.out.println("Browser is Closed");

	}

}
