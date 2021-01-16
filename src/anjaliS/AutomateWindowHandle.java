package anjaliS;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomateWindowHandle {
	static WebDriver driver;

	void start() {
		String browserPath = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", browserPath);
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/anjal/SeleniumTechnoOct2020/resources/forms/Window_Handling_Form.html");
		System.out.println("AutomationByKrishna website open successfully.");
		driver.manage().window().maximize();
	}

	void windowHandle() {
		String mainWindow = driver.getWindowHandle();
		System.out.println("Window ID:" + mainWindow);

		System.out.print("Finding ist button: ");
		WebElement firstButton = driver.findElement(By.xpath("//button[@onclick = 'myFunction()']"));
		firstButton.click();

		Set<String> multipleWindows = driver.getWindowHandles();
		System.out.println("Total windows: " + multipleWindows);
		System.out.println(multipleWindows.size());

		for (String nextWindow : multipleWindows) {
			if (!nextWindow.equals(mainWindow)) {
				driver.switchTo().window(nextWindow);
				System.out.println("Next window: " + nextWindow);
				System.out.println("Switched to next window");
			}
		}
	}

	public static void main(String[] args) {
		AutomateWindowHandle windowhandle = new AutomateWindowHandle();
		windowhandle.start();
		windowhandle.windowHandle();
	}

}
