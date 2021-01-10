package technoCredits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementExample1 {

	public static void main(String[] args) throws InterruptedException {
		String path = "./resources/windows/chromedriver.exe";
		
		System.out.println("STEP - open chrome browser");
		System.setProperty("webdriver.chrome.driver",path);
		WebDriver driver = new ChromeDriver();
		
		System.out.println("STEP - navigate to automationbykrishna.com");
		driver.get("http://automationbykrishna.com");
		
		System.out.println("STEP - click on registration link");
		driver.findElement(By.id("registration2")).click();
		
		Thread.sleep(2000);
		System.out.println("STEP - enter credentials");
		System.out.println("enter username");
		driver.findElement(By.id("unameSignin")).sendKeys("mkanani");
		
		System.out.println("enter password");
		driver.findElement(By.id("pwdSignin")).sendKeys("mkanani1234");
		
		System.out.println("STEP - click on login button");
		driver.findElement(By.id("btnsubmitdetails")).click();
		
		driver.findElement(By.className("VfPpkd-vQzf8d")).click();
		
	}
}
