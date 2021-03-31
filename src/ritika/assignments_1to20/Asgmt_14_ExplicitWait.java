package ritika.assignments_1to20;

/*Assignment 14 : 21-Jan-2021

Form: Enable_And_Disable_Display_Hide_Form
Script 1: check element's clickability using explicit wait
Script 2: check element's visibility using explicit wait*/

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ritika.base.PredefinedActions;

public class Asgmt_14_ExplicitWait {
	
	static WebDriver driver;

	static void checkExplicitWait() {
		
		System.out.println("STEP: Check element's clickability using Explicit wait");
		driver.findElement(By.xpath("//button[text() = 'Enable & Disable Button']")).click();
		try {
			WebDriverWait expWait = new WebDriverWait(driver, 3);
			expWait.until(ExpectedConditions.elementToBeClickable(By.id("myText")));
			System.out.println("Element is clickable");
		}catch(TimeoutException te){
			System.out.println("In catch block, expected Exception occured");
			System.out.println("Element is not clickable");
		}
		System.out.println("STEP: Check element's visibility using Explicit wait");
		driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
			try{
				WebDriverWait expWait = new WebDriverWait(driver, 3);
				expWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("myDIV"))));
				System.out.println("Element is visible");
			}catch(TimeoutException te) {
				System.out.println("In catch block, expected Exception occured");
				System.out.println("Element is not visible");
			}
		System.out.println("Operation successfull");
	}
	
	public static void main(String[] args) {
		driver=  PredefinedActions.start("file:///D:/TechnoCredits%20Class%20Oct%202020/Project/SeleniumTechnoOct2020/resources/forms/Enable_And_Disable_&_Display_&_Hide_Form.html");
		checkExplicitWait();
		driver.close();
	}
}
