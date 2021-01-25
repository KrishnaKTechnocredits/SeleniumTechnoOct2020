package raghvendra;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import raghvendra.base.ConstantAction;
//Assignment-12: Perform broken link & File uploading scenario
public class BrokenLinkFileUpload {
	WebDriver driver=ConstantAction.start("file:///C:/Java%20Selenium/Oct22/SeleniumTechnoOct2020/resources/forms/Broken_Link_Form.html");
	void verifyLinks() throws IOException {
		List<WebElement> linkElement=driver.findElements(By.tagName("a"));
		for(WebElement element:linkElement) {
			if(element.getAttribute("href")==null || element.getAttribute("href").isEmpty())
				System.out.println(element.getText()+"--> has missing Link");
			else
			{
				URL url=new URL(element.getAttribute("href"));
				HttpURLConnection urlcon =(HttpURLConnection) url.openConnection();
				urlcon.connect();
				//urlcon.setConnectTimeout(10);
				int stausCode=urlcon.getResponseCode();
					if(stausCode<300)
						System.out.println(element.getText()+"---> has valid link and status code is :"+stausCode);
					else
						System.out.println(element.getText()+"--> has broken link and status Code:"+stausCode);
					}
		}
			driver.quit();
	}
	
	void verifyFileUpload() throws AWTException {
		WebDriver driver=ConstantAction.url();
		System.out.println("Open automationbykrishna.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Click on Basic element");
		driver.findElement(By.xpath("//a[text()='Basic Elements']")).click();
		System.out.println("Click on Open file");
		WebElement element= driver.findElement(By.xpath("//input[@id='exampleInputFile']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
		String filePath="file:///C:/Users/raghv/Downloads/Collection%20Class%20Properties.pdf";
		System.out.println("select file");
		StringSelection ss=new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot rb=new Robot();
		rb.delay(4000);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);	
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("Attach file");
	}
	public static void main(String[] args) throws IOException, AWTException {
		BrokenLinkFileUpload brokenLinkFileUpload=new BrokenLinkFileUpload();
		brokenLinkFileUpload.verifyLinks();
		brokenLinkFileUpload.verifyFileUpload();
	}
}
