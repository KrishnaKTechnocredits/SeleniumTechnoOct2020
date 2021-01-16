/*Assignment - 1:
Write a program to cover below methods.

a) Browser Cmd :
1) void get(String url)
2) String getCurrentUrl()
3) String getTitle()
4) String getPageSource()
5) void close()
6) void quit()
*/

package ankita.assignment.assignment1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserCmd {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./resources\\windows\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");

		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.google.com/";
		if (currentUrl == expectedUrl)
			System.out.println("On right URL");
		else
			System.out.println("On right URL");

		String currentTitle = driver.getTitle();
		String expectedTitle = "Google";
		if (currentTitle == expectedTitle)
			System.out.println("Correct Title");
		else
			System.out.println("Wrong Title");

		String source = driver.getPageSource();
		// System.out.println(source);
		driver.close();
	}
}