package suresh;
/*Assignment - 2: 06th Jan'21 
Write a script to automate gmail & fb login.(Only FB login)
use proper validation and printing statements.*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationtoFaceBook {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\Desktop\\Suresh\\Learning\\Oct_selenium\\selenium jars\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
 	
		driver.navigate().to("https://www.facebook.com/");
		String url1 = driver.getCurrentUrl();
		System.out.println("website URL is:\t" + url1);
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys("sureshchukka1@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("test123");
		
		//driver.findElement(By.xpath("//[@id='email'])")
		
		driver.findElement(By.name("login")).click(); 
		System.out.println("Welcome to facebook");
		//driver.close();
		// driver.quit();

	}

}