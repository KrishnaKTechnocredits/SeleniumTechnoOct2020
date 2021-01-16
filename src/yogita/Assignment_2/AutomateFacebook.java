/*
 *Write a script to automate gmail & fb login.
use proper validation and printing statements
*/

package yogita.Assignment_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomateFacebook {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./resources/windows/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		System.out.println("STEP-Go To FaceBook");
		driver.get("https://www.facebook.com/");

		System.out.println("STEP-Maximizing Window");
		driver.manage().window().maximize();

		System.out.println("STEP-Finding UserName Field");
		WebElement userName = driver.findElement(By.id("email"));
		System.out.println("Sending User Name");
		userName.sendKeys("xyz@gmail.com");

		System.out.println("STEP-Finding Password Field");
		WebElement password = driver.findElement(By.id("pass"));
		System.out.println("Sending Passowrd");
		password.sendKeys("abc@123456");

		System.out.println("STEP-Finding Log-in Button");
		WebElement login = driver.findElement(By.name("login"));
		System.out.println("Click On Login");
		login.click();

		System.out.println("STEP-Incorrect Password");
		String currentUrl = driver.getCurrentUrl();
		System.out.println("URL is:" + currentUrl);
		Thread.sleep(3000);

		System.out.println("STEP-Finding Forget-Password");
		WebElement forgetPass = driver.findElement(By.xpath("//a[text()='Forgotten password?']"));
		Thread.sleep(3000);
		System.out.println("STEP-Click on Forget Password");
		forgetPass.click();
		Thread.sleep(3000);

		System.out.println("STEP-Close Browser");
		driver.close();

	}
}
