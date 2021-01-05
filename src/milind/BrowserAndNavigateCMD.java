package milind;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserAndNavigateCMD {
	
	WebDriver driver = null;
	String expectedCurrentUrl;
	String actualCurrentUrl;
	
	void browserLaunch() {
		String chromeExePath = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",chromeExePath);
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
	}
	
	void currentUrlCmd() {
		expectedCurrentUrl = "https://www.google.com/";
		actualCurrentUrl = driver.getCurrentUrl();
		if(expectedCurrentUrl.equals(actualCurrentUrl)) {
			System.out.println("TestCase : Current URL verification : Pass");
		}else {
			System.out.println("TestCase : Current URL verification : fail");
		}
	}
	
	void pageTitleCmd() {
		String expectedCurrentPageTitle = "Google";
		String actualCurrentPageTitle = driver.getTitle();
		if(actualCurrentPageTitle.equals(expectedCurrentPageTitle)) {
			System.out.println("TestCase : Title verification : Pass");
		}else {
			System.out.println("Testcase : Title verification : fail");
		}
	}
	
	void getPageSourceCmd() {
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);
	}
	
	void browserClose() {
		driver.close();
	}
	
	void browserQuite() {
		driver.quit();
	}
	
	void navigateToUrl() {
		driver.navigate().to("https://www.facebook.com");
		expectedCurrentUrl = "https://www.facebook.com/";
		actualCurrentUrl = driver.getCurrentUrl();
		if(actualCurrentUrl.equals(expectedCurrentUrl)) {
			System.out.println("TestCase : Navigate to verification : Pass");
		}else {
			System.out.println("TestCase : Navigate to verification : fail");
		}
	}
	
	void navigateToBack()  {
		driver.navigate().back();
		expectedCurrentUrl = "https://www.google.com/";
		actualCurrentUrl = driver.getCurrentUrl();
		if(actualCurrentUrl.equals(expectedCurrentUrl)) {
			System.out.println("TestCase : Navigate to Back verification : Pass");
		}else {
			System.out.println("TestCase : Navigate to Back verification : Fail");
		}
	}
	
	void navigateToForward() {
		driver.navigate().forward();
		expectedCurrentUrl = "https://www.facebook.com/";
		actualCurrentUrl = driver.getCurrentUrl();
		if(actualCurrentUrl.equals(expectedCurrentUrl)) {
			System.out.println("TestCase : Navigate to Forward verification : Pass");
		}else {
			System.out.println("TestCase : Navigate to forward verification : Fail");
		}
		
	}
	
	
	public static void main(String[] args) {
		BrowserAndNavigateCMD browserAndNavigateCMD = new BrowserAndNavigateCMD();
		browserAndNavigateCMD.browserLaunch();
		browserAndNavigateCMD.currentUrlCmd();
		browserAndNavigateCMD.pageTitleCmd();
		browserAndNavigateCMD.getPageSourceCmd();
		browserAndNavigateCMD.navigateToUrl();
		browserAndNavigateCMD.navigateToBack();
		browserAndNavigateCMD.navigateToForward();
		browserAndNavigateCMD.browserClose();
		browserAndNavigateCMD.browserQuite();
	}
}
