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
Validate selected date and day
*/

package ankita.assignment.assignment16;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ankita.base.PredefinedActions;

public class Calender {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = PredefinedActions.start("https://www.goibibo.com/");
	}

	@Test
	public void verifyCalenderTest() throws ParseException {

		WebDriverWait wait = new WebDriverWait(driver, 30);

		System.out.println("Step : Getting Currentdate");
		DateFormat dateFormat = new SimpleDateFormat("MMMM dd yyyy");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		String[] curDateArr = currentDate.split(" ");
		String expectedDate = curDateArr[0].substring(0, 3) + " " + curDateArr[1] + " " + curDateArr[2];

		System.out.println("Step : Clicking on Departure Date");
		WebElement departureEle = driver.findElement(By.cssSelector("#departureCalendar"));
		departureEle.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".DayPicker")));
		WebElement element = driver.findElement(By.xpath("//div[contains(@aria-label,'" + expectedDate + "')]"));

		System.out.println("Step : Validating current selected date in calendar (it should be today's date)");
		Assert.assertTrue(element.getAttribute("aria-selected").equals("true"), "Today's date is not selected");

		System.out.println("Step : Validate all past dates are disabled(not clickable)");
		List<WebElement> previousDates = driver.findElements(By.xpath("//div[contains(@aria-label,'" + expectedDate
				+ "')]//preceding-sibling::div[@class='DayPicker-Day DayPicker-Day--disabled']"));
		for (WebElement dt : previousDates)
			Assert.assertTrue(dt.getAttribute("aria-disabled").equals("true"), "Previous dates are not disabled");

		System.out.println("Step : Validate all future dates are selectable(clickable)");
		List<WebElement> futureDates = driver.findElements(By
				.xpath("//div[contains(@aria-label,'" + expectedDate + "')]//following::div[@aria-disabled='false']"));
		for (WebElement dt : futureDates)
			Assert.assertTrue(dt.getAttribute("aria-disabled").equals("false"), "Future dates are Clickable");

		System.out.println("Step : Validate presence of >(Next month arrow) and click on it");
		driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();

		System.out.println("Step : Click on \"14 Feb\" departure date ");
		String departureDate = "14";
		driver.findElement(By.xpath("//div[contains(@aria-label,'" + departureDate + "')]")).click();

		System.out.println("Step : Validate selected date and day ");
		String deptDate = driver.findElement(By.xpath("//input[@id='departureCalendar']")).getAttribute("value");
		Assert.assertTrue(deptDate.contains(departureDate), "Wrong departure date is Selected");

		System.out.println("Step : Select \"15 Feb\" Return date ");
		String returnDate = "15";
		driver.findElement(By.xpath("//input[@id='returnCalendar']")).click();
		driver.findElement(By.xpath("//div[contains(@aria-label,'" + returnDate + "')]")).click();

		System.out.println("Step : Validate selected date and day");
		String rtrnDate = driver.findElement(By.xpath("//input[@id='returnCalendar']")).getAttribute("value");
		Assert.assertTrue(rtrnDate.contains(returnDate), "Wrong Return date is Selected");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}