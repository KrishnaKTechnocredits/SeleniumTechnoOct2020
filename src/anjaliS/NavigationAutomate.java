package anjaliS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationAutomate {
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
		driver.navigate().to("https://www.facebook.com");
		String switchedToWebsite = driver.getCurrentUrl();
		System.out.println("swiched to web page: " + switchedToWebsite);
		driver.navigate().back();
		String backToPreviousPage = driver.getCurrentUrl();
		System.out.println("Back to previous web page: " + backToPreviousPage);
		driver.navigate().forward();
		System.out.println("Back to facebook website");
		driver.navigate().refresh();
		System.out.println("Screen refreshed");

	}
}