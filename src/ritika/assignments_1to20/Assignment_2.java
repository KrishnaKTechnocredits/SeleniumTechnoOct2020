package ritika.assignments_1to20;
/* Assignment - 2: 06th Jan'21
Write a script to automate gmail & fb login.
use proper validation and printing statements
*/
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_2 {

	static void verifyFacebookLogin(WebDriver driver) throws InterruptedException {

		driver.manage().window().maximize();
		System.out.println("STEP1: Launch Facebook login page");
		driver.get("https://www.facebook.com/login/");
		Thread.sleep(3000);
		WebElement id = driver.findElement(By.id("email"));
		Thread.sleep(3000);
		System.out.println("STEP2: Enter ID");
		id.clear();
		id.sendKeys("ritikagandhi24@yahoo.in");
		WebElement password = driver.findElement(By.id("pass"));
		System.out.println("STEP3: Enter Password");
		password.clear();
		password.sendKeys("********");
		Thread.sleep(3000);
		System.out.println("STEP4: Click on Log In button");
		driver.findElement(By.id("loginbutton")).click();
		Thread.sleep(3000);
		System.out.println("Step5: Validate Login");
		try {
			if (driver.findElement(By.xpath("//div[@aria-label='Account controls and settings']")).isDisplayed())
				System.out.println("Login Successfull");

		} catch (NoSuchElementException nse) {
			if (driver.findElement(By.xpath("//form[@id='login_form']")).isDisplayed())
				System.out.println("Login Failed");
		}
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./resources/windows/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		try {
			verifyFacebookLogin(driver);
		} catch (InterruptedException e) {
			System.out.println("Exception handled");
		} finally {
			driver.close();
		}
		System.out.println("Test Completed");
	}
}
