package deepak.methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import deepak.path.UtilityPath;

public class UtilityMethods {
	
	public static final WebDriver start() {
		
		System.setProperty(UtilityPath.chromedriver, UtilityPath.chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		return driver;
	}
	
	public static final WebDriver start(String url) {
		
		System.setProperty(UtilityPath.chromedriver, UtilityPath.chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
		
	}
	
}
