package milind;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogin {
	
	WebDriver driver = null;
	
	void openBrowser() {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		System.out.println("STEP : Browser launch successfully");
		driver.get("https://www.facebook.com");
		System.out.println("STEP : Redirect to Facebook");
	}
	
	void userLogin() throws InterruptedException {
		System.out.println("STEP : Enter User credentials");
		System.out.println("Enter User Email");
		driver.findElement(By.id("email")).sendKeys("milind.chavhan81");
		System.out.println("Enter Password");
		driver.findElement(By.id("pass")).sendKeys("**********");
		System.out.println("STEP : Click on login Button");
		driver.findElement(By.xpath("//*[@id='u_0_b']")).click();
		Thread.sleep(3000);
		System.out.println("STEP : Verify isUser logged in");
		String actualPageTitle = driver.getTitle();
		String expectedPageTitle = "Facebook";
		if(actualPageTitle.equals(expectedPageTitle)) {
			System.out.println("User logged in successfully");
		}else {
			System.out.println("User is not logged in because" + actualPageTitle);
		}
	}
	
	void closeBrowser() {
		System.out.println("Browser closing");
		driver.close();
	}
	
	public static void main(String[] args) throws InterruptedException {
		FacebookLogin facebookLogin = new FacebookLogin();
		facebookLogin.openBrowser();
		facebookLogin.userLogin();
		facebookLogin.closeBrowser();
	}

}
