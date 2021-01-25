package brijesh.assignments.assignment12;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import brijesh.base.Driver;

/*
Assignment-12: Perform broken link & File uploading scenario
*/

public class BrokenLink {

	public static void main(String[] args) {
		WebDriver driver = Driver.start(
				"F:\\study\\TechnoCredits\\JavaProgram\\SeleniumTechnoOct2020\\resources\\forms\\Broken_Link_Form.html");
		try {
			List<WebElement> webElements = driver.findElements(By.tagName("a"));
			for (WebElement webElement : webElements) {
				String href = webElement.getAttribute("href");
				if (href != null && !href.isEmpty()) {
					URL url = new URL(href);
					HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
					httpCon.connect();
					int statusCode = httpCon.getResponseCode();
					if (statusCode >= 400)
						System.out.println("Broken link: " + webElement.getText());
				} else
					System.out.println("Missing link: " + webElement.getText());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Driver.quit(driver);
		}
	}
}
