package milind.assignment_12;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {
	
	static WebDriver start(String url) {
		System.out.println("STEP : Launch Browser");
		System.setProperty(ConstantPath.chromeDriverkey,ConstantPath.chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP : Open '" + url + "' URL");
		driver.get(url);
		System.out.println("STEP : Maximize the browser");
		driver.manage().window().maximize();
		System.out.println("STEP : Apply implicit wait");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}

}
