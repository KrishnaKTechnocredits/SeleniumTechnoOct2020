package prasad;

/**Assignment - 16 : 30th Jan'2021*
Go to https://www.goibibo.com/
Click on "Departure"
Validate current selected date in calendar (it should be today's date)
Validate all past dates are disabled(not clickable)
Validate all future dates are selectable(clickable)
Validate presence of >(Next month arrow) and click on it
Click on "14 Feb" departure date
Validate selected date and day
Select "15 Feb" Return date
Validate selected date and day*/

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;

public class DatePicker {
	static WebDriver driver;
	boolean flag;
	String expectedFromCity = "Mumbai";
	String destinationCity = "Vancouver";
	
		
	@Test
	void selectTravelDates() throws InterruptedException {
		driver = StaticResources.start("https://goibibo.com");
		System.out
				.println("Step 1: Validate if " + expectedFromCity + " is present in autocomplete list of From Field");
		System.out.println("Populating From field");
		driver.findElement(By.id("gosuggest_inputSrc")).sendKeys(expectedFromCity);

		WebDriverWait wait = new WebDriverWait(driver, 2);

		List<WebElement> listOfCities = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(
				"//input[@id='gosuggest_inputSrc']//following-sibling::ul/li//div[@class = 'mainTxt clearfix']/span[1]")));
		// Printing the list of elements from autocomplete list & checking if expected
		// city value exist in autocomplete list.
		SoftAssert softassert = new SoftAssert();
		System.out.println("Printing values displayed in autocomplete list");
		for (WebElement element : listOfCities) {
			String city = element.getText();
			System.out.println(city);
			if (city.contains(expectedFromCity)) {
				flag = true;
			}
			softassert.assertTrue(flag);
		}
		softassert.assertAll();
		if (flag) {
			System.out.println(expectedFromCity + " value exist in the autocomplete list");
		}

		System.out.println("Step 2: Select city in From field");
		// Selecting expected city in From field
		driver.findElement(
				By.xpath("//input[@id='gosuggest_inputSrc']//following-sibling::ul/li//span[text()= 'Mumbai, India']"))
				.click();
		System.out.println("Value selected");
		System.out.println(driver.findElement(By.xpath("//input[@id='gosuggest_inputSrc']")).getAttribute("value"));

		System.out.println("Step 3: Enter value in Destination field for search");
		// Entering destination

		driver.findElement(By.xpath("//input[@id = 'gosuggest_inputDest']")).sendKeys(destinationCity);
		Thread.sleep(2000);
		System.out.println("Step 4: Select city in Destination field");
		// Selecting right value from autocomplete list
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//input[@id='gosuggest_inputDest']//following-sibling::ul/li//span[text()= 'Vancouver, Canada']")))
				.click();
		System.out.println("Value selected");
		System.out.println(driver.findElement(By.xpath("//input[@id='gosuggest_inputDest']")).getAttribute("value"));

		System.out.println("Step 5: Get today's date");
		LocalDate date = LocalDate.now();
		String todayDate = date.toString();
		System.out.println(todayDate); // YYYY-MM-DD
		// Spliting date to get YYYY,MM,DD
		String dateSplit[] = todayDate.split("-");
		String day = dateSplit[2];
		String year = dateSplit[0];
		String month = dateSplit[1];

		System.out.println("Step 6: Validate today's date is pre-selected on the date picker");
		
		WebElement element = driver.findElement(
				By.xpath("//div[@class = 'DayPicker-Body']//div[contains(@aria-label,'"+day+""+" "+""+year+"')]"));
		String isSelected = element.getAttribute("aria-selected");

		Assert.assertEquals(isSelected,"true");
		if (isSelected.equals("true"))
			System.out.println("Today's date is pre-selected");
		else
			System.out.println("Today's date is NOT pre-selected");

		// creating hashmap containing key as months and value as number of days in
		// given month

		HashMap<Integer, Integer> noOfDaysInMonth = new HashMap<Integer, Integer>();
		noOfDaysInMonth.put(1, 31);
		noOfDaysInMonth.put(2, 28);
		noOfDaysInMonth.put(3, 31);
		noOfDaysInMonth.put(4, 30);
		noOfDaysInMonth.put(5, 31);
		noOfDaysInMonth.put(6, 30);
		noOfDaysInMonth.put(7, 31);
		noOfDaysInMonth.put(8, 31);
		noOfDaysInMonth.put(9, 30);
		noOfDaysInMonth.put(10, 31);
		noOfDaysInMonth.put(11, 30);
		noOfDaysInMonth.put(12, 31);

		// validating if calender is displaying correct number of days for given month
		
		// converting month of captured today's date into Integer for comparision
		int monthInt = Integer.parseInt(month);
		int expectedNoOfDays = noOfDaysInMonth.get(monthInt);
		System.out.println(
				"Step 7: Validate calender for current month " + monthInt + " is displaying correct number of days");
		// Finding number of days in current month
		List<WebElement> days = driver.findElements(
				By.xpath("//div[@class = 'DayPicker-Body']/div[@class = 'DayPicker-Week']/div[@aria-label]"));
		int actualNoOfDays = days.size();
		System.out.println("Number of days shown in calender for current month: " + actualNoOfDays);
		Assert.assertEquals(actualNoOfDays, expectedNoOfDays);
		System.out.println("Step 8: Validate all past dates are disabled");
		// converting day of captured today's date into Integer so be used as index
		int dayInt = Integer.parseInt(day);
		//If selected day is 1st day of month
		if(dayInt!=1) {
		for (int index = dayInt; index <= 1; index--) {
			WebElement dayElement = days.get(index);
			String isDisabled = dayElement.getAttribute("aria-disabled");
			softassert.assertEquals(isDisabled, "true");
		}
		softassert.assertAll();
		System.out.println("All past dates are disabled");
		}
		else 
			System.out.println("No past dates to validate");
		System.out.println("Step 9: Validate all future dates are selectable");
		int index = dayInt;
		while (index <= actualNoOfDays - 1) {
			WebElement dayElement = days.get(index);
			System.out.println(dayElement.getAttribute("aria-label"));
			String str = dayElement.getAttribute("aria-disabled");
			softassert.assertEquals(str, "false");
			index++;
		}
		softassert.assertAll();
		System.out.println("Step 10: Validate presence of >(Next month arrow) and click on it");
		WebElement button = driver
				.findElement(By.xpath("//span[@class = 'DayPicker-NavButton DayPicker-NavButton--next']"));
		boolean isButtonDisplayed = button.isDisplayed();
		Assert.assertTrue(isButtonDisplayed);
		if (isButtonDisplayed)
			System.out.println("Next button is present");
		button.click();
		System.out.println("Step 11: Select departure date = 14th");
		WebDriverWait waitFrDate = new WebDriverWait(driver, 3);

		waitFrDate.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'calDate'][text()='14']"))).click();
		System.out.println("Step 12: Validate selected date and day in departure date field");
		WebElement dateDay = driver.findElement(By.xpath("//input[@id='departureCalendar']"));
		String dateDayValue = dateDay.getAttribute("value");
		System.out.println(dateDayValue);

		System.out.println("Step 13: Select return date = 15th");
		driver.findElement(By.xpath("//input[@id='returnCalendar']")).click();
		waitFrDate.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'calDate'][text()='15']"))).click();
		dateDay = driver.findElement(By.xpath("//input[@id='returnCalendar']"));
		dateDayValue = dateDay.getAttribute("value");
		System.out.println(dateDayValue);
	}
	
	@AfterMethod
	void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
		
	}
}
