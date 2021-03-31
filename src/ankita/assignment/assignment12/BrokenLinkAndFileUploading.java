//Assignment-12: Perform broken link & File uploading scenario

package ankita.assignment.assignment12;

import ankita.base.PredefinedActions;

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
import java.net.URL;
import java.util.List;

public class BrokenLinkAndFileUploading {
	static WebDriver driver = PredefinedActions
			.start("H:\\JAVA selenium\\Selenium\\SeleniumTechnoOct2020\\resources\\forms\\Broken_Link_Form.html");

	public static void getBrokenLink() throws IOException {
		List<WebElement> listOFLinks = driver.findElements(By.xpath("//a"));
		for (WebElement element : listOFLinks) {
			String link = element.getAttribute("href");
			if (link == null || link.isEmpty()) {
				System.out.println("Mising Link :" + element.getText());
			} else {
				URL url = new URL(link);
				HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
				httpCon.connect();
				// httpCon.setReadTimeout(4000);
				int sttsCd = httpCon.getResponseCode();
				// System.out.println(element.getText() + "=>" + sttsCd);
				if (sttsCd >= 400)
					System.out.println("Broken Link :" + element.getText() + "=>" + sttsCd);
			}
		}
	}

	public static void uploadFile() throws AWTException, InterruptedException {
		driver.get("http://automationbykrishna.com");
		driver.findElement(By.linkText("Basic Elements")).click();
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.id("exampleInputFile"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);
		Thread.sleep(4000);

		String filePath = "H:\\JAVA selenium\\Class material\\ABC.txt";
		StringSelection ss = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		Robot rbt = new Robot();
		rbt.keyPress(KeyEvent.VK_CONTROL);
		rbt.keyPress(KeyEvent.VK_V);
		rbt.keyRelease(KeyEvent.VK_V);
		rbt.keyRelease(KeyEvent.VK_CONTROL);
		rbt.keyPress(KeyEvent.VK_ENTER);
		rbt.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void main(String[] args) throws IOException, AWTException, InterruptedException {
		getBrokenLink();
		uploadFile();
		System.out.println("Step : Closing Browser");
		driver.close();
	}
}