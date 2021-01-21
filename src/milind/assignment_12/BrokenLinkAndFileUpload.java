package milind.assignment_12;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrokenLinkAndFileUpload {
	
	static WebDriver driver;
	
	void getBrokenLinks() throws IOException {
		driver = PredefinedActions.start("D:\\Technocredits\\eclipseProject\\Oct2020\\SeleniumTechnoOct2020\\resources\\forms\\Broken_Link_Form.html");
		System.out.println("STEP : Get all link from web page");
		List<WebElement> listOfLinks = driver.findElements(By.xpath("//a"));
		System.out.println("STEP : Get single link from List");
		for(WebElement link : listOfLinks) {
			if(link.getAttribute("href").isEmpty() || link.getAttribute("href") == null) {
				System.out.println("Link is not present for : " + link.getText());
			}else {
				URL url = new URL(link.getAttribute("href"));
				HttpURLConnection httpConnection = (HttpURLConnection)url.openConnection();
				httpConnection.connect();
				int statusCode = httpConnection.getResponseCode();
				if(statusCode >= 400) {
					System.out.println(link.getText()+ " : " + statusCode);
				}
			}
		}
	}
	
	void fileUploadCode() throws InterruptedException, AWTException {
		
		driver = PredefinedActions.start("http://automationbykrishna.com/");
		System.out.println("STEP : Click on Basic elements");
		driver.findElement(By.id("basicelements")).click();

		Thread.sleep(4000);

		System.out.println("STEP : Chooose file to upload");
		WebElement uploadButtonElement = driver.findElement(By.xpath("//input[@id='exampleInputFile']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", uploadButtonElement);
		String filePath = "D:\\Technocredits\\Study\\Assignments.txt";
		StringSelection ss = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public static void main(String[] args) throws IOException, InterruptedException, AWTException {
		BrokenLinkAndFileUpload brokenLinkAndFileUpload = new BrokenLinkAndFileUpload();
		brokenLinkAndFileUpload.getBrokenLinks();
		driver.close();
		brokenLinkAndFileUpload.fileUploadCode();
		driver.quit();
	}

}
