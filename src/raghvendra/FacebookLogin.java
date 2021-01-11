package raghvendra;
import org.openqa.selenium.By;
/*Assignment - 2: 06th Jan'21 
Write a script to automate gmail & fb login.
use proper validation and printing statements*/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class FacebookLogin {

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
		driver.quit();
	}
}
