package nandini.Assignment_5;

import technoCredits.base.PredefinedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HideAndDisplay {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.start(
				"G:\\SeleniumOct_2020\\SeleniumTechnoOct2020\\resources\\forms\\Enable_And_Disable_&_Display_&_Hide_Form.html");
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
			element1.sendKeys("Nandini");
			enblDsblBtn.click();

			if (!element1.isEnabled()) {
				if (element1.getAttribute("value").equals("Nandini"))
					System.out.println("Test Passed");
			} else
				System.out.println("Test Failed");
		}
		enblDsblBtn.click();
		element1.clear();
		if (element1.isEnabled()) {
			System.out.println("Step : Entering value ");
			element1.sendKeys("Nandini");
			enblDsblBtn.click();
		}
		System.out.println("Step : Closing browser");
		driver.close();
	}
	}