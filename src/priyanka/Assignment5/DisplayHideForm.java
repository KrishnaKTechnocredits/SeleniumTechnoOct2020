package priyanka.Assignment5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import priyanka.Driver;

/*
a) if element visible -> gettext and print it and hide the element and make sure element is no more visible.

if element is not visible -> click on visible and hide button -> gettext and print it -> make sure element is now visible on the page. 

b) click on Enbled & Disabled button and verify whether that name inputbox is disabled or not.

c) once name textbox is disabled, try to call sendkeys method and verify behavior.

d) enabled name textbox -> sendKeys("Maulik") -> turn it to disabled -> getAttribute("value") -> compare text with "Maulik". 

Note : This will prove, getAttribute will work even though, element is disabled. 
*/

public class DisplayHideForm {
	public static void main(String[] args) {
		WebDriver driver = Driver.start(
				"D:/Priyanka/Myeclipse_Java_Program/SeleniumTechnoOct2020/resources/forms/Enable_And_Disable_&_Display_&_Hide_Form.html");
		try {
			System.out.println("Program1: Hide Unhide element");
			WebElement element = driver.findElement(By.id("myDIV"));
			WebElement visibleHiddenButton = driver
					.findElement(By.xpath("//button[text()='Visiable & Hidden Button']"));
			if (element.isDisplayed()) {
				System.out.println("Step: Get Text of Element: " + element.getText());
				visibleHiddenButton.click();
				if (!element.isDisplayed())
					System.out.println("Test Passed");
				else
					System.out.println("Test Failed");
			} else {
				visibleHiddenButton.click();
				if (element.isDisplayed()) {
					System.out.println("Step: Get Text of Element: " + element.getText());
					System.out.println("Test Passed");
				} else
					System.out.println("Test Failed");
			}

			System.out.println("\nProgram2: Hide Unhide element");
			WebElement elementTextBox = driver.findElement(By.id("myText"));
			WebElement enableDisableButton = driver.findElement(By.xpath("//button[text()='Enable & Disable Button']"));
			if (elementTextBox.isEnabled()) {
				System.out.println("Step: Enter Name in textbox: ");
				elementTextBox.sendKeys("Priyanka");
				enableDisableButton.click();
				if (!elementTextBox.isEnabled()) {
					System.out.println("Step: Get value of disabled textbox");
					if (elementTextBox.getAttribute("value").equals("Priyanka"))
						System.out.println("Test Passed");
					enableDisableButton.click();
				} else
					System.out.println("Test Failed");
			}

			if (elementTextBox.isEnabled()) {
				enableDisableButton.click();
				System.out.println("Step: Enter Name in disabled textbox");
				elementTextBox.sendKeys("Priyanka");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Driver.quit(driver);
		}
	}

}
