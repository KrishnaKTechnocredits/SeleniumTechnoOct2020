package yogita.Assignment_3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyAlertMsg {
	static WebDriver driver;

	void launchChrome() {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();

		driver.get("http://automationbykrishna.com/");
		System.out.println("AutomationByKrishna website open successfully.");
		driver.manage().window().maximize();

	}

	void verifyAlertMsgOnRegistrationPage(String userName, String password, String expected) {
		System.out.println("STEP-Click On Registration Field");
		driver.findElement(By.id("registration2")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("STEP-Finding UserName field");
		System.out.println("Entering User_Name");
		driver.findElement(By.id("unameSignin")).sendKeys(userName);
		System.out.println("STEP-Finding Password field");
		System.out.println("Entering Password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(password);
		System.out.println("STEP-Finding Log-In field");
		driver.findElement(By.id("btnsubmitdetails")).click();
		System.out.println("STEP-Switching To Alert");
		Alert alert = driver.switchTo().alert();
		System.out.println("STEP-Getting Message");
		String actual = alert.getText();
		System.out.println("Actual Msg is:" + actual);
		System.out.println("STEP-Accepting Alert");
		alert.accept();
		System.out.println("STEP-Veryfying Alert Msg");
		System.out.println("Expected Msg is:" + expected);
		if (expected.equals(actual)) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}

	}

	public static void main(String[] args) throws InterruptedException {

		VerifyAlertMsg verifyMsg = new VerifyAlertMsg();
		verifyMsg.launchChrome();
		String firstAttempt = "yogita";
		String firstPassword = "12345";
		String firstExpected = "Failed! please enter strong password";
		verifyMsg.verifyAlertMsgOnRegistrationPage(firstAttempt, firstPassword, firstExpected);

		String secondAttempt = "anjali";
		String secondPassword = "45678";
		String secondExpected = "Failed! please enter strong password";
		verifyMsg.verifyAlertMsgOnRegistrationPage(secondAttempt, secondPassword, secondExpected);

		String thirdAttempt = "mkanani";
		String thirdPassword = "mk12312312";
		String thirdExpected = "Success!";
		verifyMsg.verifyAlertMsgOnRegistrationPage(thirdAttempt, thirdPassword, thirdExpected);

		System.out.println("Closing Browser");
		driver.close();

	}

}
