package shrutiC.assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogin {

	public static void main(String[] args) throws InterruptedException {

		String driverPath = "resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Launch facebook page");
		driver.get("https://www.facebook.com/");
		
		System.out.println("Enter Login credentials");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("email id");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("password");
		
		System.out.println("Click on login button");
		driver.findElement(By.xpath("//button[@name='login']")).submit();
		
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//*[@class='p361ku9c']")).isDisplayed())
			System.out.println("Login successful to facebook");
		else
			System.out.println("Login failed");
	}

}
