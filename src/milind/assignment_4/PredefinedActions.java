package milind.assignment_4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {
	
	static WebDriver start() {
		System.setProperty(ConstantPath.chromeDriverKey, ConstantPath.chromeDriverPath);
		System.out.println("Step : Launch Browser");
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP : Open 'First_Form_4.html' url");
		driver.get("D:\\Technocredits\\eclipseProject\\Oct2020\\SeleniumTechnoOct2020\\resources\\forms\\First_Form_4.html");
		System.out.println("STEP : Maximize the browser window");
		driver.manage().window().maximize();
		System.out.println("=====Implicite wait=====");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}

}
