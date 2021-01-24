package priyanka.Assignment3;

/*
 * Program - 2: Go to Basic element page, a) verify alert message on Alert
 * button. b) verify label message on JavaScript Confirmation button c) verify
 * label message on JavaScript prompt button
 * 
 */

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicElementsAlert2 {
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
			JavascriptExecutor js = (JavascriptExecutor) driver;
			System.out.println("Step: Clicking on Basic Elements link");
			driver.findElement(By.linkText("Basic Elements")).click();

			Thread.sleep(1000);
			js.executeScript("window.scrollBy(0,200)");

			System.out.println("Step: Click on Alert");
			driver.findElement(By.id("javascriptAlert")).click();
			Alert alert = driver.switchTo().alert();
			System.out.println("Step: Validate alert text");
			if (alert.getText().equals("You must be TechnoCredits student!!"))
				System.out.println("Test Passed");
			else
				System.err.println("Test Failed");
			alert.accept();

			System.out.println("\nStep: Click on Java Script ConfirmationBox");
			driver.findElement(By.id("javascriptConfirmBox")).click();
			alert = driver.switchTo().alert();
			System.out.println("Step: Accept alert");
			alert.accept();
			System.out.println("Step: Assert text of paragraph");
			if (driver.findElement(By.id("pgraphdemo")).getText().equals("You pressed OK!"))
				System.out.println("Test Passed");
			else
				System.out.println("Test Failed");

			System.out.println("\nStep: Click on Java Script Prompt");
			driver.findElement(By.id("javascriptPromp")).click();
			alert = driver.switchTo().alert();
			System.out.println("Step: Enter name in alertbox field");
			String name = "Brijesh";
			alert.sendKeys(name);
			System.out.println("Step: Accept alert");
			alert.accept();
			System.out.println("Step: Assert text of paragraph");
			if (driver.findElement(By.id("pgraphdemo")).getText().equals("Hello " + name + "! How are you today?"))
				System.out.println("Test Passed");
			else
				System.out.println("Test Failed");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
	}

}
