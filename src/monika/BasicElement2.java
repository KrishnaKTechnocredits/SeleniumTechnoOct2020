package monika;

/*Assigmnment 
Program - 2: Go to Basic element page, 
             a) verify alert message on Alert button.
			 b) verify label message on JavaScript Confirmation button
			 c) verify label message on JavaScript prompt button
*/
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicElement2 {
	static WebDriver driver;

	public static WebDriver start() {
		System.out.println("Step : opening browser");
		System.setProperty("webdriver.chrome.driver", "./resources/windows/chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Step : Naviigate to automationbykrishna.com");
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	public static void main(String[] args) throws InterruptedException {
		start();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out.println("Step : Clicking on basic elements");
		driver.findElement(By.linkText("Basic Elements")).click();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,300)");

		System.out.println("Step : Clicking on Alert");
		driver.findElement(By.id("javascriptAlert")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println("Step : Validating Alert");
		if (alert.getText().equals("You must be TechnoCredits student!!"))
			System.out.println("Test Passed");
		alert.accept();

		System.out.println("Step : Clicking Javascript Confirmation");
		driver.findElement(By.id("javascriptConfirmBox")).click();
		alert = driver.switchTo().alert();
		alert.accept();
		System.out.println("Step : Checking text ");
		if (driver.findElement(By.id("pgraphdemo")).getText().equals("You pressed OK!"))
			System.out.println("Test passed");
		else
			System.out.println("Test Falied");

		System.out.println("Step : Clicking javasxript prompt");
		driver.findElement(By.id("javascriptPromp")).click();
		alert = driver.switchTo().alert();
		String name = "Monika";
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

