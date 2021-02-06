package ankita.assignment.assignment17;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ankita.base.PredefinedActions;

public class FrameHandling {
	static WebDriver driver = PredefinedActions.start();

	public static void handleFrame() throws InterruptedException {
		driver.findElement(By.xpath("//a[@id=\"iframes\"]")).click();
		Thread.sleep(2000);

		System.out.println("BY Index");
		driver.switchTo().frame(2);
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//div[@class='menu']/ul/li[1]/ul/li[1]")).getText());

		System.out.println("BY Value");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("site1");
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//div[@class='banner-message-container']")).getText());

		System.out.println("BY WebElement");

		driver.switchTo().defaultContent();			
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[2]")));
		System.out.println(
				driver.findElement(By.xpath("//div[text()='’s server IP address could not be found.']")).getText());

		System.out.println("Step : Closing browser");
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		handleFrame();
	}
}