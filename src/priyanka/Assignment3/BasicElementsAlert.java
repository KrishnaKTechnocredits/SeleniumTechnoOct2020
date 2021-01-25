package priyanka.Assignment3;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Program - 3 : Go to Basic element page,
             a) verify alert message on "Alert demo" form.
*/

public class BasicElementsAlert {

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
		try {
			start();
			System.out.println("Step: Clicking on Basic Elements link");
			driver.findElement(By.linkText("Basic Elements")).click();
			String firstName = "Priyanka";
			String lastName = "Kamthe";
			String companyName = "Company1";
			System.out.println("Step: Enter first name");
			driver.findElement(By.name("ufname")).sendKeys(firstName);
			System.out.println("Step: Enter last name");
			driver.findElement(By.name("ulname")).sendKeys(lastName);
			System.out.println("Step: Enter company name");
			driver.findElement(By.name("cmpname")).sendKeys(companyName);
			System.out.println("Step: Click on submit");
			driver.findElement(By.xpath("//header[contains(text(),'Alert Demo')]//parent::section//button")).click();
			Alert alert = driver.switchTo().alert();
			System.out.println("Step: Validate alert text");
			if (alert.getText().equals(firstName + " and " + lastName + " and " + companyName))
				System.out.println("Test Passed");
			else
				System.err.println("Test Failed");
			alert.accept();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
	}
}
