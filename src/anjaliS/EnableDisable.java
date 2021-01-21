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

	void isEnableDisable() {
		System.out.println("Check whether enabled & disabled button is disabled or not");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if (!driver.findElement(By.id("myText")).isEnabled())
			System.out.println("Button is disabled");
		else
			System.out.println("Button is not enabled");

		System.out.println("Click on enable & disable button");
		driver.findElement(By.xpath("//button[@onclick = 'myFunction()']")).click();
		System.out.println("If textbox is disabled, try to call sendkeys method and verify behavior");

		try {
			driver.findElement(By.id("myText")).sendKeys("Anjali");
		} catch (Exception e) {
			System.out.println("Text field is disabled,will not allow to enter anything");
		} finally {
			System.out.println("Second scenario checked");
		}
		String name = "Anjali";
		System.out.println("Click on enable and disable button");
		driver.findElement(By.xpath("//button[@onclick = 'myFunction()']")).click();

		System.out.println("Enter name in Name field");
		driver.findElement(By.id("myText")).sendKeys(name);

		System.out.println("Check:In case of disable button,system is able to send value");
		driver.findElement(By.xpath("//button[@onclick = 'myFunction()']")).click();

		String newName = driver.findElement(By.xpath("//input[@id='myText']")).getAttribute("value");
		if (!newName.equals(name))System.out.println("System is allowing user to enter value in case of button is disabled");

	}

	public static void main(String[] args) {
		driver = Driver.start();
		EnableDisable ed = new EnableDisable();
		ed.isElementVisible();
		ed.isEnableDisable();
		//driver.close();
	}
}
