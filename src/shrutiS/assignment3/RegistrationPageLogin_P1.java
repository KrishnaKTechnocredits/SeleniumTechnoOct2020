/*Assignment - 3 : 
Program - 1 : Verify alert message on Registration Page -> login.*/

package shrutiS.assignment3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationPageLogin_P1 {

	private static WebDriver driver;

	public static WebDriver start() {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		System.out.println("AutomationByKrishna website open successfully");
		return driver;
	}

	public void checkAlert(String userName, String password, String message) {
		String message2 = "Success!";
		System.out.println("Step3: Enter username: " + userName);
		WebElement elementUsername = driver.findElement(By.id("unameSignin"));
		elementUsername.sendKeys(userName);
		System.out.println("Step4: Enter password: " + password);
		WebElement elementPassword = driver.findElement(By.id("pwdSignin"));
		elementPassword.sendKeys(password);
		System.out.println("Step5: Click on submit button");
		driver.findElement(By.id("btnsubmitdetails")).click();
		Alert alert = driver.switchTo().alert();
		if (alert.getText().equals(message))
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
		alert.accept();
	}

	public static void main(String[] args) {
		RegistrationPageLogin_P1 pageLogin = new RegistrationPageLogin_P1();
		System.out.println("Browser opening and navigate to automationbykrishna.com");
		start();
		System.out.println("Step1: Clicking on registration link");
		driver.findElement(By.xpath("//a[contains(text(),'Registration')]")).click();
		System.out.println("Step2: Validating first user, username: ShrutiS, password: 123");
		pageLogin.checkAlert("ShrutiS", "123", "Failed! please enter strong password");
		System.out.println("Step2: Validating first user, username: ShrutiS, password: ShrutiS1234");
		pageLogin.checkAlert("ShrutiS", "ShrutiS1234", "Success!");
	}
}
