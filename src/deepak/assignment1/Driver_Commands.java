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

package deepak.assignment1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver_Commands {

	public static void main(String[] args) {
		
		String expectedUrl = "https://google.com/";
		
		System.setProperty("webdriver.chrome.driver", "./resources/windows/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		//Launching the URL
		driver.get("https://google.com/");
		
		
		//Verifying the current URL
		String currentUrl = driver.getCurrentUrl();
		if(currentUrl.equals(expectedUrl)) {
			System.out.println("Page loaded successfully");
		}
		
		//Verifying the current page title 
		String expectedpageTitle = "Google";
		String currentPageTitle = driver.getTitle();
		if(currentPageTitle.equals(currentPageTitle)) {
			System.out.println("We are on the right page :"+ currentPageTitle);
		}
		
		//Getting the page source
		String pageSource = driver.getPageSource();
		//System.out.println(pageSource);
		if(pageSource.contains(expectedpageTitle)) {
			System.out.println("All checks pass");
		}
		
		driver.close();
	}

}
