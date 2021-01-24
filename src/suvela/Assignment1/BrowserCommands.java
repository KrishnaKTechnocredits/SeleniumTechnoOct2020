package suvela.Assignment1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserCommands {
	
public void browser() {
	String path="./resources/windows/chromedriver.exe";
	System.setProperty("webdriver.chrome.driver", path);
	WebDriver driver= new ChromeDriver();
	System.out.println("Opening given UrL");
	driver.get("http://www.asana.com");
	
	String url=driver.getCurrentUrl();
	System.out.println("Current URL is:" + url);
	
	String title=driver.getTitle();
	System.out.println("Page title is" + title);
	
	driver.getPageSource();
	
	driver.close();
	
}
public void navigation() {
	String path="./resources/windows/chromedriver.exe";
	System.setProperty("webdriver.chrome.driver", path);
	WebDriver driver= new ChromeDriver();
	
	System.out.println("Navigating to given UrL");
	driver.navigate().to("http://www.google.co.in");
	
	System.out.println("Navigating to back UrL");
	driver.navigate().back();
	
	System.out.println("Navigating to forward UrL");
	driver.navigate().forward();
	
	System.out.println("Refreshing page");
	driver.navigate().refresh();
	driver.quit();
	
}
	public static void main(String[] args) {
		new BrowserCommands().browser();
		new BrowserCommands().navigation();
		
	}

}
