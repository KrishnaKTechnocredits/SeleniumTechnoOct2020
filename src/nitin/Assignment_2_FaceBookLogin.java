package nitin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_2_FaceBookLogin {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty(ConstantPath.chromeDriverKey, ConstantPath.chromeDriverPath); // use from previous class
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println(title+" --> opened successfully.");
		System.out.println("Step - 1. Click on UserName textbox.");
		driver.findElement(By.id("email")).click();
		System.out.println("Step - 2. UserName entered successfully.");
		driver.findElement(By.id("email")).sendKeys("nitinXXXXXX@gmail.com");
		System.out.println("Step - 3. Password entered successfully.");
		driver.findElement(By.id("pass")).sendKeys("XXXXXXXX");
		System.out.println("Step - 4. Click on Login Button.");
		driver.findElement(By.name("login")).click();
		Thread.sleep(5000);
		String currentTitle = driver.getTitle();
		String expectedTitle = "Facebook";
		if(currentTitle.equals(expectedTitle))
			System.out.println("User logged in Successfully.");
		else
			System.out.println("Login Failed, Please check the Username & Password.");
		driver.close();
	}
}
