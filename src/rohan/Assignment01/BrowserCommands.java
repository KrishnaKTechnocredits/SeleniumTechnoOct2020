package rohan.Assignment01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Browser Commands HandsOn
 * 
 */

public class BrowserCommands {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./resources/windows/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		System.out.println("AutomationByKrishna launched successfully");
		
		String title = driver.getTitle();
		System.out.println("Title of the page is: "+ title);
		
		String url = driver.getCurrentUrl();
		System.out.println("current url is: "+url);
		
		String pageSource = driver.getPageSource();
		if(pageSource != null)
			System.out.println("page source retrieved successfully");
		else
			System.out.println("page source is not retrieved");
		
		driver.close();
		System.out.println("driver instance closed successfully");
	}
}
