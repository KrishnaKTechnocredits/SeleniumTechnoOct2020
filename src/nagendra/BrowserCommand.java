package nagendra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
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
		driver.get("http://www.facebook.com");
		driver.get("http://www.google.com");
		String pageSource = driver.getPageSource();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		// System.out.println(pageSource);
		if (title.equals("Google"))
			System.out.println("Tital is Validated");
		System.out.println("URL is " + url);
		driver.close();
		driver.quit();
	}

}
