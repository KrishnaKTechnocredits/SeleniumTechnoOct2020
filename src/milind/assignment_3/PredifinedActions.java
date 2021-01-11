package milind.assignment_3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredifinedActions {
	
	static WebDriver start() {
		System.setProperty(ConstantPath.chromeDriverKey,ConstantPath.chromeDriverPath);
		System.out.println("STEP : Open Browser");
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP : Open 'http://automationbykrishna.com/' url");
		driver.get("http://automationbykrishna.com/");
		System.out.println("STEP : Maximize browser window");
		driver.manage().window().maximize();
		System.out.println("=====Implicit wait=====");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		return driver;
	}
}
