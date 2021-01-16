package nagendra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogin {

	public static void main(String[] args) {
		System.out.println("STEP- Launch The Browser");
		System.setProperty("webdriver.chrome.driver", "./resources/windows/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		System.out.println("STEP - Login with User Name");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("nagendratiwari46@yahoo.com");
		System.out.println("STEP- Provided Password");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Nopassword");
		System.out.println("STEP - Click on Login Button");
		driver.findElement(By.xpath("//button[@name='login']")).click();
		System.out.println("Close the browser");
		driver.close();
	}
}
