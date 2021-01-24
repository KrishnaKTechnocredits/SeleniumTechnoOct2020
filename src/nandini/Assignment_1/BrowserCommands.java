package nandini.Assignment_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserCommands {

	public static void main(String[] args) {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		String pageSource = driver.getPageSource();
		String title = driver.getTitle();
		if(title.equals("Google"))
			System.out.println("Validated title");
		String url = driver.getCurrentUrl();
		if(url.contains("google"))
			System.out.println("Validated URL");
		driver.quit();
	}
}
