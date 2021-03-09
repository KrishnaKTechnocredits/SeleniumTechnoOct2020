/*
 * Assignment-12: 
 * Program 1 -Perform broken link
 */


package yogita.Assignment_12;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink {
	static WebDriver driver;

	static void launchBrowser() {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();

		driver.get("E:\\java program\\SeleniumTechnoOct2020\\resources\\forms\\Broken_Link_Form.html");
		System.out.println("AutomationByKrishna website open successfully.");
		driver.manage().window().maximize();
	}

	static void brokenLinks() throws IOException {
		System.out.println("STEP- Finding all the links");
		java.util.List<WebElement> List = driver.findElements(By.xpath("//a"));
		System.out.println("STEP-Checking list is missing or broken");
		for (WebElement list : List) {
			String link = list.getAttribute("href");
			if (link == null || link.isEmpty()) {
				System.out.println("Missing Link is :" + list.getText());
			} else {
				URL url = new URL(link);
				HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
				httpCon.connect();
				int responseCode = httpCon.getResponseCode();
				if (responseCode >= 400) {
					System.out.println(list.getText() + " " + responseCode);
				}
			}
		}
		System.out.println("Test Result-Pass");
	}

	public static void main(String[] args) {
		BrokenLink.launchBrowser();
		try {
			BrokenLink.brokenLinks();
		} catch (IOException e) {
			System.out.println("Exception Handled");
		}
	}
}
