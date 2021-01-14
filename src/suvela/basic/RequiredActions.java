package suvela.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

	public class RequiredActions {
	public static WebDriver start() {
		return start("http://automationbykrishna.com");
	}
	
	public static WebDriver start(String url) {
		System.setProperty(ConstantValues.chromeDriverKey, ConstantValues.chromeDriverPath);
		WebDriver driver= new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}
}
