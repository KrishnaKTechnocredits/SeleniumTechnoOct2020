/*Assignment - 1: 
Write a program to cover below methods.

a) Browser Cmd :
	1) void get(String url)
	2) String getCurrentUrl()
	3) String getTitle()
    4) String getPageSource()
    5) void close()
    6) void quit()*/

package shrutiS.assignment1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserCommands {
	public static void main(String[] args) throws InterruptedException {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		Thread.sleep(1000);
		System.out.println("Test Case1 Pass: Google page in Chrome browser open successfully ");
		// Verify current URL with expected URL
		String currentURL = driver.getCurrentUrl();
		String expected = "https://www.google.com/";
		if (currentURL.equals(expected))
			System.out.println("Test Case2 Pass: URL is correct");
		else
			System.out.println("Test Case2 Fail: URL is not correct");
		// Verify Title of page as expected
		String currentTitle = driver.getTitle();
		expected = "Google";
		if (currentTitle.equals(expected))
			System.out.println("Test Case3 Pass: Title is correct");
		else
			System.out.println("Test Case3 Fail: Title is not correct");
		// Finding page source
		int pageSourceLength=driver.getPageSource().length();
		System.out.println("Page Source length :" + pageSourceLength);
		// Close the current window
		driver.close();
		// Close multiple window of same session
	  /*driver.get("https://www.gmail.com");
		driver.get("https://www.google.com");
		driver.quit();*/
	}

}
