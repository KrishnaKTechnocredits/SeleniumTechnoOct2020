package nagendra.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {
	
	public static WebDriver start() {

		return start("http://automationbykrishna.com/");
	 }

	public static WebDriver start(String url) {

		System.setProperty("webdriver.chrome.driver", "./resources/windows/chromedriver.exe");
		System.out.println("Launch browser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
}
