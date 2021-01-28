package shrutiC.assignment5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import shrutiC.StartWebDriver;

public class EnableDisableForm {

	static WebDriver driver;

	void validateForm() {

		/*
		 * a) if element visible -> gettext and print it and hide the element
		 * and make sure element is no more visible.
		 * 
		 * if element is not visible -> click on visible and hide button ->
		 * gettext and print it -> make sure element is now visible on the page.
		 */
		System.out.println("***********************************************************************************");
		System.out.println("Hide Unhide element validation");
		WebElement element = driver.findElement(By.id("myDIV"));
		WebElement visibleHiddenButton = driver.findElement(By.xpath("//button[text()='Visiable & Hidden Button']"));
		if (element.isDisplayed()) {
			System.out.println("Text of Element: " + element.getText());
			System.out.println("Click on Visiable & Hidden Button - Element must be disabled");
			visibleHiddenButton.click();
			if (!element.isDisplayed())
				System.out.println("Validation passed");
			else
				System.out.println("Validation failed");
		} else {
			visibleHiddenButton.click();
			if (element.isDisplayed()) {
				System.out.println("Text of Element: " + element.getText());
				System.out.println("Validation passed");
			} else
				System.out.println("Validation failed");
		}

		// click on Enbled & Disabled button and verify whether that name
		// inputbox is disabled or not.
		System.out.println("***********************************************************************************");
		System.out.println("Verify if name inputbox gets disabled on clicking on disable button");
		WebElement elementTextBox = driver.findElement(By.id("myText"));
		WebElement enableDisableBtn = driver.findElement(By.xpath("//button[text()='Enable & Disable Button']"));

		enableDisableBtn.click();
		if (!elementTextBox.isEnabled()) {
			System.out.println("Test field disabled, Validation passed");
			System.out.println("Send input to text field - Shruti");
			try {
				elementTextBox.sendKeys("Shruti");
			} catch (Exception e) {
				System.out.println("Cannot Send keys to the disabled element - Validation passed");
			}
		} else
			System.out.println("Test field is not disabled, Validation failed");

		System.out.println("***********************************************************************************");
		System.out.println(
				"Enable text box, send input Shruti, disable it again and validate getAttribute will work even though, element is disabled.");
		enableDisableBtn.click();
		elementTextBox.sendKeys("Shruti");
		enableDisableBtn.click();
		String actualText = elementTextBox.getAttribute("value");
		if (actualText.equals("Shruti"))
			System.out.println(
					"Validation passed - getAttribute works even if element is disabled | Expected name : Shruti | Actual name : "
							+ actualText);

	}

	public static void main(String[] args) {
		try {
			driver = StartWebDriver.start(
					"file:///F:/TechnoCredit_JavaNotes/Workspace/SeleniumTechnoOct2020/resources/forms/Enable_And_Disable_%26_Display_%26_Hide_Form.html");
			new EnableDisableForm().validateForm();
		} catch (Exception e) {

		} finally {
			driver.quit();
		}
	}

}
