package nitin; // Covering here the basic browser commands and Navigation commands
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_1_Basic {
	public static void main(String[] args) {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver = new ChromeDriver(); // This open new Chrome Browser
		// Browser commands
		driver.get("http://google.com");
		System.out.println("Website google.com opened successfully.");
		String title  = driver.getTitle();
		System.out.println("Page Title is "+title);
		//String pageSource = driver.getPageSource();
		//System.out.println("Page Source is "+pageSource);
		String currentURL = driver.getCurrentUrl();
		System.out.println("Current URL is "+currentURL);
		//Browser Navigation Command
		driver.navigate().to("http://gmail.com");  //Navigate to new URL
		String actualTitle  = driver.getTitle();
		String expectedTitle = "Google";
		System.out.println("Page Title is "+actualTitle);
		driver.navigate().back();
			if(title.equals(expectedTitle))
				System.out.println("Pass : Webpage is "+title);
			else
				System.out.println("Fail : Please invstigate.");
		driver.navigate().forward();
		String currentURL1 = driver.getCurrentUrl();
		System.out.println("Current URL is "+currentURL1);
		driver.navigate().refresh();
		System.out.println("Page got refreshed.");
		driver.close();
		System.out.println("Browser Closed..!!");	
		driver.quit();
	}
}
