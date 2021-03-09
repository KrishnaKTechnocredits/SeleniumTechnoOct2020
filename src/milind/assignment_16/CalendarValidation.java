package milind.assignment_16;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalendarValidation {
	
	WebDriver driver;
	Properties prop;
	
	public Properties readPropertyFile() throws IOException {
		File file = new File("D:\\Technocredits\\eclipseProject\\Oct2020\\SeleniumTechnoOct2020\\src\\milind\\assignment_16\\dataFile.properties");
		FileInputStream fis = new FileInputStream(file);
		prop = new Properties();
		prop.load(fis);
		return prop;
	}
	
	@Test
	public void calendarValidation() throws IOException, InterruptedException {
		driver = PredefinedActions.start(readPropertyFile().getProperty("url"));
		driver.findElement(By.xpath("//input[@id='departureCalendar']")).click();
		
		//Checking calender is display or not
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='DayPicker DayPicker--en']")).isDisplayed());
		
		//Getting system Date
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String currentDate = formatter.format(date);
		System.out.println(currentDate);
		
		//Adding all Months in Map
		HashMap<String, String> months = new HashMap<String, String>();
		months.put("January", "01");
		months.put("February", "02");
		months.put("March", "03");
		months.put("April", "04");
		months.put("May","05");
		months.put("June", "06");
		months.put("July", "07");
		months.put("August", "08");
		months.put("September", "09");
		months.put("October", "10");
		months.put("November","11");
		months.put("December","12");
		
		//From UI Getting Month and year 
		String calMonthAndYear = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();
		
		//Getting month name from UI text
		String[] spliteCalMonthYear = calMonthAndYear.split(" ");
		System.out.println(calMonthAndYear);
		String monthFromCal = spliteCalMonthYear[0];
		System.out.println(monthFromCal);
		
		//Getting current date from UI
		String currentDateFromUi = driver.findElement(By.xpath("//div[@aria-selected='true']")).getAttribute("aria-label");
		System.out.println(currentDateFromUi);
		String[] spliteCurrentDateFromUi = currentDateFromUi.split(" ");
		String dayFromUi = spliteCurrentDateFromUi[2];
		System.out.println("Date Form Ui " + dayFromUi);
		
		//Getting month from system date
		String[] dateSplite = currentDate.split("/");
		String month = dateSplite[1];
		String day = dateSplite[0];
		System.out.println(month +" : " + day);
		
		//Verify month are same from UI and System are same
		Assert.assertTrue(months.get(monthFromCal).equals(month));
		//Verify current date and month are selected 
		Assert.assertEquals(day, dayFromUi);
		
		//Verify Previous date are Disabled 
		List<WebElement> disabledDates = driver.findElements(By.xpath("//div[contains(@class,'DayPicker')]//div[@aria-label='"+ currentDateFromUi +"']//preceding::div[starts-with(@id,'fare_')]/parent::div"));
		for(WebElement disabledDate : disabledDates) {
			System.out.println("Disabled Date : "+ disabledDate.getAttribute("aria-label"));
			Assert.assertEquals(disabledDate.getAttribute("aria-disabled"), "true");
		}
		
		//Verify Next dates are Enabled
		List<WebElement> enabledDates = driver.findElements(By.xpath("//div[contains(@class,'DayPicker')]//div[@aria-label='"+ currentDateFromUi +"']//following::div[starts-with(@id,'fare_')]/parent::div"));
		for(WebElement enabledDate : enabledDates) {
			System.out.println("Enabled Date : "+ enabledDate.getAttribute("aria-label"));
			Assert.assertEquals(enabledDate.getAttribute("aria-disabled"), "false");
		}
		
		//Check next arrow is enabled or not 
		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).isEnabled(), true);
		
		//Select next months 14 Date
		driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
		String dateLabelFromcalendar = driver.findElement(By.xpath("//div[contains(@id,'fare_') and text()='14']/parent::div")).getAttribute("aria-label");
		driver.findElement(By.xpath("//div[contains(@id,'fare_') and text()='14']")).click();
		String dateFromDepartureTextBox = driver.findElement(By.xpath("//input[@id='departureCalendar']")).getAttribute("value");
		String[] spliteDateFromDepartureTextBox = dateFromDepartureTextBox.split(",");
		System.out.println(dateLabelFromcalendar +" : " +dateFromDepartureTextBox + " : " +spliteDateFromDepartureTextBox[1]);
		Assert.assertTrue(dateLabelFromcalendar.contains(spliteDateFromDepartureTextBox[0]));
		
		//Select next months 15 date
		driver.findElement(By.xpath("//input[@id='returnCalendar']")).click();
		String dateLabelFromcalendar1 = driver.findElement(By.xpath("//div[contains(@id,'fare_') and text()='15']/parent::div")).getAttribute("aria-label");
		driver.findElement(By.xpath("//div[contains(@id,'fare_') and text()='15']")).click();
		String dateFromDepartureTextBox1 = driver.findElement(By.xpath("//input[@id='returnCalendar']")).getAttribute("value");
		String[] spliteDateFromDepartureTextBox1 = dateFromDepartureTextBox1.split(",");
		System.out.println(dateLabelFromcalendar1 +" : " +dateFromDepartureTextBox1 + " : " +spliteDateFromDepartureTextBox1[1]);
		Assert.assertTrue(dateLabelFromcalendar1.contains(spliteDateFromDepartureTextBox1[0]));
		
		Thread.sleep(3000);
		driver.close();
	}

}
