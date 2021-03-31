package anjaliS;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTableAutomate {
	static WebDriver driver;

	void findElements() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		System.out.println("Automationbykrishna website is opened successfully");
		driver.get("http://automationbykrishna.com/");

		System.out.println("Click on demotables tab");
		driver.findElement(By.id("demotable")).click();

		System.out.println("How many rows are there in Employee Basic Information Table.");
		List<WebElement> listOfRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		System.out.println("Total number of rows in table employee: " + listOfRows.size());

		System.out.println("Print last name of the employee whose first name is 'Dhara");
		System.out.println(driver
				.findElement(
						By.xpath("//table[@id = 'table1']//td[contains(text(),'Dhara')]//following-sibling::td[1]"))
				.getText());

		System.out.println("Print count of columns in the employee Basic Information table.");
		List<WebElement> listOfColumns = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		System.out.println("Total number of columns in table employee:" + listOfColumns.size());

		for (WebElement element : listOfColumns) {
			System.out.println(element.getText());
		}

		System.out.println("Print first row of Employee basic table");
		System.out.println(driver.findElement(By.xpath("//table[@id='table1']//tr[2]")).getText());

		System.out.println("Print username of all employees");

		List<WebElement> ele = driver.findElements(By.xpath("//table[@id='table1']/tbody//tr"));
		for (int index = 1; index <= ele.size(); index++)
			System.out.println(
					driver.findElement(By.xpath("//table[@id='table1']/tbody//tr[" + index + "]//td[4]")).getText());

		System.out.println("Print first name and last name of all employees");
		List<WebElement> ele1 = driver.findElements(By.xpath("//table[@id='table1']/tbody//tr"));
		for (int index = 1; index <= ele1.size(); index++)
			System.out
					.println(driver.findElement(By.xpath("//table[@id='table1']//tr[" + index + "]//td[2]")).getText());

		List<WebElement> ele2 = driver.findElements(By.xpath("//table[@id='table1']/tbody//tr"));
		for (int index = 1; index <= ele2.size(); index++)
			System.out
					.println(driver.findElement(By.xpath("//table[@id='table1']//tr[" + index + "]//td[3]")).getText());

		System.out.println("how many employees (rows) are there after Dhara");
		System.out.println(driver
				.findElements(By.xpath(
						"//table[@id='table1']//tbody//tr//td[text() = 'Dhara']//parent::tr//following-sibling::tr"))
				.size());
	}

	public static void main(String[] args) throws InterruptedException {
		//driver = Driver.start();
		WebTableAutomate handler = new WebTableAutomate();
		handler.findElements();
	}
}
