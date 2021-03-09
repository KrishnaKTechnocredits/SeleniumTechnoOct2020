package suvela.Assignment16;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import suvela.basic.RequiredActions;

public class Goibibo_Calender_Validation {
	static WebDriver driver;

	@BeforeClass
	public void startBrowser() {
		driver = RequiredActions.start("https://www.goibibo.com/");
	}

	@Test(priority = 1)
	public void from_Destination() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Sending pun for auto suggestions");
		driver.findElement(By.xpath("//input[@id='gosuggest_inputSrc']")).sendKeys("pun");
		List<WebElement> fromList = driver.findElements(By
				.xpath("//input[@id='gosuggest_inputSrc']//following-sibling::ul/li//div[@class='mainTxt clearfix']"));
		System.out.println("Printing all automatic suggestions for: Destination From:pun");
		for (WebElement element : fromList) {
			System.out.print(element.getText() + " , ");
		}

		for (WebElement element : fromList) {
			String expected = "Pune, India(PNQ)";
			if (element.getText().equals(expected)) {
				element.click();
				break;
			}

		}
		System.out.println();
		String pune = driver.findElement(By.xpath("//input[@id='gosuggest_inputSrc']")).getAttribute("value");
		Assert.assertEquals(pune, "Pune (PNQ)", "Does not match");
	}

	@Test(priority = 2)
	public void to_Destination() throws InterruptedException {
		System.out.println();
		System.out.println("=============");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Sending go for auto suggestions");
		driver.findElement(By.xpath("//input[@id='gosuggest_inputDest']")).sendKeys("go");
		List<WebElement> toList = driver.findElements(By
				.xpath("//input[@id='gosuggest_inputDest']//following-sibling::ul/li//div[@class='mainTxt clearfix']"));
		System.out.println("Printing all automatic suggestions for: Destination From:go");
		for (WebElement element : toList) {
			System.out.print(element.getText() + " , ");
		}
		for (WebElement element : toList) {
			String expected = "Goa, India(GOI)";
			if (element.getText().equals(expected)) {
				element.click();
				break;
			}
		}
		String goa = driver.findElement(By.xpath("//input[@id='gosuggest_inputDest']")).getAttribute("value");
		System.out.println();
		Assert.assertEquals(goa, "Goa (GOI)", "Does not match");

	}

	@Test(priority = 3)
	public void validate_Date() {
		Date localDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String expDate = formatter.format(localDate);
		System.out.println("Click on Departure Calender");
		driver.findElement(By.xpath("//input[@id='departureCalendar']")).click();
		String todaysDate = driver.findElement(
				By.xpath("//div[@class='DayPicker-Day DayPicker-Day--today DayPicker-Day--selected']/div[@id='fare_"
						+ expDate + "']"))
				.getAttribute("id");

		String actDate = todaysDate.substring(5);
		System.out.println("Verify today's date is auto selected or not..");
		Assert.assertEquals(expDate, actDate, "today's date is not auto selected");
		System.out.println("Verified today's date is auto selected!");
		// String flag=driver.findElement(By.xpath("//div[contains(@class,
		// 'DayPicker')]//div[text()='1']/parent::div")).getAttribute("aria-selected");
		// Assert.assertEquals(flag,"true");
		// System.out.println("Verified today's date is auto selected!");

	}

	@Test(priority = 4)
	public void past_Dates() {
		try {
			driver.findElement(By.xpath(
					"//div[@class='DayPicker-NavBar']/span[contains(@class,'DayPicker-NavButton DayPicker-NavButton--prev')]"))
					.isDisplayed();
		} catch (NoSuchElementException ex) {
			System.out.println("Element not found hence previous Dates can't be booked");
		}
	}

	@Test(priority = 5)
	public void validate_FutureDates() {
		SoftAssert softAssert = new SoftAssert();
		List<WebElement> elements = driver
				.findElements(By.xpath("//div[@class='DayPicker-Day']//following::div[starts-with(@id,'fare_')]"));
		for (WebElement element : elements) {
			softAssert.assertNotEquals(element.getAttribute("aria-disabled"), "true",
					"Error: Date " + element.getText() + " cant be selected. ");
		}
	}

	@Test(priority = 6)
	public void next_Arrow() {
		SoftAssert softAssert = new SoftAssert();
		System.out.println("Click on Departure Calender");
		driver.findElement(By.xpath("//input[@id='departureCalendar']")).click();
		boolean flag = driver.findElement(By.xpath(
				"//div[@class='DayPicker-NavBar']/span[contains(@class,'DayPicker-NavButton DayPicker-NavButton--next')]"))
				.isDisplayed();
		Assert.assertTrue(flag, "Next Arrow is not present");
		System.out.println("Click on Next arrow");
		driver.findElement(By.xpath(
				"//div[@class='DayPicker-NavBar']/span[contains(@class,'DayPicker-NavButton DayPicker-NavButton--next')]"))
				.click();
		
		System.out.println("Click on Departure date 14th March 2021");
		driver.findElement(By.xpath("//div[@aria-label='Sun Mar 14 2021']")).click();
		WebElement element = driver.findElement(By.xpath("//input[@id='departureCalendar']"));
		System.out.println("Validating selected departure date..");
		softAssert.assertEquals(element.getAttribute("value"), "Sun, 14 Mar", "Can't be validated");
		System.out.println("Validated!");
		
		System.out.println("Click on Return Calender");
		System.out.println("Click on return date 15th March 2021");
		driver.findElement(By.xpath("//input[@id='returnCalendar']")).click();;
		driver.findElement(By.xpath("//div[@aria-label='Mon Mar 15 2021']")).click();
		WebElement ele = driver.findElement(By.xpath("//input[@id='returnCalendar']"));
		System.out.println("Validating selected return date..");
		softAssert.assertEquals(ele.getAttribute("value"), "Mon, 15 Mar", "Can't be validated");
		System.out.println("Validated!");
		softAssert.assertAll();
	}
	
	@AfterClass
	public void quit() {
		driver.quit();
		System.out.println("All tests completed with or without error");
	}
}
