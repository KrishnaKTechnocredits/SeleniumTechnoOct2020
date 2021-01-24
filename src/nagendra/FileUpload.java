package nagendra;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import nagendra.base.PredefinedActions;

/*
 Assignment-12: Perform  File uploading scenario
*/
public class FileUpload {
	public static WebDriver driver;
	
	public static void uploadFile() throws AWTException{
		driver.findElement(By.xpath("//li//a[text()='Basic Elements']")).click();
	WebElement element=	driver.findElement(By.xpath("//input[@id='exampleInputFile']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);
	
		String filePath="C:\\Users\\Nagendra\\Downloads\\Capture.PNG";
		StringSelection ss=new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}

	public static void main(String[] args) throws AWTException {
		driver = PredefinedActions.start("http://automationbykrishna.com/#");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		uploadFile();
		driver.close();
	}

}
