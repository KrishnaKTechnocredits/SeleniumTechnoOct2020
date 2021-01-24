package nagendra;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import nagendra.base.PredefinedActions;

/*
Assignment-12: Perform broken link  scenario
*/

public class MissingLink {
	static WebDriver driver;

	public static void getBrokenAndMissingLink() throws IOException {
		List<WebElement> list = driver.findElements(By.xpath("//body//a"));
		for (WebElement element : list) {
			String link = element.getAttribute("href");
			if (link == null || link.isEmpty()) {
				System.out.println("Missing Link:" + element.getText());
			} else {
				URL url = new URL(link);
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.connect();
				int statusCode = con.getResponseCode();
				if (statusCode >= 400) {
					System.out.println(element.getText() + "-" + statusCode);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		driver = PredefinedActions.start(
				"file:///C:/Users/Nagendra/Documents/Training/Training/SeleniumTechnoOct2020/resources/forms/Broken_Link_Form.html");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		getBrokenAndMissingLink();
		driver.close();

	}
}
