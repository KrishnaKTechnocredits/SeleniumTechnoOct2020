/*Write a script to automate gmail & fb login.
use proper validation and printing statements*/

package kajol.assignment2.facebooklogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogin {
	
	public static void main(String[] args) throws InterruptedException {
		
		String path="./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		String title=driver.getTitle();
		if(title.equals("Facebook – log in or sign up")) 
			System.out.println("Facebook Login Page is Displayed.Please Enter Your Details to Login");
		System.out.println("Enter Email address or phone number");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("chhabadakajol@gmail.com");
		System.out.println("Enter Password");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("abcd6");
		System.out.println("Click on Login");
		driver.findElement(By.xpath("//button[text()='Log In']")).click();////button[@name='login'],//button[@id='u_0_b']//
		System.out.println("Validate Login");
		if (driver.findElement(By.xpath("//div[@class='_9ay5']")).isDisplayed()) {
			System.out.println("Login Failed");
			System.out.println("Test Fail");
		}		
		else {
			System.out.println("Login Success");
			System.out.println("Test Pass");		
		}	
		driver.quit();
	}
}
