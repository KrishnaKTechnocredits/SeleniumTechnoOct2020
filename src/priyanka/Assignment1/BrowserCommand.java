package priyanka.Assignment1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Write a program to cover below methods.

a) Browser Cmd :
		1) void get(String url)
		2) String getCurrentUrl()
		3) String getTitle()
        4) String getPageSource()
        5) void close()
        6) void quit() 
*/

public class BrowserCommand {

	public static void main(String[] args) {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		String pageSource = driver.getPageSource();
		// System.out.println(pageSource);
		String title = driver.getTitle();
		if (title.equals("Google"))
			System.out.println("Validated title");
		
		String url = driver.getCurrentUrl();
		if (url.contains("google"))
			System.out.println("Validated URL");
		driver.quit();
	}
}
