/*Assignment - 8 : Multiwindow_Handle 
 2. Verify that by click on any button on form new window is opening
Note: use Window_Handling Form from resources
 */
package shrutiS.assignment8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultiwindowHandle {
	static WebDriver driver;

	public void windowHandling(WebDriver driver) {
		System.out.println("Click on any button");
		driver.findElement(By.xpath("//button[text()='Third Window']")).click();
		System.out.println("Now check whether new window is popped up or not");
		String id = driver.getWindowHandle();
		if (!id.equals(null))
			System.out.println("Window is popped up with session id:" + id);
		else
			System.out.println("No window popped out");
		driver.quit();
	}

	public static void main(String[] args) {
		//driver = LauchBrowser.start("E:\\SeleniumOCT20\\SeleniumTechnoOct2020\\resources\\forms\\Window_Handling_Form.html");
		new MultiwindowHandle().windowHandling(driver);
	}
}
