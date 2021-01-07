/*
 Assignment - 1: 
Write a program to cover below methods.

a) Browser Cmd :
		1) void get(String url)
		2) String getCurrentUrl()
		3) String getTitle()
        4) String getPageSource()
        5) void close()
        6) void quit()
 */


package kajol;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BrowserMethods {
	
	public static void main(String[] args) {
		String path="./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver= new ChromeDriver();
		driver.get("https://maps.google.com/");// void get(String url);
		String url=driver.getCurrentUrl();// String getCurrentUrl();
		if(url.contains("google.com/maps"))
			System.out.println("Successfully opened Google Maps");
		String title=driver.getTitle();//String getTitle();
		if(title.contains("Google Maps"))
			System.out.println("Google Maps are displayed here");
		String pageSource=driver.getPageSource();// String getPageSource();
		if(pageSource.contains("<title>Google Maps</title>"))
			System.out.println("Page source reading successfull");
		driver.close();// void close()
		//driver.quit();// void quit()
		
	}

}
