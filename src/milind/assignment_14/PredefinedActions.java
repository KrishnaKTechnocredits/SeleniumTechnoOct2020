package milind.assignment_14;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {
	
	public static WebDriver start(String url) {
		System.out.println("STEP : Launch browser");
		System.setProperty(ConstantPath.chromeDriverKey,ConstantPath.chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP : Open '"+url+"' url");
		driver.get(url);
		System.out.println("STEP : Maximize the browser");
		driver.manage().window().maximize();
		System.out.println("STEP : Add implicit wait");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}

}
