package raghvendra;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import raghvendra.base.ConstantAction;

/*Assignment 14

Form: Enable_And_Disable_Display_Hide_Form

Script 1: check element's clickability using explicit wait 
Script 2: check element's visibility using explicit wait
*/public class Explicit_WaitOnEnableDisable {
	WebDriver driver=ConstantAction.start("file:///C:/Java%20Selenium/Oct22/SeleniumTechnoOct2020/resources/forms/Enable_And_Disable_%26_Display_%26_Hide_Form.html");
	void explcitWaitEnableDisable() {
		driver.findElement(By.xpath("//button[@onclick='disable()']")).click();
		WebDriverWait wait=new WebDriverWait(driver,5);
		try {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("myText")));
		}
		catch(TimeoutException time) {
			System.out.println("Textbox is disabled so you are not able to click");
		}

		driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
		//WebElement element=driver.findElement(By.xpath("//button[@onclick='myFunction()']"));
		try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='myDIV']")));
		}
		catch(TimeoutException time) {
			System.out.println("Techno credit element is not visible");
		}
	}
	public static void main(String[] args) {
		Explicit_WaitOnEnableDisable explicit_Wait=new Explicit_WaitOnEnableDisable();
		explicit_Wait.explcitWaitEnableDisable();
	}
}
