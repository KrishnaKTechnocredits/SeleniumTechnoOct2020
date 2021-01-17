package yogita.Assignment_3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemoForm {
	static WebDriver driver;

	static void launchBrowser() {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();

		driver.get("http://automationbykrishna.com/");
		System.out.println("AutomationByKrishna website open successfully.");
		driver.manage().window().maximize();
	}

	static void verifyAlertMsgOnAlertDemoForm(String fName, String lName, String cName, String expectedMsgOnAlertForm) {
		System.out.println("Step-Go to Basic Elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("STEP-Finding First Name Field");
		driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys(fName);
		System.out.println("STEP-Finding Last Name Field");
		driver.findElement(By.xpath("//input[@name='ulname']")).sendKeys(lName);
		System.out.println("STEP-Finding Company Name Field");
		driver.findElement(By.xpath("//input[@placeholder='Enter User Companyname']")).sendKeys(cName);
		System.out.println("STEP-Finding Submit Button");
		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();
		Alert alertDemoMsg = driver.switchTo().alert();
		String actualMsgOnAlerForm = alertDemoMsg.getText();
		System.out.println("STEP-Verification Of Alert Msg");
		if (expectedMsgOnAlertForm.equalsIgnoreCase(actualMsgOnAlerForm)) {
			System.out.println("Verification Of Alert Msg On Alert Demo --> Pass");
		} else {
			System.out.println("Verification Of Alert Msg On Alert Demo -->Failed");
		}
	}

	public static void main(String[] args) {
		AlertDemoForm.launchBrowser();
		String firstName = "yogita";
		String lastName = "pawale";
		String companyName = "EC-Mobility";
		String expectedMsg = "yogita and pawale and EC-Mobility";
		AlertDemoForm.verifyAlertMsgOnAlertDemoForm(firstName, lastName, companyName, expectedMsg);
		driver.close();
	}
}