package ruby;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*Assignment - 1:

Write a program to cover below methods.

a) Browser Cmd :
		1) void get(String url)
		2) String getCurrentUrl()
		3) String getTitle()
        4) String getPageSource()
        5) void close()
        6) void quit() */

public class A1P1OpenBrowser {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./resources/windows/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// Open Browser
		driver.get("http://google.com");
		
		// Print Current URL
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current Url: "+ currentUrl);
		
		// Print Title of the page
		String title = driver.getTitle();
		System.out.println("Title of the page: "+ title);
		
		//Print Page source
		System.out.println("Page Source: "+driver.getPageSource());

		// Close 
		driver.close();

	}
}
