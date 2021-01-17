package ankita.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {
	public static WebDriver start() {
		return start("http://automationbykrishna.com");
	}
	public static WebDriver start(String url) {
		System.out.println("Step : opening browser");
		System.setProperty(ConstantPath.chromeDriverKey, ConstantPath.chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		System.out.println("Step : Navigating to " + url);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		return driver;
	}
}
