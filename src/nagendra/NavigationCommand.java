package nagendra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
b) navigation cmd:
    1) void navigate().to(String url)
    2) void navigate().forward()
    3) void navigate().back()
    4) void navigate().refresh()
*/

public class NavigationCommand {

	public static void main(String[] args) throws InterruptedException {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP -Navigate to Url");
		driver.navigate().to("http://www.google.com");
		System.out.println("STEP -Navigate Backward");
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		System.out.println("STEP -Navigate Forward");
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		System.out.println("STEP -Refresh The Page");
		driver.navigate().refresh();
		driver.close();
	}
}
