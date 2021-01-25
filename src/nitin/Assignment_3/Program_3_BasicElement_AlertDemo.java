package nitin.Assignment_3;
//Assignment - 3 : Program - 3 : Go to Basic element page -> a) verify alert message on "Alert demo" form.

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program_3_BasicElement_AlertDemo {
	
	public static WebDriver driver;
	public static WebDriver start() {
		System.out.println("STEP - Open Chrome Browser.");
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		System.out.println("STEP - Navigate to automationbykrishna.com");
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		return driver;
	}
	public static void alertDemo(String userName,String lastName,String companyName) {
		System.out.println("STEP - Click on Basic Elements tab.");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		if(driver.findElement(By.xpath("//header[@class='panel-heading' and text() =' Alert Demo ']")).isDisplayed()) {
			System.out.println("STEP - Enter FirstName");
			driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys(userName);
			System.out.println("STEP - Enter LastName");
			driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys(lastName);
			System.out.println("STEP - Enter Company Name");
			driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys(companyName);
			System.out.println("STEP - Click on Submit Button");
			driver.findElement(By.xpath("//header[contains(text(),'Alert Demo')]//parent::section//button")).click();
			Alert alert = driver.switchTo().alert();
			if(alert.getText().equals(userName + " and " + lastName + " and " + companyName))
				System.out.println(alert.getText()+" #Test Case is Passed");
			else
				System.out.println("Test Case is Failed");
			alert.accept();
		}
		else
			System.out.println("Basic Element page is not visible.");
	}
	public static void main(String[] args) {
		start();
		alertDemo("Nitin","Jain","IRIS");
		driver.close();
		System.out.println("Browser is Closed.");
	}
}
