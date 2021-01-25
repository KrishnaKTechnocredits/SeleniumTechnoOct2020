package suvela.Assignment12;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import suvela.basic.RequiredActions;

public class UploadFile {
	static WebDriver driver;
	public void fileUpload() throws InterruptedException, AWTException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Click on Basic elements tab");
		driver.findElement(By.linkText("Basic Elements")).click();
		Thread.sleep(2000);
		System.out.println("Click on choose file");
		WebElement e=	driver.findElement(By.id("exampleInputFile"));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", e);
		Thread.sleep(4000);
		
		String filePath= "C:\\Users\\Lenovo\\Downloads\\Collection Class Properties.pdf";
		
		StringSelection ss= new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		System.out.println("File uploaded successfully");
		driver.close();
	}
	public static void main(String[] args) throws Exception, AWTException {
		driver=RequiredActions.start();
		new UploadFile().fileUpload();
	}

}
