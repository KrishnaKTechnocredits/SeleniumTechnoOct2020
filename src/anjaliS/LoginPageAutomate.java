package anjaliS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageAutomate {

	public static void main(String[] args) {
		String os = System.getProperty("os.name").toLowerCase();
		System.out.println("os : " + os);
		String path = os.contains("windows") ? "./resources/windows/chromedriver.exe"
				: os.contains("mac") ? "./resources/mac/chromedriver" : null;
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver = new ChromeDriver();
		driver.get("http://facebook.com/");
		System.out.println("Facebook opened successfully.");
		driver.findElement(By.id("email")).sendKeys("anjalid.shukla@gmail.com");
		System.out.println("Email-id entered");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("techno145222@");
		System.out.println("Password entered");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("Error message displayed:The password that you've entered is incorrect");
		driver.findElement(By.className("_97w4")).click();
	}
}