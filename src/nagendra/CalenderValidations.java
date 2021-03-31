package nagendra;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import nagendra.base.PredefinedActions;

/*Assignment - 16 : 30th Jan'2021*
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

public class CalenderValidations {

	static public WebDriver driver;

	@Test
	public static void verifyCurrentSelectedDataInCalender() {
		System.out.println("Validate current selected date in calendar (it should be today's date)");
		driver = PredefinedActions.start("https://www.goibibo.com/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.id("departureCalendar")).click();
		WebElement element = driver.findElement(By.xpath(
				"//input[@id='departureCalendar']//following::div[@class='DayPicker-Week']//following-sibling::div[@aria-selected='true']"));
		String day = element.getText();
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
		String strDate = dateFormat.format(date);
		String actualDay;
		if (String.valueOf(strDate.charAt(0)).equals("0")) {
			actualDay = String.valueOf(strDate.charAt(1));

		} else {
			actualDay = String.valueOf(strDate.charAt(0)) + String.valueOf(strDate.charAt(1));
		}
		Assert.assertEquals(day, actualDay);
		driver.close();

	}

	@Test
	public void verifyAllPastDatesAreDisable() {
		System.out.println("Validate all past dates are disabled(not clickable)");
		driver = PredefinedActions.start("https://www.goibibo.com/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.id("departureCalendar")).click();
		List<WebElement> element = driver.findElements(By.xpath(
				"//input[@id='departureCalendar']//following::div[@aria-selected='true']//preceding-sibling::div[@class='DayPicker-Day DayPicker-Day--disabled']"));

		for (WebElement ele : element) {
			Assert.assertEquals(ele.getAttribute("aria-selected"), "false");
		}
		driver.close();
	}

	@Test
	public void verifyAllFutureDatesAreSelectable() {
		System.out.println("Validate all future dates are selectable(clickable)");
		driver = PredefinedActions.start("https://www.goibibo.com/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.id("departureCalendar")).click();
		List<WebElement> list = driver
				.findElements(By.xpath("//input[@id='departureCalendar']//following::div[@aria-disabled='false']"));
		for (WebElement ele : list) {
			Assert.assertEquals(ele.getAttribute("aria-disabled"), "false");
		}
		driver.close();
	}

	@Test()
	public void validateMonthArrowButton() {
		System.out.println("Validate presence of >(Next month arrow) and click on it");
		driver = PredefinedActions.start("https://www.goibibo.com/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.id("departureCalendar")).click();
		WebElement arrowButton = driver
				.findElement(By.xpath("//input[@id='departureCalendar']//following::span[@role='button']"));
		Assert.assertTrue(arrowButton.isDisplayed());
		arrowButton.click();
		driver.close();
	}

	@Test()
	public void clickOnSpecificDepatureDate() {
		System.out.println("Click on " + 14 + " Feb departure date and Validate the date");
		int clickDate = 14;
		driver = PredefinedActions.start("https://www.goibibo.com/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.id("departureCalendar")).click();
		WebElement date = driver.findElement(
				By.xpath("//input[@id='departureCalendar']//following::div[@class='DayPicker-Day']//div[text()="
						+ clickDate + "]"));
		date.click();
		driver.findElement(By.id("departureCalendar")).click();
		String clickedDate = driver
				.findElement(By.xpath("//input[@id='departureCalendar']//following::div[@aria-selected='true']//div"))
				.getText();
		Assert.assertEquals(clickDate, Integer.parseInt(clickedDate));
		driver.close();
	}

	@Test()
	public void clickOnSpecificReturnDate() {
		System.out.println("Click on " + 15 + " Feb Return date and Validate the date");
		int clickDate = 15;
		driver = PredefinedActions.start("https://www.goibibo.com/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.id("returnCalendar")).click();
		WebElement date = driver.findElement(
				By.xpath("//input[@id='departureCalendar']//following::div[@class='DayPicker-Day']//div[text()="
						+ clickDate + "]"));
		date.click();
		driver.findElement(By.id("returnCalendar")).click();
		String clickedDate = driver
				.findElement(By.xpath("//input[@id='departureCalendar']//following::div[@aria-selected='true']//div"))
				.getText();
		Assert.assertEquals(clickDate, Integer.parseInt(clickedDate));
		driver.close();
	}
}
