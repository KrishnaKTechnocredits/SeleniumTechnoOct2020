package shrutiC.assignment1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserCommands {
	
	

	public static void main(String[] args) {
		
		String driverPath = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);

		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");

		String title = driver.getTitle();
		System.out.println("Page Title : " + title);

		String url = driver.getCurrentUrl();
		System.out.println("Current URL : " + url);
		
		driver.quit();

	}

}
