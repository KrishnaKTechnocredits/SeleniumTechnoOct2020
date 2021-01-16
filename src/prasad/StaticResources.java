package prasad;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticResources {
	
	static final String path=".//resources/windows/chromedriver.exe";
	static final String setPropertyKey = "webdriver.chrome.driver";
	static String link = "http://automationbykrishna.com/";
	
	static WebDriver start() {
		System.setProperty(setPropertyKey, path);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("URL:- " +link);
		driver.get(link);
		
		return driver;
	}
	
	static WebDriver start(String uRl) {
		link=uRl;
		System.out.println("URL:- " +link);
		WebDriver driver = start();	
		return driver;
	}

}
