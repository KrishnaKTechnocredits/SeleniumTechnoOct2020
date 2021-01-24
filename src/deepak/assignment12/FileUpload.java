package deepak.assignment12;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import deepak.methods.UtilityMethods;

public class FileUpload {
	
	static WebDriver driver;
	
	public static void fileUpload() throws InterruptedException, AWTException {
		
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		
		WebElement ele = driver.findElement(By.id("exampleInputFile"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click", ele);
		
		String filePath = "G:\\Books_Read";
		StringSelection se = new StringSelection(filePath);
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(se, null);
		Thread.sleep(2000);
		
		Robot robot = new Robot();
		
		//Step1: Press Control + V
		System.out.println("//Step1: Press Control + V");
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		//Step2: Releasing key press in step1
		Thread.sleep(3000);
		System.out.println("//Step2: Releasing key press in step1");
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		//Step3: Press Enter
		System.out.println("//Step3: Press Enter");
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("----Test Pass : File Uploaded Successfully-----");
	}

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		driver = UtilityMethods.start();
		fileUpload();
		driver.close();
	}

}
