/*
 Program_2
 Write a program to cover below methods.
a) Browser Cmd :
		1) void get(String url)
		2) String getCurrentUrl()
		3) String getTitle()
        4) String getPageSource()
        5) void close()
        6) void quit()
 */

package yogita.Assignment_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserCommand {
	public static void main(String[] args) {

		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);

		System.out.println("STEP- Launch Chrome Driver");
		WebDriver driver = new ChromeDriver();

		System.out.println("STEP- Launching  Google Page");
		driver.get("https://www.google.com/");

		System.out.println("STEP-Get Current URL");
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL is:" + currentUrl);

		System.out.println("STEP- Get Title");
		String getTitle = driver.getTitle();
		System.out.println("Title is:" + getTitle);

		/*
		 * System.out.println("STEP- Get Page Source"); String pageSource =
		 * driver.getPageSource(); System.out.println("Page Source Is:" + pageSource);
		 */

		System.out.println("STEP-Closing Browser");
		driver.close();
	}

}
