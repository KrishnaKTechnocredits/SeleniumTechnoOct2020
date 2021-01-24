package suresh;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemoBasicElementspage {
	
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
		
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys("Suresh");
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys("Suresh1234");
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys("Technocredits");
		driver.findElement(By.xpath("/html/body/section/div/section/div[1]/div[1]/section/div/div[4]/button")).click();
		System.out.println("Alert message is: "+driver.switchTo().alert().getText());
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		//driver.quit();
		 
	}

}
