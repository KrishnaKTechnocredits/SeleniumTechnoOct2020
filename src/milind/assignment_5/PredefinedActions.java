package milind.assignment_5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {
	
	static WebDriver start() {
		System.setProperty(ConstantPath.chromeDriverKey,ConstantPath.chromeDriverPath);
		System.out.println("Launch browser");
		WebDriver driver = new ChromeDriver();
		System.out.println("Open 'resources\\forms\\Enable_And_Disable_&_Display_&_Hide_Form.html' URL");
		driver.get("D:\\Technocredits\\eclipseProject\\Oct2020\\SeleniumTechnoOct2020\\resources\\forms\\Enable_And_Disable_&_Display_&_Hide_Form.html");
		System.out.println("Maximize the Browser window");
		driver.manage().window().maximize();
		System.out.println("=====Implicit Wait");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}
}
