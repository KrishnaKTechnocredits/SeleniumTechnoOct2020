package ruby;
/*b) navigation cmd:
    1) void navigate().to(String url)
    2) void navigate().forward()
    3) void navigate().back()
    4) void navigate().refresh()*/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A1P2Navigation {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./resources/windows/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Open Browser");
		driver.get("https://www.google.com/");
		
		System.out.println("Nagivate to facebook URL");
		driver.navigate().to("https://www.facebook.com/");
		
		System.out.println("Back to Google URL");
		driver.navigate().back();

		System.out.println("Forward Nagivation to google");
		driver.navigate().forward();
		
		System.out.println("Refresh page");
		driver.navigate().refresh();
		
		System.out.println("Close all browser");
		driver.quit();	
	}
}
