package monika;

/*Assignment - 3
  Program - 1 : Verify alert message on Registration Page.
  String username = "mkanani";
String password = "mk123";
String expectedMessage = "Failed! please enter strong password";

String username = "maulik.kanani";
String password = "hjp123";
String expectedMessage = "Failed! please enter strong password";

String username = "mkanani";
String password = "mk12312312";
String expectedMessage = "Success!";
  
 */

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class AlertOnLoginPage {
	static WebDriver driver;

	public static WebDriver start() {
		System.out.println("Step : Opening browser.");
		
	
		System.setProperty("webdriver.chrome.driver", "./resources/windows/chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Step : Navigate to automationbykrishna.com.");
		driver.get("http://automationbykrishna.com/");
		System.out.println("Step : Maximize window");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	public static void verifyAlert(String username, String password, String msg) {
		System.out.println("Step : Enter Username");
		WebElement wbEleUsrName = driver.findElement(By.xpath("//input[@id='unameSignin']"));
		wbEleUsrName.clear();
		wbEleUsrName.sendKeys(username);

		System.out.println("Step : Enter Password");
		WebElement wbElePwd = driver.findElement(By.xpath("//input[@id='pwdSignin']"));
		wbElePwd.clear();
		wbElePwd.sendKeys(password);

		System.out.println("Step : Click login button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

		Alert alert = driver.switchTo().alert();
		if (alert.getText().equals(msg))
			System.out.println("Test Passed");
		else
			System.out.println("Test failed");
		alert.accept();
	}

	public static void main(String[] args) {
		start();
		System.out.println("Step : Clicking on Registration tab");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();

		if (driver.findElement(By.xpath("//h1[@class='sign-title' and contains(text(),'Login')]")).isDisplayed()) {
			System.out.println("Navigated to Registration Page");

			System.out.println("Step : 1st time login ");
			verifyAlert("mkanani", "mk123", "Failed! please enter strong password");

			System.out.println("Step : 2nd time login ");
			verifyAlert("maulik.kanani", "hjp123", "Failed! please enter strong password");

			System.out.println("Step : 3rd time login ");
			verifyAlert("mkanani", "mk12312312", "Success!");

		} else
			System.out.println("Page not visible");

		System.out.println("Step : Closing window");
		driver.close();
	}
}


