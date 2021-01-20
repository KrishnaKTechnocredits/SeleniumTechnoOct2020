package milind.assignment_10;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {
	
	static WebDriver start() {
		System.out.println("STEP : Launch Browser");
		System.setProperty(ConstantPath.chromeDriverKey,ConstantPath.chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP : Open 'https://www.naukri.com/' URL" );
		driver.get("https://www.naukri.com/");
		System.out.println("STEP : Maximize the browser");
		driver.manage().window().maximize();
		System.out.println("STEP : Add Implicit wait");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		return driver;
	}

}
