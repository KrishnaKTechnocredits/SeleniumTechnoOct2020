package sadhana;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook_LoginPage_2 {

	public static void main(String[] args) {

		String path = "C:\\TechnoCredids\\Selenium_Practice\\chromedriver.exe";
		System.out.println("STEP - open chrome browser");
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver = new ChromeDriver();

		System.out.println("STEP - navigate to facebook.com");
		driver.get("https://www.facebook.com/");
		System.out.println("enter Email address or Phone number");
		driver.findElement(By.id("email")).sendKeys("Sadhana Pawar");

		System.out.println("STEP - enter password");
		driver.findElement(By.id("pass")).sendKeys("sadhana123");

		System.out.println("STEP - click on login button");
		driver.findElement(By.name("login")).click();
		
		String actualTitle=driver.getTitle();
		String expectedTitle="Search Facebook ";
		if(actualTitle.equals(expectedTitle))
			System.out.println("Successfully logged in");
		else
			System.out.println("STEP - click on not me link");
		    driver.findElement(By.id("not_me_link")).click();
		driver.close();

	}
}