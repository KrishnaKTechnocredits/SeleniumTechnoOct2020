/*Assignment - 1:
Write a program to cover below methods.
b) navigation cmd:
1) void navigate().to(String url)
2) void navigate().forward()
3) void navigate().back()
4) void navigate().refresh()
*/

package ankita.assignment.assignment1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationCmd {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./resources/windows/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.google.com/");
		driver.navigate().to("http://www.facebook.com/");

		driver.navigate().back();
		String expectedTitle = "Google";
		String currentTitle = driver.getTitle();
		if (expectedTitle.equals(currentTitle))
			System.out.println("back on right page");
		else
			System.out.println("back on wrong page");

		driver.navigate().forward();
		String expectedUrl = "https://www.facebook.com/";
		String currentUrl = driver.getCurrentUrl();
		if (expectedUrl.equals(currentUrl))
			System.out.println("On right url");
		else
			System.out.println("On wrong url");

		driver.navigate().refresh();
		String expectedTtl = "Facebook – log in or sign up";
		String currentTtl = driver.getTitle();
		if (expectedTtl.equals(currentTtl))
			System.out.println("Refresed validated");
		else
			System.out.println("Refreshed not validated");

		driver.quit();

	}
}
