package prasad;

/*Assignment-12: Perform broken link & File uploading scenario*/
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

public class FileUpload {

	private static WebDriver driver;

	void validateLinks() throws IOException {

		List<WebElement> linkList = driver.findElements(By.xpath("//a"));
		for (int index = 0; index < linkList.size(); index++) {
			WebElement element = linkList.get(index);
			System.out.println("Validating response for link " + element.getText());
			String link = element.getAttribute("href");
			if (link != null && !link.isEmpty()) {
				URL url = new URL(link);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				int responseCode = connection.getResponseCode();
				if (responseCode >= 400) {
					System.out.println("Link for " + element.getText() + " is BROKEN" + " : " + responseCode);
				} else
					System.out.println("Link for " + element.getText() + " is OK" + " : " + responseCode);
			} else
				System.out.println("Link is missing for " + element.getText());
		}
	}

	void fileUpload() throws AWTException {
		String filePath = "C:\\Users\\Prasad Chitale\\Documents\\java_selenium\\Notes.txt";
		System.out.println("Go to http://automationbykrishna.com");
		driver.get("http://automationbykrishna.com");
		System.out.println("Navigating to Basic Elements tab");
		driver.findElement(By.linkText("Basic Elements")).click();
		System.out.println("Clicking on choose file button");
		WebElement element = driver.findElement(By.xpath("//input[@id = 'exampleInputFile']"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].click();", element);

		StringSelection se = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(se, null);

		System.out.println("Pasting file path in file name selector text box and pressing enter key");
		Robot ro = new Robot();
		ro.keyPress(KeyEvent.VK_CONTROL);
		ro.keyPress(KeyEvent.VK_V);

		ro.keyRelease(KeyEvent.VK_V);
		ro.keyRelease(KeyEvent.VK_CONTROL);

		ro.keyPress(KeyEvent.VK_ENTER);

	}

	public static void main(String[] arg) throws IOException, AWTException {
		FileUpload file = new FileUpload();
		System.out.println("Step 1 : Verifying broken links using HTML response codes");
		driver = StaticResources.start(
				"file:///C:/Users/Prasad%20Chitale/Documents/java_selenium/SeleniumTechnoOct2020/resources/forms/Broken_Link_Form.html");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		file.validateLinks();
		System.out.println("");
		System.out.println("Step 2: Validating file upload");
		file.fileUpload();

	}

}
