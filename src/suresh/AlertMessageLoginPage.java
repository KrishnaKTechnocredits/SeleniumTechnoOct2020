package suresh;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertMessageLoginPage {
	static WebDriver start() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\Desktop\\Suresh\\Learning\\Oct_selenium\\selenium jars\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("http://automationbykrishna.com/#");
		String url1 = driver.getCurrentUrl();
		System.out.println("website URL is:\t" + url1);
		return driver;

	}
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = start();
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		Thread.sleep(3000);
		WebElement uname= driver.findElement(By.xpath("//input[@id='unameSignin']"));
		uname.sendKeys("Suresh");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("test123");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		System.out.println("Alert message is: "+driver.switchTo().alert().getText());
		Thread.sleep(100);
		driver.switchTo().alert().accept();
		driver.quit();
		
	}

}
