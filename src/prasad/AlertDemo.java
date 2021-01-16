package prasad;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*Program - 3 : Go to Basic element page,
a) verify alert message on "Alert demo" form.*/

public class AlertDemo {
	String fName = "Prasad";
	String lName = "Chitale";
	String companyName = "Deloitte Consulting";

	void validateAlertMsg(WebDriver driver) {
		System.out.println("Step: Navigating to basic elements tab");
		driver.findElement(By.xpath("//a[text()='Basic Elements']")).click();

		System.out.println("Step : Populating First Name text field");
		WebElement element = driver.findElement(By.xpath("//input[@name='ufname']"));
		populateTextField(element, fName);

		System.out.println("Step: Populating Last Name text field");
		element = driver.findElement(By.xpath("//input[@name='ulname']"));
		populateTextField(element, lName);

		System.out.println("Step: Populating Company Name text field");
		element = driver.findElement(By.xpath("//input[@name='cmpname']"));
		populateTextField(element, companyName);

		System.out.println("Step: Clicking on submit button");
		driver.findElement(By.xpath(
				"//div[@id='firstRow']/div[@name='secondSegment']/section[@class='panel']/div[@class = 'panel-body']/div[@class='form-group']/button[@type='submit']"))
				.click();

		Alert alert = driver.switchTo().alert();
		String msg = alert.getText();

		if (msg.contains(fName) && msg.contains(lName) && msg.contains(companyName)) {
			System.out.println("Overall test outcome:- Passed: Correct message is displayed");
		} else
			System.out.println("Overall test outcome:- Failed: Incorrect message is displayed");

		alert.accept();
		driver.quit();

	}

	void populateTextField(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	public static void main(String[] arg) {
		AlertDemo alertDemo = new AlertDemo();
		System.out.println("Opening chrome browser and accessing URL");
		WebDriver driver = StaticResources.start();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		alertDemo.validateAlertMsg(driver);
	}

}
