package technoCredits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo {
	static WebDriver driver;
	
	static void start() {
		String path = "./resources/windows/chromedriver.exe";
		System.out.println("STEP - open chrome browser12345");
		System.out.println("STEP - open chrome browser 11");
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.automationbykrishna.com");
	}
	
	
	void verifyAlert()
	{
		
	}
	
	void verifyPrompt() {
		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		String username = "mkanani";
		String password = "mk123";
		String expectedMessage = "Failed! please enter strong password";
		
		System.out.println("STEP - open chrome browser");
		start();
		driver.findElement(By.xpath("//a[text()='Registration']")).click();
		Thread.sleep(2000);
		
		WebElement element = driver.findElement(By.xpath("//input[@id='unameSignin']"));
		if(element.isDisplayed() && element.getText().equals("First Name"))
			System.out.println("Firstname label is visible and text is as expected");
		
		
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		
		driver.switchTo().alert().accept();
		String alertText = driver.switchTo().alert().getText();
		
		System.out.println(alertText);
		
		String name = "Maulik";
		driver.switchTo().alert().sendKeys(name);
		
		String actualMessage = driver.switchTo().alert().getText();
		if(actualMessage.contains(name))
			System.out.println("Pass");
		
		
	}
}
