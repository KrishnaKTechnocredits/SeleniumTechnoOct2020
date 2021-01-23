package nitin.Assignment_3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*Program - 2: Go to Basic element page,
a) verify alert message on Alert button.
b) verify label message on JavaScript Confirmation button
c) verify label message on JavaScript prompt button*/

public class Program_2_BasicAlert {
	
	public static WebDriver driver;
	private static WebDriver Start() {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		System.out.println("STEP - Open Chrome Browser.");
		driver = new ChromeDriver();
		System.out.println("STEP - Open website automationByKrishna.com");
		driver.get("http://automationbykrishna.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	public static void verifyAlerts() {
		try {
			System.out.println("STEP - Click on Basic Elements tab.");
			driver.findElement(By.xpath("//*[text()='Basic Elements']")).click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			System.out.println("STEP - Scroll down the webpage.");
			WebElement element = driver.findElement(By.id("javascriptAlert"));
			//js.executeScript("arguments[0].scrollIntoView(true)",element);
			js.executeScript("window.scrollBy(0,300)");
			//js.executeScript("arguments[0].click()", element);
			System.out.println("STEP - Click on Alert.");
			element.click();
			Alert alert = driver.switchTo().alert();
			System.out.println("STEP - Validate alert text.");
			if(alert.getText().equals("You must be TechnoCredits student!!"))
				System.out.println("Test Case Passed.");
			else
				System.out.println("Test Case Failed.");
			alert.accept();
			
			System.out.println("STEP - Click on Javascript Confirmation.");
			driver.findElement(By.id("javascriptConfirmBox")).click();
			alert = driver.switchTo().alert();
			alert.accept();
			System.out.println("STEP - Validate text.");
			if(driver.findElement(By.id("pgraphdemo")).getText().equals("You pressed OK!"))
				System.out.println("Test Case is Passed.");
			else
				System.out.println("Test Case is failed.");
			
			System.out.println("Step : Clicking javasxript prompt");
			driver.findElement(By.id("javascriptPromp")).click();
			alert = driver.switchTo().alert();
			String name = "Nitin";
			System.out.println("Step : Entering name ");
			alert.sendKeys(name);
			alert.accept();
			System.out.println("Step : Checking Text");
			if (driver.findElement(By.id("pgraphdemo")).getText().equals("Hello " + name + "! How are you today?"))
				System.out.println("Test passed");
			else
				System.out.println("Test failed");
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			driver.close();
		}
		
	}
	public static void main(String[] args) {
		Start();
		System.out.println();
		Program_2_BasicAlert.verifyAlerts();
		System.out.println("Browser is Closed");
	}
}
