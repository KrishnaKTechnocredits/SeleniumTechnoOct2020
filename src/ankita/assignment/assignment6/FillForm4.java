/*
Assignment - 6 : 13th Jan'2020
Program 1 : a) fillup the form "First_Form_4" by taking data from properties file
b) click on "Go and Practice", validate user should navigate to AutomationBykrishna.com
c) go back in the history, verify firstname field contains the same value which is provided from properties file.
*/
package ankita.assignment.assignment6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import ankita.base.PredefinedActions;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FillForm4 {

	public static void main(String[] args) throws IOException {
		WebDriver driver = PredefinedActions
				.start("H:\\JAVA selenium\\Selenium\\SeleniumTechnoOct2020\\resources\\forms\\First_Form_4.html");
		File file = new File("./src/ankita/base/confData.properties");
		FileInputStream inputStream = new FileInputStream(file);

		Properties prop = new Properties();
		prop.load(inputStream);

		System.out.println("Step : Entering firstname");
		driver.findElement(By.xpath("//input[@id='first name']")).sendKeys(prop.getProperty("firstName"));

		System.out.println("Step : Entering lastname");
		driver.findElement(By.xpath("//input[@id='last name']")).sendKeys(prop.getProperty("lastName"));

		System.out.println("Step : Entering email");
		driver.findElement(By.xpath("//input[@id='E-mail']")).sendKeys(prop.getProperty("email"));

		System.out.println("Step : Entering CompName");
		driver.findElement(By.xpath("//input[@id='Company Name']")).sendKeys(prop.getProperty("compName"));

		System.out.println("Step : Entering Gender");
		driver.findElement(By.xpath("//input[@name='gender' and @value='" + prop.getProperty("gender") + "']")).click();

		System.out.println("Step : Entering Region");
		Select select = new Select(driver.findElement(By.xpath("//select[@id='continents']")));
		select.selectByVisibleText(prop.getProperty("region"));

		System.out.println("Step : Entering experience");
		driver.findElement(By.xpath("//input[@name='experience']")).sendKeys(prop.getProperty("experience"));

		System.out.println("Step : Entering language u know");
		driver.findElement(By.xpath("//input[@id='knownlanguage']")).sendKeys("proLang");

		System.out.println("Step : Entering languages want to learn");
		driver.findElement(By.xpath("//input[@name='language' and @value='" + prop.getProperty("langToLearn") + "']"))
				.click();

		System.out.println("Step : Entering Dream comp");
		driver.findElement(By.xpath("//input[@name='company' and @value='" + prop.getProperty("DreamCompany") + "']"))
				.click();

		System.out.println("Step : Entering go and check ");
		driver.findElement(By.xpath("//a[text()='Go And Practice For it']")).click();
		if (driver.getCurrentUrl().contains("automationbykrishna.com"))
			System.out.println("Test passed");
		else
			System.out.println("Test failed");

		driver.navigate().back();
		System.out.println("Step : validate First field");
		if (driver.findElement(By.xpath("//input[@id='first name']")).getAttribute("value")
				.equals(prop.getProperty("firstName")))
			System.out.println("Test passed");
		else
			System.out.println("Test failed");

		driver.close();
	}
}