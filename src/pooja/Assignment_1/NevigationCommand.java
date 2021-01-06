/*b) navigation cmd:
        1) void navigate().to(String url)
        2) void navigate().forward()
        3) void navigate().back()
        4) void navigate().refresh()*/


package pooja.Assignment_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NevigationCommand {
	
	public static void main(String[] args) {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		System.out.println("Launch Chrome Driver");
		WebDriver webDriver = new ChromeDriver();

		webDriver.get("https://www.google.com/");
		String current_Url = webDriver.getCurrentUrl();
		System.out.println("Current URL Is : " + current_Url);

		webDriver.navigate().to("https://www.facebook.com/");
		String url = webDriver.getCurrentUrl();
		System.out.println("After Nevigation URL IS : " + url);

		webDriver.navigate().back();
		String url_back = webDriver.getCurrentUrl();
		System.out.println("After back URL Is : " + url_back);

		webDriver.navigate().forward();
		String url_forword = webDriver.getCurrentUrl();
		System.out.println("After Forword Url Is : " + url_forword);

		webDriver.navigate().refresh();
		String refresh = webDriver.getCurrentUrl();
		System.out.println("URL Is : " + refresh);
		webDriver.quit();

	}
}
