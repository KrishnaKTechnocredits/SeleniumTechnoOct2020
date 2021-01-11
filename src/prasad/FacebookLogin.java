package prasad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogin {

	static public void Login() throws InterruptedException {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver = new ChromeDriver();
		System.out.println("Step: Open Facebook login page on chrome browser");
		driver.get("https://facebook.com");
		System.out.println("Step: Enter login Credentials");
		System.out.println("Enter user name");
		driver.findElement(By.xpath("//*[@name = 'email']")).sendKeys("prasad.chitale@gmail.com");
		System.out.println("Enter password");
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("******");
		System.out.println("Step:Click on login button");
		driver.findElement(By.xpath("//button[@name='login']")).click();
		Thread.sleep(5000);
		String tabName = driver.getTitle();
		
		if(tabName.equals("Facebook")) {
			System.out.println("User is logged in successfully");
		}
		else {
			System.out.println("User login failed");
		}
	}

	public static void main(String[] arg) throws InterruptedException {
		FacebookLogin.Login();
	}
}
