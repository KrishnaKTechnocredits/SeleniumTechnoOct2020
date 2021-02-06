package shrutiC.assignment6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import shrutiC.StartWebDriver;

public class FillForm {

	static Properties prop = new Properties();
	static WebDriver driver;

	static void readPropertyFile() {
		try {
			File file = new File("./src/shrutiC/confData/Config.properties");
			FileInputStream input = new FileInputStream(file);
			prop.load(input);
		} catch (IOException e) {
			System.out.println("Unable to fetch data from file");
		}
	}

	void enterDetails() {

		String expectedName = prop.getProperty("FirstName");
		System.out.println("Enter First Name : " + expectedName);
		driver.findElement(By.id("first name")).sendKeys(expectedName);

		System.out.println("Enter Last Name");
		driver.findElement(By.id("last name")).sendKeys(prop.getProperty("LastName"));

		System.out.println("Enter E-mail address");
		driver.findElement(By.id("E-mail")).sendKeys(prop.getProperty("Email"));

		System.out.println("Enter Company Name");
		driver.findElement(By.id("Company Name")).sendKeys(prop.getProperty("CompanyName"));

		System.out.println("Select Gender");
		driver.findElement(By.xpath("//input[@name='gender' and @value='" + prop.getProperty("Gender") + "']")).click();

		System.out.println("Select Region");
		Select select = new Select(driver.findElement(By.id("continents")));
		select.selectByVisibleText(prop.getProperty("Region"));

		System.out.println("Select Total Year's of Experience In Industry");
		driver.findElement(By.id(prop.getProperty("Experience"))).click();

		System.out.println("Type Programming Language you know");
		driver.findElement(By.id("knownlanguage")).sendKeys(prop.getProperty("ProgrammingLanguage"));

		System.out.println("Select Programming Language wnated to learn");
		driver.findElement(
				By.xpath("//input[@name='language' and @value='" + prop.getProperty("LanguageToLearn") + "']")).click();

		System.out.println("Select Dream Company");
		driver.findElement(By.xpath("//input[@name='company' and @value='" + prop.getProperty("DreamCompany") + "']"))
				.click();

		// Validate navigation
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("Click on 'Go and Practice' button");
		driver.findElement(By.id("morePractice")).click();
		if (driver.getCurrentUrl().contains("automationbykrishna.com")) {
			System.out.println("User navigation successful to automationbykrishna.com");
			driver.navigate().back();
		} else
			System.out.println("Navigation Failed");

		// Validate the name entered in First name field
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("Validate first name field remains unchanged");
		String actualName = driver.findElement(By.id("first name")).getAttribute("value");

		if (actualName.equals(expectedName))
			System.out.println("Name validation passed");
		else
			System.out
					.println("Name validation failed | Actual : " + actualName + " | Expected name : " + expectedName);
	}

	public static void main(String[] args) {

		try {
			driver = StartWebDriver.start(
					"file:///F:/TechnoCredit_JavaNotes/Workspace/SeleniumTechnoOct2020/resources/forms/First_Form_4.html");
			readPropertyFile();
			new FillForm().enterDetails();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}

}
