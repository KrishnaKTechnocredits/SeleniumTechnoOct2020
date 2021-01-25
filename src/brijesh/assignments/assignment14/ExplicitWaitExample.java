package brijesh.assignments.assignment14;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import brijesh.base.Driver;

/*
Form: Enable_And_Disable_Display_Hide_Form

Script 1: check element's clickability using explicit wait 
Script 2: check element's visibility using explicit wait
*/

public class ExplicitWaitExample {
	static WebDriver driver = Driver.start(
			"F:\\study\\TechnoCredits\\JavaProgram\\SeleniumTechnoOct2020\\resources\\forms\\Enable_And_Disable_&_Display_&_Hide_Form.html");
	static WebDriverWait wait = new WebDriverWait(driver, 10);

	static void waitUntilElementIsClickable() {
		try {
			System.out.println("Script 1: check element's clickability using explicit wait");
			System.out.println("Step: Clicking on 'Enable & Disable Button' to disable textbox");
			WebElement enableDisableButton = driver.findElement(By.xpath("//button[text()='Enable & Disable Button']"));
			enableDisableButton.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("myText")));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	static void waitUntilElementIsVisible() {
		try {
			System.out.println("\nScript 2: Check Elements visibility using explicit wait");
			System.out.println("Step: Clicking on 'Visiable & Hidden Button' to Hide textarea");
			WebElement visibleHiddenButton = driver
					.findElement(By.xpath("//button[text()='Visiable & Hidden Button']"));
			visibleHiddenButton.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myDIV")));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		try {
			waitUntilElementIsClickable();
			waitUntilElementIsVisible();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Driver.quit(driver);
		}
	}
}
