package nitin.Assignment_3; //Program - 1 : Verify alert message on Registration Page -> login.

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program_1_RegAlert {
	
	static WebDriver driver;
	
	private static WebDriver Start() {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		System.out.println("STEP : Open the Chrome Browser.");
		driver = new ChromeDriver();
		System.out.println("STEP : Open website AutomationByKrishna.com");
		driver.get("http://automationbykrishna.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("STEP : Website Opened Successfully.");
		driver.manage().window().maximize();
		return driver;
	}	
	public static void checkLogin(String userName, String password, String message) {
		System.out.println("STEP : Click on Registration Link.");
		driver.findElement(By.xpath("//*[text()='Registration']")).click();
		System.out.println("STEP : Enter UserName.");
		WebElement webelementUserName = driver.findElement(By.xpath("//input[@id='unameSignin']"));
		webelementUserName.clear();
		webelementUserName.sendKeys(userName);
		System.out.println("STEP : Enter Password.");
		WebElement webElementPassword = driver.findElement(By.xpath("//input[@id='pwdSignin']"));
		webElementPassword.clear();
		webElementPassword.sendKeys(password);
		System.out.println("STEP : Click on Submit Button.");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		if(alertText.contains(message))
			System.out.println("Login SuccessFull.");
		else
			System.out.println("Login Failed.");
	}
	
	public static void main(String[] args) {
		Start();
		System.out.println("Validate First User");
		Program_1_RegAlert.checkLogin("Nitin", "asgasa", "Failed! please enter strong password");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Validate Second User");
		Program_1_RegAlert.checkLogin("Alex", "trycgh", "Failed! please enter strong password");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Validate Third User");
		Program_1_RegAlert.checkLogin("mkanani", "mk12312312", "Success!");
		driver.close();
		System.out.println("Browser is Closed");
	}
}
