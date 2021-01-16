package anjaliS;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyBasicElemAlertDemo {
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

	void alertPage(String firstName, String lastName, String companyName) throws InterruptedException {

		driver.findElement(By.id("basicelements")).click();
		System.out.println("Switched to basic element screen,post clicking its tab");
		Thread.sleep(5000);

		driver.findElement(By.id("UserFirstName")).sendKeys(firstName);
		System.out.println("FirstName entered: " +firstName);
		Thread.sleep(5000);

		driver.findElement(By.id("UserLastName")).sendKeys(lastName);
		System.out.println("LastName entered: " +lastName);

		driver.findElement(By.id("UserCompanyName")).sendKeys(companyName);
		;
		System.out.println("Companyname entered: " +companyName);

		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("Clicked on submit button");

		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		Thread.sleep(5000);
		String actualOutput = alert.getText();
		Thread.sleep(5000);
		alert.accept();
		if (actualOutput.equals(firstName + " and " + lastName + " and " + companyName)) {
			System.out.println("TestCase Passed");
		} else {
			System.out.println("TestCase Failed");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		VerifyBasicElemAlertDemo Al = new VerifyBasicElemAlertDemo();
		Al.start();
		Al.alertPage("Anjali", "Shukla", "AQM Techno");
	}
}