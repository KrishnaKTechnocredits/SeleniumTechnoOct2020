package shrutiS.assignment12;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrokenLink {
	static WebDriver driver;

	public void findBrokenLink() throws IOException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("link is broken or missing");
		List<WebElement> list = driver.findElements(By.tagName("a"));
		for (WebElement element : list) {
			String link = element.getAttribute("href");
			if (link == null || link.isEmpty()) {
				System.out.println("Link for " + element.getText() + " is Missing ");
			} else {
				URL url = new URL(link);
				HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
				httpcon.connect();
				int statusCode = httpcon.getResponseCode();
				// System.out.println("Link is:"+ link + " and status code is:"+statusCode);
				if (statusCode > 400) {
					System.out.println("Broken link is:" + element.getText() + " Status code:" + httpcon.getResponseCode());
				}
			}
		}
		driver.close();
	}

	public static void main(String[] args) throws IOException {
		//driver = LauchBrowser.start("E:\\SeleniumOCT20\\SeleniumTechnoOct2020\\resources\\forms\\Broken_Link_Form.html");
		new BrokenLink().findBrokenLink();
	}
}
