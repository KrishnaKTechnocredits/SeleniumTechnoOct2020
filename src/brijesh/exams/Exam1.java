package brijesh.exams;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import brijesh.base.*;

public class Exam1 {
	public static void main(String[] args) {
		WebDriver driver = Driver.start();
		try {
			boolean flag = true;
			System.out.println("Step: Navigate to Demo Tables");
			driver.findElement(By.linkText("Demo Tables")).click();
			System.out.println("Step: Validate 'Usernames' of 'EMPLOYEE BASIC INFORMATION' table");
			List<WebElement> webElements = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr"));
			for (WebElement webElement : webElements) {
				String firstName = webElement.findElement(By.xpath("./td[2]")).getText();
				String lastName = webElement.findElement(By.xpath("./td[3]")).getText();
				String userName = webElement.findElement(By.xpath("./td[4]")).getText();
				if (!(firstName.toLowerCase().charAt(0) + lastName.toLowerCase()).equals(userName)) {
					System.out.println("Test Failed!! Usernames are not as per criteria");
					flag = false;
					break;
				}
			}
			if (flag)
				System.out.println("Test Passed!! Validated all Usernames");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Driver.quit(driver);
		}
	}
}
