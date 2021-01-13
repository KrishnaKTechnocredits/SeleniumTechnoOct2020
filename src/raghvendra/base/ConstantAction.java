package raghvendra.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConstantAction {
	public static WebDriver start(String url) {
		System.setProperty(Path.chromeDriver,Path.chromeDriverPath);
		System.out.println("Open Browser");
		WebDriver driver = new ChromeDriver();
		System.out.println(url);
		driver.get(url);
		System.out.println("Maximize browser window");
		driver.manage().window().maximize();
		return driver;
	}
	
	public static WebDriver url() {
		return start("http://automationbykrishna.com/");
	}
}
