package milind.assignment_7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {
	
	static WebDriver start() {
		System.out.println("STEP : Launch Chrome browser");
		System.setProperty(ConstantPath.chromeDriverKey,ConstantPath.chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP : Open 'http://automationbykrishna.com/' URL");
		driver.get("http://automationbykrishna.com/");
		System.out.println("STEP : Maximize the browser");
		driver.manage().window().maximize();
		return driver;
	}

}
