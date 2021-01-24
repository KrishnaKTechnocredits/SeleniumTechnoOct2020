package priyanka.Assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*Assignment - 2: 06th Jan'21 
Write a script to automate gmail & fb login.
use proper validation and printing statements.
*/
public class FacebookLogin {
	
	public static void main(String[] args) throws InterruptedException {

		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver = new ChromeDriver();
		try {
			System.out.println("Step: launch facebook.com");
			driver.get("http://facebook.com/");

			Thread.sleep(2000);
			System.out.println("Step: enter email or phone number");
			driver.findElement(By.id("email")).sendKeys("priya16286@gmail.com");
			System.out.println("Step: enter password");
			driver.findElement(By.id("pass")).sendKeys("****************");
			Thread.sleep(1000);
			System.out.println("Step: click on Log In button");
			driver.findElement(By.xpath("//button[text()='Log In']")).click();

			Thread.sleep(10000);
			System.out.println("Step: validate login");
			if (driver.findElement(By.xpath("//div[@aria-label='Account']")).isDisplayed())
				System.out.println("Login success. Test Passed");
			else
				System.out.println("Login Failed. Test Failed");
		} catch (Exception e) {
			System.out.println("Login Failed. Test Failed");
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}

}
