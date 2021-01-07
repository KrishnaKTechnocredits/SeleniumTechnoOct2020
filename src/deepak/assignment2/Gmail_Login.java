/*
Assignment - 2: 06th Jan'21 
Write a script to automate gmail & fb login.
use proper validation and printing statements.
 * 
 */

package deepak.assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Gmail_Login {
	
	 static WebDriver start() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./resources/windows/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		loginGmail(driver);
		
		return driver;
	}
	
	static void loginGmail(WebDriver driver) throws InterruptedException {
		
		String expectedPageTitle = "Facebook – log in or sign up";
		
		driver.get("http://facebook.com/");
		driver.manage().window().maximize();
		
		String actualPageTitle = driver.getTitle();
		
		if(actualPageTitle.equals(expectedPageTitle)) {
			
			System.out.println("We are correct page : "+ actualPageTitle);
		}
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("deepak.latad@gmail.com");
		driver.findElement(By.xpath("//input[@id='pass']")).click();
		System.out.println("Please Enter your password manually");
		Thread.sleep(20000);
		driver.findElement(By.xpath("//button[@name='login']")).click();
		
		//Verifying user is actually logged in
		WebElement name = driver.findElement(By.xpath("//span[text()='Deepak']"));
	
		if(name != null) {
			
			System.out.println("You are logged in as :"+ name.getText());
			System.out.println("Test Pass Successfully");
		}
		
		driver.close();
		
	}

	public static void main(String[] args) throws InterruptedException {
		
		start();
	}

}
