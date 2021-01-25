package anjaliS;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrokerLink {
	static WebDriver driver;

	void isBrokenOrMissingLink() throws IOException {
		System.out.println("Broken link opened successfully");
		driver.get("file:///C:/Users/anjal/SeleniumTechnoOct2020/resources/forms/Broken_Link_Form.html");

		System.out.println();
		List<WebElement> elements = driver.findElements(By.tagName("a"));

		for (WebElement element : elements) {
			String link = element.getAttribute("href");
			if (link == null || link.isEmpty()) {
				System.out.println("Missing link :" + element.getText());
			} else {
				URL url = new URL(link);
				HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
				httpCon.connect();
				int statusCode = httpCon.getResponseCode();

				if (statusCode >= 400) {
					System.out.println(element.getText() + ": " + statusCode);

				}

			}

		}
	}

	void selectFile() throws InterruptedException, AWTException {
		System.out.println("AutomationKrishna link opened successfully");
		driver.get("http://automationbykrishna.com/");

		System.out.println("Click on Basic elements tab");
		driver.findElement(By.id("basicelements")).click();

		Thread.sleep(4000);

		System.out.println("Chooose file to upload");
		WebElement ele = driver.findElement(By.xpath("//input[@id='exampleInputFile']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);
		Thread.sleep(3000);

		String filePath = "file:///C:/Users/anjal/SeleniumTechnoOct2020/resources/forms/Broken_Link_Form.html";

		StringSelection se = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(se, null);// null means every single owner can use
																				// the file

		Robot rb = new Robot();// Currently used to paste path(to perform keyboard action by robot class

		rb.keyPress(KeyEvent.VK_CONTROL);// vk is virtual key
		rb.keyPress(KeyEvent.VK_V);

		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);

		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void main(String[] args) throws IOException, InterruptedException, AWTException {
		driver = Driver.start();
		BrokerLink linkhandler = new BrokerLink();
		linkhandler.isBrokenOrMissingLink();
		driver.quit();
		System.out.println("Broken link closed successfully");
		driver = Driver.start();
		linkhandler.selectFile();
		driver.quit();
		System.out.println("Automationbykrishna website closed successfully");
	}
}
