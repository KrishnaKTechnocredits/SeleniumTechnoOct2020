package ritika.assignments_1to20.asgmt_12;

//Assignment-12: Perform broken link & File uploading scenario
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ritika.base.PredefinedActions;

public class FileUploading {

	static WebDriver driver;

	static void manageFileUploading() throws AWTException, InterruptedException {
		Thread.sleep(3000);
		WebElement ele = driver.findElement(By.id("exampleInputFile"));
		Thread.sleep(3000);
		System.out.println("Step: Click on file choose button");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);
		Thread.sleep(4000);
		String filePath = "C:\\Users\\sony\\Downloads\\Photo.jpg";
		System.out.println("Step: Enter file path in windows pop up textbox");
		StringSelection ss = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Thread.sleep(2000);
		Robot robot = new Robot();
		System.out.println("Step: Perform Ctrl+V operation");
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(3000);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		System.out.println("Step: Press Enter");
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("File Upload Successfull");
	}

	public static void main(String[] args) throws AWTException, InterruptedException {
		driver = PredefinedActions.start();
		driver.findElement(By.linkText("Basic Elements")).click();
		manageFileUploading();
		driver.quit();
	}

}
