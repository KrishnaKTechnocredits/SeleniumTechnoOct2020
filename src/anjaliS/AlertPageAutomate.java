package anjaliS;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPageAutomate {
	static WebDriver driver;

	void start() {
		String browsePath = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", browsePath);
		driver = new ChromeDriver();
		System.out.println("Chrome browser opened");
		driver.manage().window().maximize();
		System.out.println("browser maximized");
		driver.get("http://automationbykrishna.com");
		System.out.println("Redirect to automationLearning webPage");
	}

	void alertPage(String userName, String Password, String expectedOutput) throws InterruptedException {

		driver.findElement(By.id("registration2")).click();
		System.out.println("Switched to registration page,post clicking its tab");
		Thread.sleep(5000);

		driver.findElement(By.id("unameSignin")).sendKeys(userName);
		System.out.println("UserName entered:" +userName);
		Thread.sleep(5000);

		driver.findElement(By.id("pwdSignin")).sendKeys(Password);
		System.out.println("Passwrd entered: " +Password);

		driver.findElement(By.id("btnsubmitdetails")).click();

		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		Thread.sleep(5000);
		String actualOutput = alert.getText();
		Thread.sleep(5000);
		alert.accept();
		if (actualOutput.equals(expectedOutput)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		AlertPageAutomate alerthandle = new AlertPageAutomate();
		alerthandle.start();

		String username1 = "Anjalis";
		String Psswrd1 = "anj44252";
		String ExpectedOutput1 = "Failed! please enter strong password";
		alerthandle.alertPage(username1, Psswrd1, ExpectedOutput1);

		String username2 = "Vivek10";
		String Psswrd2 = "athar123";
		String ExpectedOutput2 = "Failed! please enter strong password";
		alerthandle.alertPage(username2, Psswrd2, ExpectedOutput2);

		String username3 = "mkanani";
		String Psswrd3 = "mk12312312";
		String ExpectedOutput3 = "Success!";
		alerthandle.alertPage(username3, Psswrd3, ExpectedOutput3);

		driver.quit();

	}

}
