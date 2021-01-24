/*Assignment - 2:  
Write a script to automate gmail & fb login.
use proper validation and printing statements.*/
package pooja.Assignment_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/windows/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// driver.navigate().to("https://www.facebook.com/");
		System.out.println("STEP - Go to Facebook Page");
		driver.get("https://www.facebook.com/");
		System.out.println("STEP - Maximize Window");
		driver.manage().window().maximize();

		System.out.println("STEP - Enter Username");
		driver.findElement(By.id("email")).sendKeys("pekhalepooja1020@gmail.com");
		System.out.println("STEP - Enter Password");
		driver.findElement(By.id("pass")).sendKeys("*******");
		System.out.println("STEP - Click On Login");
		driver.findElement(By.name("login")).click();
		System.out.println("STEP-Incorrect Password");
		String currentUrl = driver.getCurrentUrl();
		System.out.println("URL is:" + currentUrl);
		System.out.println("STEP - Click On Forgotten Password");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Forgotten password?']")).click();
		Thread.sleep(2000);
		System.out.println("STEP - Close");
		driver.close();
	}
}
