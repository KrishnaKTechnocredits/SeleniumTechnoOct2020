package raghvendra.TestNG;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.Assert;
import raghvendra.base.ConstantAction;

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
public class ValidateCalendar {
	WebDriver driver=ConstantAction.start("https://www.goibibo.com/");
	@Test
	void checkCalendar() {
		System.out.println("Step 1-Open goibibo Website");
		driver.findElement(By.cssSelector("#departureCalendar")).click();
		System.out.println("Step 2-Click on Departure");
		DateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy");
		Date date = new Date();
		String dateFormatted= dateFormat.format(date);
		System.out.println("Print Today;s date:"+dateFormatted);
		System.out.println("Get selected date");
		String selectedDate=driver.findElement(By.xpath(".//div[contains(@class,'today')] [@aria-selected='true']")).getAttribute("aria-label");
		String computeDate=selectedDate.substring(4);
		System.out.println("Validate current selected date in calendar" );
		Assert.assertEquals(dateFormatted,computeDate );
		System.out.println(computeDate);
		System.out.println("Verify all Past dates are disabled");
		List<WebElement> listOfeElements=driver.findElements(By.xpath(".//div[contains(@aria-label,'Jan')] [@aria-disabled='true'] [@aria-selected='false']"));
		for(WebElement element:listOfeElements) {
			if(!element.getAttribute("aria-disabled").equals("true")) {
				System.out.println("Date is not disabled:"+element.getAttribute("aria-label"));
			}
		}
			
		System.out.println("Verify all future dates are enabled");
		listOfeElements=driver.findElements(By.xpath(".//div[contains(@aria-label,'Jan')] [@aria-disabled='false'] [@aria-selected='false']"));
		for(WebElement element:listOfeElements) {
			if(element.getAttribute("aria-disabled").equals("true")) {
				System.out.println("Date is enabled:"+element.getAttribute("aria-label"));
			}
		}
		System.out.println("Validate presence of >(Next month arrow) and click on it");
		Boolean nextFalg=driver.findElement(By.xpath("//span[contains(@class,'-NavButton--next')]")).isDisplayed();
		Assert.assertTrue(nextFalg);
		driver.findElement(By.xpath("//span[contains(@class,'-NavButton--next')]")).click();
		System.out.println("Click on departure date");
		driver.findElement(By.xpath("//div[contains(@id,'fare_20210214')]")).click();
		WebDriverWait wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='departureCalendar']"))));
		String dateFrom=driver.findElement(By.xpath("//input[@id='departureCalendar']")).getAttribute("value");
		System.out.println("Validate selected date and day");
		Assert.assertEquals("Sun, 14 Feb", dateFrom);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[contains(@id,'returnCalendar')]"))));
		driver.findElement(By.xpath("//input[contains(@id,'returnCalendar')]")).click();
		System.out.println("Click on Return date");
		driver.findElement(By.xpath("//div[contains(@id,'fare_20210215')]")).click();
		String dateTo=driver.findElement(By.xpath("//input[@id='returnCalendar']")).getAttribute("value");
		System.out.println("Validate Return date and day");
		Assert.assertEquals("Mon, 15 Feb", dateTo);
	}
}
