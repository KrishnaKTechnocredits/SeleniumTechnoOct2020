package raghvendra;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstAlert {
	static WebDriver driver;
	void start() {
		String path="./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver=new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
	}
	
	void alertFailed(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("mkanani");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("mk123");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		Alert alert=driver.switchTo().alert();
		String message=alert.getText();
		alert.accept();
		System.out.println(message);
		if(message.contains("Failed"))
			System.out.println("Login Failed");
		else
			System.out.println("Login Successful");
	}
	public static void main(String[] args) throws InterruptedException {
		FirstAlert firstAlert=new FirstAlert();
		firstAlert.start();
		firstAlert.alertFailed(driver);
	}

}
