package anjaliS;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DisplayMissingLink {
	static WebDriver driver;

	void start() {
		String browserPath = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", browserPath);
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/anjal/SeleniumTechnoOct2020/resources/forms/MissingLink.html");
		System.out.println("AutomationByKrishna website open successfully.");
		driver.manage().window().maximize();
	}

	void findElements() {
		List<WebElement> webelements = driver.findElements(By.xpath("//a"));
		System.out.println("Total list: " + webelements.size());

		for (WebElement elements : webelements) {
			System.out.println(elements.getAttribute("href"));
			if (elements.getAttribute("href") == null || elements.getAttribute("href").isEmpty()) {
				System.out.println(elements.getText());
			}
		}
	}

	public static void main(String[] args) {
		DisplayMissingLink link = new DisplayMissingLink();
		link.start();
		link.findElements();

		driver.close();
	}

}
