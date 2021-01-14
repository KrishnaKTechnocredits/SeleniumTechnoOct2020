package anjaliS;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class verifyAlertJavaScript {
	WebDriver driver;

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

	void alertMessage(String expectedOutput) throws InterruptedException {

		driver.findElement(By.id("basicelements")).click();
		System.out.println("Switched to basic element screen,post clicking its tab");
		Thread.sleep(5000);

		driver.findElement(By.id("javascriptConfirmBox")).click();
		System.out.println("Clicked on javascript Confirmation tab ");

		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		Thread.sleep(5000);
		String actualOutput = alert.getText();
		Thread.sleep(5000);
		alert.accept();

		if (expectedOutput.equals(actualOutput))
			System.out.println("TestCase Passed");
		else
			System.out.println("Test case Failed");
	}

	public static void main(String[] args) throws InterruptedException {
		verifyAlertJavaScript al = new verifyAlertJavaScript();
		al.start();
		al.alertMessage("Are you are doing your homework regularly, Press Okay else Cancel!!");

	}
}
