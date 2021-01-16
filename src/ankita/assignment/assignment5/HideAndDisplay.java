/*
a) if element visible -> gettext and print it and hide the element and make sure element is no more visible.
   if element is not visible -> click on visible and hide button -> gettext and print it -> make sure element is now visible on the page. 
b) click on Enbled & Disabled button and verify whether that name inputbox is disabled or not.
c) once name textbox is disabled, try to call sendkeys method and verify behavior.
d) enabled name textbox -> sendKeys("Maulik") -> turn it to disabled -> getAttribute("value") -> compare text with "Maulik". 
Note : This will prove, getAttribute will work even though, element is disabled. 
*/

package ankita.assignment.assignment5;

import technoCredits.base.PredefinedActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HideAndDisplay {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.start(
				"H:\\JAVA selenium\\Selenium\\SeleniumTechnoOct2020\\resources\\forms\\Enable_And_Disable_&_Display_&_Hide_Form.html");
		System.out.println("=======Program 1=======");
		WebElement element = driver.findElement(By.xpath("//div[@id='myDIV']"));
		WebElement visHidBtn = driver.findElement(By.xpath("//button[text()='Visiable & Hidden Button']"));
		if (element.isDisplayed()) {
			System.out.println("Text from visible block : " + element.getText());
			visHidBtn.click();
			if (!element.isDisplayed())
				System.out.println("Test Passed");
			else
				System.out.println("Test failed");

		} else {
			visHidBtn.click();
			if (element.isDisplayed())
				System.out.println("Test Passed");
			else
				System.out.println("Test Failed");
		}

		System.out.println("=======Program 2=======");
		WebElement element1 = driver.findElement(By.xpath("//input[@id='myText']"));
		WebElement enblDsblBtn = driver.findElement(By.xpath("//button[text()='Enable & Disable Button']"));
		if (element1.isEnabled()) {
			System.out.println("Step : Enter Name");
			element1.sendKeys("Ankita");
			enblDsblBtn.click();

			if (!element1.isEnabled()) {
				if (element1.getAttribute("value").equals("Ankita"))
					System.out.println("Test Passed");
			} else
				System.out.println("Test Failed");
		}
		enblDsblBtn.click();
		element1.clear();
		if (element1.isEnabled()) {
			System.out.println("Step : Entering value ");
			element1.sendKeys("Ankita");
			enblDsblBtn.click();
		}
		System.out.println("Step : Closing browser");
		driver.close();
	}
}