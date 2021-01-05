package ritika.assignments_1to20.asgmt_01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*Assignment-1 : 05 Jan 2021
Write a program to cover below methods.

b) Navigation cmd:
1) void navigate().to(String url)
2) void navigate().forward()
3) void navigate().back()
4) void navigate().refresh()
*/
public class Selenium_Navigation_Commands {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./resources/windows/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com/");
		
		driver.navigate().to("https://www.facebook.com/");
		String currentURL = driver.getCurrentUrl();
		String expected = "https://www.facebook.com/";
		if(currentURL.equals(expected))
			System.out.println("Navigation successfull");
		
		driver.navigate().back();
		currentURL = driver.getTitle();
		expected = "Google";
		if(currentURL.equals(expected))
			System.out.println("Back operation successfull");
		
		driver.navigate().forward();
		currentURL = driver.getCurrentUrl();
		expected = "https://www.facebook.com/";
		if(currentURL.equals(expected))
			System.out.println("Forward operation successfull");
		
		driver.navigate().refresh();
		currentURL = driver.getCurrentUrl();
		expected = "https://www.facebook.com/";
		if(currentURL.equals(expected))
			System.out.println("Refresh operation successfull");
		
		driver.quit();
	}
}