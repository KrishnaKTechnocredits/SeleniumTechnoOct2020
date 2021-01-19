package technoCredits;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import technoCredits.base.PredefinedActions;

public class FileUploading {

	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver = PredefinedActions.start();
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.id("exampleInputFile"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);

		Thread.sleep(4000);

		String filePath = "C:\\Users\\harsh\\Downloads\\Collection Class Properties.pdf";

		StringSelection ss = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);

		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}
}
