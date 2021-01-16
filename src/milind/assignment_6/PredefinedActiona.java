package milind.assignment_6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActiona {
	
	static WebDriver start() {
		System.setProperty(ConstantPath.chromeDriverKey,ConstantPath.chromeDriverPath);
		System.out.println("STEP : Launch Chrome browser");
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP : Open 'First_Form_4.html' URL");
		driver.get("D:\\Technocredits\\eclipseProject\\Oct2020\\SeleniumTechnoOct2020\\resources\\forms\\First_Form_4.html");
		System.out.println("STEP : Maximize the browser");
		driver.manage().window().maximize();
		return driver;
	}
}