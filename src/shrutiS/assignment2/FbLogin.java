package shrutiS.assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FbLogin {
	public static void main(String[] args) throws InterruptedException {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver = new ChromeDriver();
		driver.get("http://facebook.com/");
		System.out.println("Step1: facebook page is loaded");
		Thread.sleep(2000);
		//Entering login credentials
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("7020383787");
		System.out.println("Step2: MobileNo or Email id entered");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Nalini-4591");
		System.out.println("Step3: Password entered");
		driver.findElement(By.xpath("//button[@name='login']")).click();
		System.out.println("Step4: Login button is clicked");
		System.out.println("Step5: Verify isUser logged in");
		String actualPageTitle = driver.getTitle();
		System.out.println("Title:"+actualPageTitle);
		String expectedPageTitle = "Facebook";
		if(actualPageTitle.equals(expectedPageTitle)) 
			System.out.println("User logged in successfully");
		else 
			System.out.println("User is not logged in because" + actualPageTitle);
	}
}
