package ritika.assignments_1to20.asgmt_17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import ritika.base.PredefinedActions;

public class FrameHandling {

	@Test
	public void validateFrameHandling() throws InterruptedException {
		WebDriver driver = PredefinedActions.start();
		System.out.println("Step: Navigate to iFrame Demo tab");
		driver.findElement(By.id("iframes")).click();
		Thread.sleep(5000);
		System.out.println("Step: Switch to frame1 using name");
		driver.switchTo().frame("site1");
		driver.findElement(By.id("dropdownButton")).click();
		Thread.sleep(2000);
		System.out.println("Step: Switch back to main window");
		driver.switchTo().defaultContent();
		System.out.println("Step: Switch to frame2 using WebElement path");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[2]")));
		System.out.println(
				driver.findElement(By.xpath("//div[text()='’s server IP address could not be found.']")).getText());
		System.out.println("Step: Switch back to main window");
		driver.switchTo().parentFrame();
		System.out.println("Step: Now switch to frame3 using index");
		driver.switchTo().frame(2);
		System.out.println("Verification getText from frame3: "
				+ driver.findElement(By.xpath("//li/span[text() = 'Welcome']")).getText());
		Thread.sleep(2000);
		driver.close();
	}
}
