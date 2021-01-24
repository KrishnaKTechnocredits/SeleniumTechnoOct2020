package pooja.Assignment_8;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {
	static WebDriver driver;

	void launchBrowser() {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.get("file:///F:/JavaPractice_Techno/SeleniumTechnoOct2020/resources/forms/Window_Handling_Form.html");
		System.out.println("website open successfully.");
		driver.manage().window().maximize();
	}

	void handlingWindow() {
		String mainWindow = driver.getWindowHandle();
		System.out.println("Main Window ID:" + mainWindow);
		System.out.println("STEP-Finding First Window Button");
		WebElement fistButton = driver.findElement(By.xpath("//button[text()='First Window']"));
		System.out.println("Clicking on First Window Button");
		fistButton.click();
		Set<String> multipleWindow = driver.getWindowHandles();
		System.out.println("Total Window:\n" + multipleWindow);
		System.out.println("Total Window Size:" + multipleWindow.size());
		for (String str : multipleWindow) {
			if (!str.equals(mainWindow)) {
				System.out.println("Switching to New Window");
				driver.switchTo().window(str);
				String newWindow = driver.getWindowHandle();
				System.out.println("New window ID is:" + newWindow);
				System.out.println("Switching Done");
			}
		}
	}

	public static void main(String[] args) {
		WindowHandling windowhandle = new WindowHandling();
		windowhandle.launchBrowser();
		windowhandle.handlingWindow();
		driver.quit();
	}
}
