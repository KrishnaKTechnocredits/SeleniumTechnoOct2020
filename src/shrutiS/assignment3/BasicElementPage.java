/*Assignment - 3 :
	Program - 3 : Go to Basic element page,
    a) verify alert message on "Alert demo" form.*/
package shrutiS.assignment3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicElementPage {
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
	public static void main(String[] args) {
		start();
		System.out.println("Step1: Clicking on Basic Elements link");
		driver.findElement(By.linkText("Basic Elements")).click();
		String firstName = "Shruti";
		String lastName = "Sattigeri";
		String companyName = "Company";
		System.out.println("Step2: Enter first name");
		driver.findElement(By.name("ufname")).sendKeys(firstName);
		System.out.println("Step3: Enter last name");
		driver.findElement(By.name("ulname")).sendKeys(lastName);
		System.out.println("Step4: Enter company name");
		driver.findElement(By.name("cmpname")).sendKeys(companyName);
		System.out.println("Step5: Click on submit");
		driver.findElement(By.xpath("//header[contains(text(),'Alert Demo')]//parent::section//button")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println("Step6: Validate alert text");
		if(alert.getText().equals(firstName + " and " + lastName + " and " + companyName))
			System.out.println("Test Passed");
		else
			System.err.println("Test Failed");
		alert.accept();
	}

}
