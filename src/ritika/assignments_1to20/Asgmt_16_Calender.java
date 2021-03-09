package ritika.assignments_1to20;

/*Assignment - 16 : 30th Jan'2021

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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ritika.base.PredefinedActions;

public class Asgmt_16_Calender {

	WebDriver driver;
	String srcCity = "Pune";
	String destCity = "Indore";

	@Test
	public void validateAutoComplete() {
		driver = PredefinedActions.start("https://www.goibibo.com/");
		System.out.println("Step: website opened successfully");
		System.out.println("Step: Validate source city autocomplete");
		WebElement source = driver.findElement(By.id("gosuggest_inputSrc"));
		source.click();
		source.sendKeys(srcCity);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("react-autosuggest-1")));
		List<WebElement> listOfSrcAutoSuggest = driver.findElements(By.xpath(
				"//input[@id = 'gosuggest_inputSrc']//following-sibling::ul/li//div[@class = 'mainTxt clearfix']/span[1]"));
		System.out.println(
				"Step: Print list of autosuggestions for source and validate expected city is present in the list");
		boolean flag = false;
		for (WebElement element : listOfSrcAutoSuggest) {
			System.out.println(element.getText());
			if (element.getText().contains(srcCity)) {
				flag = true;
			}
		}
		System.out.println("Step: Select source city");
		if (flag)
			driver.findElement(By.xpath(
					"//input[@id = 'gosuggest_inputSrc']//following-sibling::ul/li//div[@class = 'mainTxt clearfix']/span[contains(text(), '"
							+ srcCity + "')]"))
					.click();
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.id("gosuggest_inputSrc")));
		Assert.assertTrue(driver.findElement(By.id("gosuggest_inputSrc")).getAttribute("value").contains(srcCity),
				"Incorrect city has been selected");
		System.out.println("Correct source city has been selected");

		System.out.println("Step: Validate destination city autocomplete");
		WebElement destination = driver.findElement(By.id("gosuggest_inputDest"));
		destination.click();
		destination.sendKeys(destCity);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("react-autosuggest-1")));
		List<WebElement> listOfDestAutoSuggest = driver.findElements(By.xpath(
				"//input[@id = 'gosuggest_inputDest']//following-sibling::ul/li//div[@class = 'mainTxt clearfix']/span[1]"));
		System.out.println(
				"Step: Print list of autosuggestions for destination and validate expected city is present in the list");
		flag = false;
		for (WebElement element : listOfDestAutoSuggest) {
			System.out.println(element.getText());
			if (element.getText().contains(destCity))
				flag = true;
		}
		System.out.println("Select destination city");
		if (flag)
			driver.findElement(By.xpath(
					"//input[@id = 'gosuggest_inputDest']//following-sibling::ul/li//div[@class = 'mainTxt clearfix']/span[contains(text(), '"
							+ destCity + "')]"))
					.click();
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.id("gosuggest_inputDest")));
		Assert.assertTrue(destination.getAttribute("value").contains(destCity), "Incorrect city has been selected");
		System.out.println("Correct Destination is selected");
	}

	@Test(dependsOnMethods = "validateAutoComplete")
	void validateCalenderOperations() throws InterruptedException {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd yyyy");
		String todaysDateAndDay = formatter.format(date);
		System.out.println("Today's Date is: " + todaysDateAndDay);
		String[] todaysDateArr = todaysDateAndDay.split(" ");
		int todaysDate = Integer.parseInt(todaysDateArr[2]);

		System.out.println("Step: Click on Departure date");
		driver.findElement(By.id("departureCalendar")).click();
		WebElement dateSelected = driver
				.findElement(By.xpath("//div[@class='DayPicker-Body']//div[@aria-selected='true']"));
		String selectedDateAndDay = dateSelected.getAttribute("aria-label");
		System.out.println("Step: Validate selected date is today's");
		SoftAssert softassert = new SoftAssert();
		softassert.assertSame(todaysDateAndDay, selectedDateAndDay, "Warning : Selected date is not Today's date");
		System.out.println("Current selected date is today's date");
		int TotalNoOfDays = driver.findElements(By.className("calDate")).size();
		System.out.println("Total number of days in current month are: " + TotalNoOfDays);

		System.out.println("Step: Validate all future dates are enabled");
		for (int i = todaysDate + 1; i <= TotalNoOfDays; i++) {
			String isDisabled = driver
					.findElement(By.xpath("//div[@class='calDate'][text() = '" + i + "']//parent::div[@aria-label]"))
					.getAttribute("aria-disabled");
			softassert.assertTrue(isDisabled.equals("false"), "Date: " + i + " is Disabled but it should be Enabled");
		}

		System.out.println("Step: Validate all past dates are disabled");
		for (int i = todaysDate - 1; i > 0; i--) {
			String isDisabled = driver
					.findElement(By.xpath("//div[@class='calDate'][text() = '" + i + "']//parent::div[@aria-label]"))
					.getAttribute("aria-disabled");
			softassert.assertTrue(isDisabled.equals("true"), "Date: " + i + " is Enabled but it should be Disabled");
		}

		System.out.println("Step: Validate presence of >(Next month arrow) and click on it");
		WebElement nextBtn = driver.findElement(By.xpath("//span[contains(@class , 'NavButton--next')]"));
		softassert.assertTrue(nextBtn.isDisplayed(), "Next month arrow button is not present");
		nextBtn.click();
		Thread.sleep(2000);

		System.out.println(
				"Step: Validate presence of <(Previous month arrow) after clicking on Next month arrow and click on it");
		WebElement prevBtn = driver.findElement(By.xpath("//span[contains(@class , 'NavButton--prev')]"));
		softassert.assertTrue(prevBtn.isDisplayed(), "Previous month arrow button is not present");
		prevBtn.click();

		System.out.println("Step: Click on '14 Feb' as departure date");
		String departDateToSelect = driver.findElement(By.xpath("//div[@id='fare_20210214']//parent::div[@aria-label]"))
				.getAttribute("aria-label");
		String[] departure = departDateToSelect.split(" ");
		driver.findElement(By.id("fare_20210214")).click();
		System.out.println("Step: Validate selected date and day");
		String selDepartDate = driver.findElement(By.id("departureCalendar")).getAttribute("value");
		Assert.assertTrue(selDepartDate.contains(departure[0]) && selDepartDate.contains(departure[1])
				&& selDepartDate.contains(departure[2]), "Selected Departure date is not as expected");

		driver.findElement(By.id("returnCalendar")).click();
		System.out.println("Step: Click on '15 Feb' as return date");
		String returnDateToSelect = driver.findElement(By.xpath("//div[@id='fare_20210215']//parent::div[@aria-label]"))
				.getAttribute("aria-label");
		String[] returnD = returnDateToSelect.split(" ");
		Thread.sleep(2000);
		driver.findElement(By.id("fare_20210215")).click();
		System.out.println("Step: Validate selected date and day");
		String selReturnDate = driver.findElement(By.id("returnCalendar")).getAttribute("value");
		Assert.assertTrue(selReturnDate.contains(returnD[0]) && selReturnDate.contains(returnD[1])
				&& selReturnDate.contains(returnD[2]), "Selected Return date is not as expected");
		driver.close();
	}
}
