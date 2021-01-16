/*Assignment - 2: 06th Jan'21
Write a script to automate gmail & fb login.
use proper validation and printing statements.
*/

package ankita.assignment.assignment2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogin {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("STEP : Open Chrome browser");
		System.setProperty("webdriver.chrome.driver", "./resources/windows/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		System.out.println("STEP : Open facebook.com");
		driver.get("https://www.facebook.com/");

		System.out.println("STEP : Enter credentials");
		System.out.println("STEP : Enter username");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("9011595072");
		System.out.println("STEP : Enter password");
		driver.findElement(By.id("pass")).sendKeys("samosabag123!");
		Thread.sleep(2000);

		System.out.println("STEP : Click on login button");
		driver.findElement(By.xpath("//button[@name=\"login\"]")).click();

		Thread.sleep(2000);
		System.out.println("STEP : Check Login Page");
		if (driver.findElement(By.xpath("//div[@aria-label='Account']")).isDisplayed())
			System.out.println("Login Successful");
		else
			System.out.println("Login failed");

		System.out.println("STEP : Close browser..");
		driver.close();
	}
}
