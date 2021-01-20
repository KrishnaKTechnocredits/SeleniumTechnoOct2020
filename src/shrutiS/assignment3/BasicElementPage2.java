package shrutiS.assignment3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicElementPage2 {
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
	public static void main(String[] args) throws InterruptedException {
	start();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	System.out.println("Step1 : Clicking on basic elements");
	driver.findElement(By.linkText("Basic Elements")).click();
	Thread.sleep(1000);
	js.executeScript("window.scrollBy(0,300)");
	System.out.println("Step2 : Clicking on Alert");
	driver.findElement(By.id("javascriptAlert")).click();
	Alert alert = driver.switchTo().alert();
	System.out.println("Step3 : Validating Alert");
	if (alert.getText().equals("You must be TechnoCredits student!!"))
		System.out.println("Test Passed");
	alert.accept();

	System.out.println("Step4 : Clicking Confirmation");
	driver.findElement(By.id("javascriptConfirmBox")).click();
	alert = driver.switchTo().alert();
	alert.accept();
	System.out.println("Step5 : Checking text ");
	if (driver.findElement(By.id("pgraphdemo")).getText().equals("You pressed OK!"))
		System.out.println("Test passed");
	else
		System.out.println("Test Falied");

	System.out.println("Step : Clicking prompt");
	driver.findElement(By.id("javascriptPromp")).click();
	alert = driver.switchTo().alert();
	String name = "Shruti";
	System.out.println("Step : Entering name ");
	alert.sendKeys(name);
	alert.accept();
	System.out.println("Step : Checking Text");
	if (driver.findElement(By.id("pgraphdemo")).getText().equals("Hello " + name + "! How are you today?"))
		System.out.println("Test passed");
	else
		System.out.println("Test failed");

	driver.close();
	}
}
