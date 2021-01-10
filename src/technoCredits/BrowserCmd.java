package technoCredits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserCmd {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./resources/windows/chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // 1 tab
		//1. get()
		driver.get("http://google.co.in");
		
		//2. getTitle()
		String expectedTitle = "Google";
		String actualTitle = driver.getTitle();
		System.out.println("Page title is " + actualTitle);
		if(expectedTitle.equals(actualTitle))
			System.out.println("Test Pass");
		else 
			System.out.println("Test fail while comparing title");
		
		//3. getCurrentUrl()
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL is " + currentUrl);
		
		//4. getPageSource()
		String pageSource = driver.getPageSource();
		//System.out.println(pageSource);
		
		
		//5. close()
		driver.close();
		//driver.getTitle();
		
		//6. quite()
		driver.quit();
		
	}
}
