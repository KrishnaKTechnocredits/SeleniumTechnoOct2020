package anjaliS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EnableDisable {

	static WebDriver driver;

	void isElementVisible() {
		System.out.println("WebPage opened successfully");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		driver.get(
				"file:///C:/Users/anjal/SeleniumTechnoOct2020/resources/forms/Enable_And_Disable_%26_Display_%26_Hide_Form.html");

		if (driver.findElement(By.id("myDIV")).isDisplayed())
			System.out.println("Element visible: " + driver.findElement(By.id("myDIV")).getText());
		else
			System.out.println("Element is not visible");
		System.out.println("Click on visible & hide button");
		driver.findElement(By.xpath("//button[@onclick = 'myFunction()']")).click();

		System.out.println("Firs confirm element is not visible");
		if (!driver.findElement(By.xpath("//div[@id='myDIV']")).isDisplayed())
			System.out.println("Yes element is not visible");

		System.out.println("First scenario checked");
	}

	void isEnableDisable() throws InterruptedException {
		System.out.println("Check whether enabled & disabled button is disabled or not");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if (!driver.findElement(By.id("myText")).isEnabled())
			System.out.println("Button is disabled");
		else
			System.out.println("Button is enabled");

		System.out.println("Click on enable & disable button");
		driver.findElement(By.xpath("//button[@onclick = 'myFunction()']")).click();

		System.out.println("If textbox is enabled, try to call sendkeys method and verify behavior");
		driver.findElement(By.id("myText")).sendKeys("Anjali");
		System.out.println(
				"Second Scenario checked: User is able to enter text in name field incase - enable and disable button is enabled");

		Thread.sleep(3000);
		System.out.println("Click on enable & disable button");
		driver.findElement(By.xpath("//button[@onclick = 'myFunction()']")).click();

		System.out.println("If textbox is disabled, try to call sendkeys method and verify behavior");
		driver.findElement(By.id("myText")).sendKeys("Khushbu");

		System.out.println(
				"Second Scenario checked: User is able to enter text in name field incase - enable and disable button is disbaled");

	}

	public static void main(String[] args) throws InterruptedException {
		driver = Driver.start();
		EnableDisable ed = new EnableDisable();
		ed.isElementVisible();
		ed.isEnableDisable();

	}
}
