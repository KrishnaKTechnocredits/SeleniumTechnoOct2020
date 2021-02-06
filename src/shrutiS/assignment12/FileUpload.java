package shrutiS.assignment12;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import shrutiS.base.LauchBrowser;

public class FileUpload {
	static WebDriver driver;

	public void fileUpload() throws AWTException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Click on Basic elements tab");
		driver.findElement(By.linkText("Basic Elements")).click();
		System.out.println("Click on choose file");
		WebElement element = driver.findElement(By.id("exampleInputFile"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
		String filePath = "E:\\SeleniumOCT20\\Assignment Selenium\\Assignment 12.txt";
		StringSelection ss = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("File uploaded successfully");
		//driver.close();
	}

	public static void main(String[] args) throws IOException, AWTException, InterruptedException {
		driver = LauchBrowser.start("http://automationbykrishna.com/");
		new FileUpload().fileUpload();
	}
}
