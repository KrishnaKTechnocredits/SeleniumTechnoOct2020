/*Assignment - 1: 
Write a program to cover below methods.
b) navigation cmd:
        1) void navigate().to(String url)
        2) void navigate().forward()
        3) void navigate().back()
        4) void navigate().refresh()*/
package shrutiS.assignment1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationCommands {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/windows/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.facebook.com");
		Thread.sleep(3000);
		driver.navigate().forward();
		System.out.println("navigate forward action doesn't work, forward arrow is disabled on UI");
		driver.navigate().refresh();
		System.out.println("page is refreshing");
		driver.navigate().back();
		System.out.println("back is working fine absoutely");
		driver.navigate().forward();
		System.out.println("navigate forward action working fine now");
	}
}
