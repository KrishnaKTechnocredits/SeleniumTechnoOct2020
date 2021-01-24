package priyanka.Assignment3;

/*Program - 1 : Verify alert message on Registration Page -> login.*/

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	static WebDriver driver;

	public static WebDriver start() {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("AutomationByKrishna website open successfully.");
		return driver;
	}

	public static void validateLogin(String username, String password, String message) {
		System.out.println("Step: Enter username: " + username);
		WebElement elementUsername = driver.findElement(By.id("unameSignin"));
		elementUsername.clear();
		elementUsername.sendKeys(username);
		System.out.println("Step: Enter password: " + password);
		WebElement elementPassword = driver.findElement(By.id("pwdSignin"));
		elementPassword.clear();
		elementPassword.sendKeys(password);
		System.out.println("Step: Click on submit button");
		driver.findElement(By.id("btnsubmitdetails")).click();
		Alert alert = driver.switchTo().alert();
		if (alert.getText().equals(message))
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
		alert.accept();
	}

	public static void main(String[] args) throws InterruptedException {
		try {
			start();
			System.out.println("Step: Clicking on registration link");
			driver.findElement(By.linkText("Registration")).click();
			if (!driver.findElement(By.xpath("//h1[@class='sign-title' and contains(text(),'Login')]")).isDisplayed())
				System.out.println("Login page not visible");
			else {
				System.out.println("Step: Validating first user, username: mkanani, password: mk123");
				validateLogin("mkanani", "mk254", "Failed! please enter strong password");
				System.out.println("\nStep: Validating second user, username: maulik.kanani, password: hjp123");
				validateLogin("maulik.kanani", "mk123", "Failed! please enter strong password");
				System.out.println("\nStep: Validating second user, username: mkanani, password: mk12312312");
				validateLogin("mkanani", "mk12312312", "Success!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
	}

}
