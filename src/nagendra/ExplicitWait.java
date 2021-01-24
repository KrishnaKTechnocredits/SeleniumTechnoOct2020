package nagendra;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import nagendra.base.PredefinedActions;

/*
Assignment 14
Form: Enable_And_Disable_Display_Hide_Form
Script 1: check element's clickability using explicit wait 
Script 2: check element's visibility using explicit wait
*/

public class ExplicitWait {

	public static WebDriver driver;

	static void verifyElementClickbility() {
		System.out.println("STEP - Click on Enable & Disable Button");
		driver.findElement(By.xpath("//button[text()='Enable & Disable Button']")).click();
		System.out.println("STEP - Apply Explicit wait to driver with ExpectedConditions as elementToBeClickable");
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='myText']"))).click();
	}
	
	static void verifyVisibilityO6fElement(){
		System.out.println("STEP - Click on Visiable & Hidden Button");
		driver.findElement(By.xpath("//button[text()='Visiable & Hidden Button']")).click();
		System.out.println("STEP - Apply Explicit wait to driver With ExpectedConditions as  visibilityOfElementLocated");
		WebDriverWait wait =new WebDriverWait(driver, 4);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='myDIV']")));
		
	}

	public static void main(String[] args) {
		driver = PredefinedActions.start(
				"file://C:/Users/Nagendra/Documents/Training/Training/SeleniumTechnoOct2020/resources/forms/Enable_And_Disable_&_Display_&_Hide_Form.html");
		System.out.println("STEP - Applied Implicit wait to WedDriver");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		verifyElementClickbility();
		System.out.println("STEP - Close The WebDriver");
		driver.close();
	}

}
