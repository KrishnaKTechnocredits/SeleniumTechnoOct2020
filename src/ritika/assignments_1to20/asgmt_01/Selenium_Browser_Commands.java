package ritika.assignments_1to20.asgmt_01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*Assignment-1 : 05 Jan' 2021

Write a program to cover below methods.

a) Browser Cmd :
1) void get(String url)
2) String getCurrentUrl()
3) String getTitle()
4) String getPageSource()
5) void close()
6) void quit()
*/
public class Selenium_Browser_Commands {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./resources/windows/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		String currentURL = driver.getCurrentUrl();
		String expected = "https://www.google.com/";
		if(currentURL.equals(expected))
			System.out.println("Page loaded successfully");
		
		String pageTitle = driver.getTitle();
		expected = "Google";
		if(pageTitle.equals(expected));
			System.out.println("Correct page title");
		
		int pageSourceLength = driver.getPageSource().length();
		System.out.println("Length of page source is: " +pageSourceLength);
		
		driver.close();
	}
}
