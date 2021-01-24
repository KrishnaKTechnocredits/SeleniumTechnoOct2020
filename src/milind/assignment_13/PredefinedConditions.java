package milind.assignment_13;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedConditions {
	
	public static WebDriver start(String url) {
		System.out.println("STEP : Launch Chrome browser ");
		System.setProperty(ConstantPath.chromeDriverKey,ConstantPath.chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP : Open '" +url+ "' URL");
		driver.get(url);
		System.out.println("STEP : Maximize the browser");
		driver.manage().window().maximize();
		System.out.println("STEP : =====Implicit wait=====");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}

}
