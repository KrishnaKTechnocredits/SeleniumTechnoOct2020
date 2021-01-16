package raghvendra.Selenium.Practice;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class AlertTest {
	public static void main(String[] args) throws InterruptedException {
		String path="./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("testhchb@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Pass_1234");
		driver.findElement(By.xpath("//button[@name='login']")).click();
		Thread.sleep(1000);
		String PageTitle = driver.getTitle();
		if(PageTitle.contains("Facebook"))
			System.out.println("User is successfully logged in to Facebook");
		else 
			System.out.println("User login failed");
		Alert alert = driver.switchTo().alert();
		String text=alert.getText();
		System.out.println(text);
	}
	
}
