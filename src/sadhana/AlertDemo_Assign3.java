package sadhana;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo_Assign3 {
	public static void main(String[] args) throws InterruptedException {

		String path = "C:\\TechnoCredids\\Selenium_Practice\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP-Navigate to AutomationByKrishna.com");
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize();
		System.out.println("STEP-Click on registration link");
		driver.findElement(By.id("registration2")).click();
		Thread.sleep(2000);
		System.out.println("Validating with invalid credentials");
		System.out.println("STEP-Enter user name");
		driver.findElement(By.xpath("//*[@id='unameSignin']")).sendKeys("mkanani");
		System.out.println("STEP-Enter user password");
		driver.findElement(By.xpath("//*[@id='pwdSignin']")).sendKeys("xyz123");
		System.out.println("STEP-CLick on Login Button");
		driver.findElement(By.xpath("//*[@id='btnsubmitdetails']")).click();
		Thread.sleep(2000);
		Alert alert1 = driver.switchTo().alert();
		String actualMessage = alert1.getText();
		alert1.accept();
		System.out.println(actualMessage);
		Thread.sleep(2000);
		System.out.println("Clear previously entered text.");
		driver.findElement(By.xpath("//*[@id='unameSignin']")).clear();
		driver.findElement(By.xpath("//*[@id='pwdSignin']")).clear();
		System.out.println("\n" +"--------------------------------------------------"+"\n");
		System.out.println("Validating with valid credentials");
		
		System.out.println("STEP-Enter user name");
		driver.findElement(By.xpath("//*[@id='unameSignin']")).sendKeys("mkanani");
		System.out.println("STEP-Enter user password");
		driver.findElement(By.xpath("//*[@id='pwdSignin']")).sendKeys("mkanani");
		System.out.println("STEP-CLick on Login Button");
		driver.findElement(By.xpath("//*[@id='btnsubmitdetails']")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		String actualAlertMessage = alert.getText();
		alert.accept();
		System.out.println(actualAlertMessage);

		driver.close();
		driver.quit();
	}
}
