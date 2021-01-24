package brijesh.assignments.assignment12;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import brijesh.base.Driver;

public class FileUploading {

	public static void main(String[] args) {
		WebDriver driver = Driver.start();
		try {
			System.out.println("Step: Navigate to link 'Basic Elements'");
			driver.findElement(By.cssSelector("#basicelements")).click();
			System.out.println("Step: Upload file");
			WebElement fileElement = driver.findElement(By.id("exampleInputFile"));
			JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
			javascriptExecutor.executeScript("arguments[0].click()", fileElement);
			Thread.sleep(3000);
			StringSelection ss = new StringSelection("C:\\Users\\Brijesh\\Downloads\\Java Detailed.docx");
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(ss, null);
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_ENTER);
			System.out.println("Step: Validate file uploaded");
			if(fileElement.getAttribute("value").contains("Java Detailed.docx"))
				System.out.println("Test Passed");
			else
				System.out.println("Test Failed");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Driver.quit(driver);
		}
	}
}
