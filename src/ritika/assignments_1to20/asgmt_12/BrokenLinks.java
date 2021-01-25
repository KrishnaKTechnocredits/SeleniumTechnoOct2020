package ritika.assignments_1to20.asgmt_12;

//Assignment-12: Perform broken link & File uploading scenario
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ritika.base.PredefinedActions;

public class BrokenLinks {

	static WebDriver driver;

	static void manageBrokenLinks() throws IOException {
		List<WebElement> listOfLinks = driver.findElements(By.tagName("a"));
		System.out.println("Broken Links are ");
		for (WebElement element : listOfLinks) {
			String link = element.getAttribute("href");
			if (link.isEmpty() || link.equals(null))
				System.out.println("Missing link is: " + element.getText());
			else {
				URL url = new URL(link);
				HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
				httpCon.connect();
				int statusCode = httpCon.getResponseCode();
				if (statusCode >= 400)
					System.out.println(element.getText() + " --> " + statusCode);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		driver = PredefinedActions.start(
				"file:///D:/TechnoCredits%20Class%20Oct%202020/Project/SeleniumTechnoOct2020/resources/forms/Broken_Link_Form.html");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		manageBrokenLinks();
		driver.close();
	}
}
