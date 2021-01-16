package milind.assignment_8;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {
	
	static WebDriver start() throws IOException {
		System.out.println("STEP : Launch chrome browser");
		System.setProperty(ConstantPath.chromeDriverKey,ConstantPath.chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP : Read URL from property file");
		File file = new File("D:\\Technocredits\\eclipseProject\\Oct2020\\SeleniumTechnoOct2020\\src\\milind\\assignment_8\\conData.properties");
		FileInputStream fis = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fis);
		System.out.println("STEP : Open 'resources\\forms\\MissingLink.html' URL");
		driver.get(prop.getProperty("url"));
		System.out.println("STEP : Maximize Browser");
		driver.manage().window().maximize();
		return driver;
	}
}
