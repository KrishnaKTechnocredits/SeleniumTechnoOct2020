package brijesh.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	static WebDriver driver;
	public static WebDriver start(String website) {
		String os = System.getProperty("os.name").toLowerCase();
		System.out.println("os : "+ os);
		String path = os.contains("windows") ? "./resources/windows/chromedriver.exe"
				: os.contains("mac") ? "./resources/mac/chromedriver" : null;
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.get(website);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println(website+" website open successfully.");
		return driver;
	}
	
	public static void start() {
		start("http://automationbykrishna.com/");
	}
	
	public static void quit(WebDriver driver) {
		driver.quit();
	}
}
