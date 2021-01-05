package prasad;

/*Assignment 1:
 * Write a program to cover below methods.
	
	b) navigation cmd:
		1) void navigate().to(String url)
		2) void navigate().forward()
		3) void navigate().back()
		4) void navigate().refresh()*/
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationMethods {
	static String title1 = "Facebook – log in or sign up";
	static String title2 = "Google";
	static String url2 = "https://www.google.com/";
	static String url1 = "https://www.facebook.com/";

	static boolean verifyTitle(String pageName, String expectedName) {
		if (pageName.equals(expectedName)) {
			return true;
		} else {
			return false;
		}
	}

	static boolean verifyPageUrl(String currentUrl, String expectedUrl) {
		if (currentUrl.equals(expectedUrl)) {
			return true;
		} else {
			return false;
		}
	}

	static void testOutcome(boolean flag1, boolean flag2) {
		if (flag1 && flag2) {
			System.out.println("Passed");
			System.out.println("============================");
		}

		else {
			System.out.println("Failed");
			System.out.println("============================");
		}
	}

	public static void main(String[] arg) {

		System.setProperty("webdriver.chrome.driver", "./resources/windows/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.navigate().to(url1);
		String actualTitle = driver.getTitle();
		System.out.println("Verifying page launch");
		boolean flag1 = NavigationMethods.verifyTitle(actualTitle, title1);
		String currentUrl = driver.getCurrentUrl();
		boolean flag2 = NavigationMethods.verifyPageUrl(currentUrl, url1);
		NavigationMethods.testOutcome(flag1, flag2);

		driver.navigate().to("https://google.com");
		actualTitle = driver.getTitle();
		System.out.println("Verifying page navigation");
		flag1 = NavigationMethods.verifyTitle(actualTitle, title2);
		currentUrl = driver.getCurrentUrl();
		flag2 = NavigationMethods.verifyPageUrl(currentUrl, url2);
		NavigationMethods.testOutcome(flag1, flag2);

		driver.navigate().back();
		actualTitle = driver.getTitle();
		System.out.println("Verifying navigate back");
		flag1 = NavigationMethods.verifyTitle(actualTitle, title1);
		currentUrl = driver.getCurrentUrl();
		flag2 = NavigationMethods.verifyPageUrl(currentUrl, url1);
		NavigationMethods.testOutcome(flag1, flag2);

		driver.navigate().forward();
		actualTitle = driver.getTitle();
		System.out.println("Verifying navigate forward");
		flag1 = NavigationMethods.verifyTitle(actualTitle, title2);
		currentUrl = driver.getCurrentUrl();
		flag2 = NavigationMethods.verifyPageUrl(currentUrl, url2);
		NavigationMethods.testOutcome(flag1, flag2);

		driver.navigate().refresh();
		driver.close();
	}

}
