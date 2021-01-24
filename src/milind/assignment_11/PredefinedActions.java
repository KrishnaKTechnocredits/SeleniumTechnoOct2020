package milind.assignment_11;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {
	
	static WebDriver start() {
		System.out.println("STEP : Launch Browser");
		System.setProperty(ConstantPath.chromeDriverKey,ConstantPath.chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP : Open 'http://automationbykrishna.com/' URL");
		driver.get("http://automationbykrishna.com/");
		System.out.println("STEP : Maximize the browser window");
		driver.manage().window().maximize();
		System.out.println("STEP : Implicitly wait");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		return driver;
	}
}
