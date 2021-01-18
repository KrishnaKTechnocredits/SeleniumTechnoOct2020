package anjaliS;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleNaukriWindow {
	static WebDriver driver;

	void start() {
		String path = "./resources/windows/chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();

		driver.get("http://naukri.com/");
		System.out.println("Naukri 	 website open successfully.");
		driver.manage().window().maximize();
	}

	void handleAllWindows() {
		String getMainWindow = driver.getWindowHandle();
		System.out.println("Handle other windows and switch to main page");
		String titleBeforeSwitch = driver.getTitle();
		Set<String> listOfWindow = driver.getWindowHandles();
		for (String window : listOfWindow) {
			if (!(getMainWindow.equals(window))) {
				driver.switchTo().window(window);
				System.out.println("Closing window title: " + driver.getTitle());
				driver.close();
			}
		}
		System.out.println("Switched to main window");
		driver.switchTo().window(getMainWindow);
		System.out.println("Display title of main window ");
		String afterSwitchTitle = driver.getTitle();
		String handle = driver.getWindowHandle();

		if (titleBeforeSwitch.equals(afterSwitchTitle))
			System.out.println("Passed");
		else
			System.out.println("Failed");
	}

	public static void main(String[] args) {
		HandleNaukriWindow handlewindow = new HandleNaukriWindow();
		handlewindow.start();
		handlewindow.handleAllWindows();
	}

}
