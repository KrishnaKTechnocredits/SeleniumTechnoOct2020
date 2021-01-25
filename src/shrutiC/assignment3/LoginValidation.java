package shrutiC.assignment3;

import java.util.Scanner;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginValidation {

	static WebDriver driver;

	static void startWebDriver() {

		String path = "./resources/windows/chromedriver.exe";
		System.out.println("STEP - open chrome browser");
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.automationbykrishna.com");
	}

	void verifyUserRegistration(String username, String password, String alertMessage) throws InterruptedException {

		System.out.println("Click on registration tab");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		Thread.sleep(2000);

		// Enter Login details
		System.out.println("Enter user details");
		System.out.println("Username - " + username);
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys(username);
		System.out.println("Password - " + password);
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(password);

		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		validateAlertMsg(alertMessage);

	}

	void validateAlertMsg(String expectedMsg) {

		Alert alert = driver.switchTo().alert();
		String alertMsg = alert.getText();

		if (alertMsg.equals(expectedMsg))
			System.out.println("Validation successful - " + alertMsg);
		else
			System.out.println(
					"Validation failed | Expected message : " + expectedMsg + " | Actual message : " + alertMsg);

		alert.accept();

	}

	public static void main(String[] args) {
		try {
			LoginValidation object = new LoginValidation();
			startWebDriver();
			object.verifyUserRegistration("shruti", "abc", "Failed! please enter strong password");
			System.out.println("***************************************************************************");
			object.verifyUserRegistration("ShrutiC", "abc@123456789", "Success!");
			System.out.println("***************************************************************************");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}

}
