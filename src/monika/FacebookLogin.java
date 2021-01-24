package monika;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogin {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("STEP : Open Chrome browser");
		System.setProperty("webdriver.chrome.driver", "./resources/windows/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		System.out.println("STEP1 : Open facebook.com page");
		driver.get("https://www.facebook.com/");

		System.out.println("STEP2 : Enter username");
		//driver.findElement(By.id("//input[@id='email']")).sendKeys("sethi.mona@gmail.com");
		driver.findElement(By.id("email")).sendKeys("sethi.mona@gmail.com");
		
		System.out.println("STEP : Enter password");
		driver.findElement(By.id("pass")).sendKeys("9889154510");
		Thread.sleep(2000);

		System.out.println("STEP : Click on login button");
		driver.findElement(By.xpath("//button[@name=\"login\"]")).click();
		
		System.out.println("STEP : login page");
		
		String LoginPageTitle = driver.getTitle();
		if(LoginPageTitle.contains("Facebook"))
			System.out.println("User is logged in to Facebook");
		else 
			System.out.println("not logged in");
		driver.close();
	}
}


