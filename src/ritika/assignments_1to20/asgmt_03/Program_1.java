package ritika.assignments_1to20.asgmt_03;

//Program - 1 : Verify alert message on Registration Page -> login.

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ritika.base.PredefinedActions;

public class Program_1 {

	static void verifyAlertMsgOnRegistrationPage(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		System.out.println("Step1: Launch page");
		driver.get("http://automationbykrishna.com/");
		System.out.println("Step2: Click on Registration link");
		driver.findElement(By.id("registration2")).click();
		System.out.println("Step3: Click on Submit button of Login form");
		driver.findElement(By.id("btnsubmitdetails")).click();
		System.out.println("Step4: Switch to Alert");
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("This is the Alert text => " + alertText);
		System.out.println("Step5: Accept alert");
		alert.accept();
		System.out.println("Step6: Check if Alert handled?");
		boolean flag = driver.findElement(By.id("btnsubmitdetails")).isEnabled();
		if (flag)
			System.out.println("Alert handled successfully");
	}

	public static void main(String[] args) {

		WebDriver driver = PredefinedActions.start();
		verifyAlertMsgOnRegistrationPage(driver);
		driver.close();
		System.out.println("Browser closed");
		System.out.println("Test Completed");
	}
}
