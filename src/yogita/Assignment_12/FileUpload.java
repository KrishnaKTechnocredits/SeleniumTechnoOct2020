/*
 * Program 2-  File uploading scenario
 */
package yogita.Assignment_12;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {
	static WebDriver driver;

	static void launchBrowser() {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();

		driver.get("http://automationbykrishna.com/");
		System.out.println("Website open successfully.");
		driver.manage().window().maximize();
	}

	static void fileUpload() throws AWTException, InterruptedException {

		System.out.println("Step-Go to Basic Elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//input[@type='file']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click", element);
		Thread.sleep(4000);
		String filePath = "E:\\my java notepad\\Practice";
		StringSelection se = new StringSelection(filePath);
		Thread.sleep(4000);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(se, null);

		Robot robot = new Robot();
		System.out.println("STEP- Press Cntrl + V");
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		System.out.println("STEP-Release Control");
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		System.out.println("STEP-Press ENTER");
		robot.keyPress(KeyEvent.VK_ENTER);
		System.out.println("STEP-Release ENTER");
		robot.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("Test Result - File Uploaded Successfully --> Pass");
	}

	public static void main(String[] args) {
		FileUpload.launchBrowser();
		try {
			FileUpload.fileUpload();
		} catch (AWTException e) {
			System.out.println("AWT Exception Handled");
		} catch (InterruptedException e) {
			System.out.println("Interrupted Exception Handled");

		}
		System.out.println("STEP-Closing Browser");
		driver.close();
	}

}
