package ruby;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A2FBLogin {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./resources/windows/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Step1: Open Facebook");
		driver.get("https://www.facebook.com/");
		
		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
		
		System.out.println("Step2: Maximize Browser");
		driver.manage().window().maximize();
		
		System.out.println("Step3: Enter username");
		driver.findElement(By.id("email")).sendKeys("ruby.k@gmail.com");
		
		System.out.println("Step4: Password");
		driver.findElement(By.id("pass")).sendKeys("pass123");
		
		System.out.println("Step5: Click on login button'");
		driver.findElement(By.xpath("//button[@name='login']")).click();
		
		System.out.println("Close the Browser'");
		driver.close();
	}
}
