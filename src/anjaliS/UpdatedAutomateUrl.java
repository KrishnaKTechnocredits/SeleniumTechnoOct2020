package anjaliS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdatedAutomateUrl {

	public static void main(String[] args) {
		String browsePath = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", browsePath);
		WebDriver driver = new ChromeDriver();
		System.out.println("Chrome browser opened");
		driver.manage().window().maximize();
		System.out.println("browser maximized");
		driver.get("https://www.google.com");
		String currentSite = driver.getCurrentUrl();
		System.out.println("Current url: " + currentSite);
		String webPageTitle = driver.getTitle();
		System.out.println("Titile of website: " + webPageTitle);
		driver.quit();
		System.out.println("Browser closed");
	}
}
