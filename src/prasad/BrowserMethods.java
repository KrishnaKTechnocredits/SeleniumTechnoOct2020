package prasad;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserMethods {

	public static void main(String[] arg) {
		System.setProperty("webdriver.chrome.driver", "./resources/windows/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com/");

		String actualTitle = driver.getTitle();
		String expectedTitle = "Google";

		if (actualTitle.equals(expectedTitle))
			System.out.println("Page title verified sucessfully-Passed");
		else
			System.out.println("Page title not verified sucessfully-Failed");

		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.google.com/";

		if (currentUrl.equals(expectedUrl))
			System.out.println("URL verified sucessfully-Passed");
		else
			System.out.println("URL not verified sucessfully-Failed");
		
		String source = driver.getPageSource();

		driver.quit();

	}
}
