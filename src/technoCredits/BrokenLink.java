package technoCredits;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import technoCredits.base.PredefinedActions;

public class BrokenLink {

	public static void main(String[] args) throws IOException {
		WebDriver driver = PredefinedActions.start(
				"file:///D:/TechnoCredits/Batches/Oct2020/Projects/SeleniumTechnoOct2020/resources/forms/Broken_Link_Form.html");

		List<WebElement> elements = driver.findElements(By.tagName("a"));

		for (WebElement element : elements) {
			String link = element.getAttribute("href");
			if (link == null || link.isEmpty()) {
				System.out.println("Missing Link : " + element.getText());
			} else {
				URL url = new URL(link);
				HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
				httpCon.connect();
				// httpCon.setConnectTimeout(4000);
				int statusCode = httpCon.getResponseCode();
				// System.out.println(element.getText() + " ---- " + statusCode);
				if (statusCode >= 400) {
					System.out.println(element.getText() + "  ----  " + statusCode);
				}
			}
		}

	}
}
