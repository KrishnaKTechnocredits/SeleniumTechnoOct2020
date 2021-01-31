package brijesh.assignments.assignment16;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import brijesh.base.Driver;

/*
Go to https://www.goibibo.com/
Click on "Departure"
Validate current selected date in calendar (it should be today's date)
Validate all past dates are disabled(not clickable)
Validate all future dates are selectable(clickable)
Validate presence of >(Next month arrow) and click on it
Click on "14 Feb" departure date 
Validate selected date and day
Select "15 Feb" Return date
Validate selected date and day
*/

public class Calendar {
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		driver = Driver.start("https://www.goibibo.com/");
	}

	@Test
	public void calendarTest() {
		SoftAssert softAssert = new SoftAssert();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd");  
		LocalDateTime now = LocalDateTime.now();  
		String date = dtf.format(now);
		System.out.println("Step: click on Departure datepicker");
		WebElement departure = driver.findElement(By.id("departureCalendar"));
		departure.click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("DayPicker")));
		
		System.out.println("Step: validate todays date is selected as current date");
		String current = driver.findElement(By.xpath("//div[contains(@class,'DayPicker')]//div[text()='"+date+"']/parent::div")).getAttribute("class");
		softAssert.assertTrue(current.contains("selected"), "Todays date is not selected as current date");
		
		System.out.println("Step: validate all past dates are not clickable");
		List<WebElement> webElements = driver.findElements(By.xpath("//div[contains(@class,'DayPicker')]//div[text()='"+date+"']//preceding::div[starts-with(@id,'fare_')]/parent::div"));
		for (WebElement webElement: webElements) {
			softAssert.assertEquals(webElement.getAttribute("aria-disabled"), "true", "Date "+ webElement.getText()+" is clickable. It shouldn't be");
		}
		
		System.out.println("Step: validate all future dates are clickable");
		webElements = driver.findElements(By.xpath("//div[contains(@class,'DayPicker')]//div[text()='"+date+"']//following::div[starts-with(@id,'fare_')]/parent::div"));
		for (WebElement webElement: webElements) {
			softAssert.assertEquals(webElement.getAttribute("aria-disabled"), "false", "Date "+ webElement.getText()+" is not clickable. It should be");
		}
		
		System.out.println("Step: click on Next(>) arrow");
		driver.findElement(By.className("DayPicker-NavButton")).click();
		
		System.out.println("Step: select date 14 Feb");
		WebElement departureSelected = driver.findElement(By.xpath("//div[contains(@class,'DayPicker')]//div[text()='14']/parent::div"));
		String departureText[] = departureSelected.getAttribute("aria-label").split(" ");
		departureSelected.click();
		
		System.out.println("Step: validate selected departure date");
		String departureSelectedValue = departure.getAttribute("value");
		softAssert.assertTrue(departureSelectedValue.contains(departureText[0]) && departureSelectedValue.contains("14 Feb"), "Invalid selected departure date");
	
		System.out.println("Step: click on Return datepicker");
		WebElement returnElement = driver.findElement(By.id("returnCalendar"));
		returnElement.click();
		
		System.out.println("Step: select date 15 Feb");
		WebElement returnSelected = driver.findElement(By.xpath("//div[contains(@class,'DayPicker')]//div[text()='15']/parent::div"));
		String returnText[] = returnSelected.getAttribute("aria-label").split(" ");
		returnSelected.click();
		
		System.out.println("Step: validate selected return date");
		String returnSelectedValue = returnElement.getAttribute("value");
		softAssert.assertTrue(returnSelectedValue.contains(returnText[0]) && returnSelectedValue.contains("15 Feb"), "Invalid selected return date");
		
		softAssert.assertAll();
	}
	
	@AfterClass
	public void tearDown() {
		Driver.quit(driver);
	}
}
