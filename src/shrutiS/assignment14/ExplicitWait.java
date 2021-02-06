package shrutiS.assignment14;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import shrutiS.util.LaunchBrowser;

public class ExplicitWait {
	static WebDriver driver ;

	private static void clickableVisibleWait() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Enable & Disable Button']"))).click();
		WebElement inputElement = driver.findElement(By.xpath("//input[@id='myText']"));
		try{
			wait.until(ExpectedConditions.visibilityOf(inputElement)).sendKeys("Hi");
		}
		catch (ElementNotInteractableException e) {
			System.out.println("element is disabled");
		}
	}
		public static void main(String[] args) {
			driver = LaunchBrowser.start("E:\\SeleniumOCT20\\SeleniumTechnoOct2020\\resources\\forms\\Enable_And_Disable_&_Display_&_Hide_Form.html");
			ExplicitWait.clickableVisibleWait();
		}
}
