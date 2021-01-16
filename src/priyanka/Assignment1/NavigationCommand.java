package priyanka.Assignment1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Write a program to cover below methods.
b) navigation cmd:
        1) void navigate().to(String url)
        2) void navigate().forward()
        3) void navigate().back()
        4) void navigate().refresh() 
*/

public class NavigationCommand {

	public static void main(String[] args) {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.google.com");
		driver.navigate().to("http://www.facebook.com");
		driver.navigate().back();
		if (driver.getTitle().equals("google"))
			System.out.println("Validated Back");

		driver.navigate().forward();
		if (driver.getTitle().equals("facebook"))
			System.out.println("Validated forward");

		driver.navigate().refresh();
		if (driver.getTitle().equals("facebook"))
			System.out.println("Validated refresh");
		driver.quit();
	}

}
