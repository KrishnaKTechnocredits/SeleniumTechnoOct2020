/*
Write a program to cover below methods.
a) Browser Cmd :
		1) void get(String url)
		2) String getCurrentUrl()
		3) String getTitle()
        4) String getPageSource()
        5) void close()
        6) void quit() 
*/
package pooja.Assignment_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserCommand {

	public static void main(String[] args) {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);

		WebDriver webDriver = new ChromeDriver();
		webDriver.get("https://www.google.com/");

		String string = webDriver.getCurrentUrl();
		System.out.println("Current Url Is : " + string);

		String str = webDriver.getTitle();
		System.out.println("Title Is : " + str);

		String pagesource = webDriver.getPageSource();
		// System.out.println("PageSource Is :" + pagesource);
		webDriver.close();

	}
}
