package sadhana;

/* a) Browser Cmd :
		1) void get(String url)
		2) String getCurrentUrl()
		3) String getTitle()
        4) String getPageSource()
        5) void close()
        6) void quit() */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser_Cmd {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://unifiedportal-emp.epfindia.gov.in/epfo/");
		System.out.println("EPFO website open successfully");
		String currentURL = driver.getCurrentUrl();
		System.out.println("Current page URL is :" + currentURL);
		String urlTitle = driver.getTitle();
		System.out.println("Current page tile is :" + urlTitle);
		String pageSource = driver.getPageSource();
		System.out.println("Current page source is :" + pageSource);
		driver.close();
		// driver.quit();
	}
}
