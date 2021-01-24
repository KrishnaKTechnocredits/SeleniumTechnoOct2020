package priyanka.Assignment6;

/*
Program 1 : a) fillup the form "First_Form_4" by taking data from properties file
           b) click on "Go and Practice", validate user should navigate to AutomationBykrishna.com
           c) go back in the history, verify firstname field contains the same value which is provided from properties file.
*/
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import priyanka.Driver;

public class FillFirstForm4FromPropertyFile {

	public static void main(String[] args) {
		WebDriver driver = Driver.start(
				"D:/Priyanka/Myeclipse_Java_Program/SeleniumTechnoOct2020/resources/forms/First_Form_4.html");
		try {
			File file = new File("./src/priyanka/Basic/configData.properties");
			FileInputStream inputStream = new FileInputStream(file);

			Properties prop = new Properties();
			prop.load(inputStream);

			System.out.println("Step: Enter First Name");
			driver.findElement(By.id("first name")).sendKeys(prop.getProperty("FirstName"));

			System.out.println("Step: Enter Last Name");
			driver.findElement(By.id("last name")).sendKeys(prop.getProperty("LastName"));

			System.out.println("Step: Enter E-mail");
			driver.findElement(By.id("E-mail")).sendKeys(prop.getProperty("Email"));

			System.out.println("Step: Enter Company Name");
			driver.findElement(By.id("Company Name")).sendKeys(prop.getProperty("CompanyName"));

			System.out.println("Step: Select Gender");
			driver.findElement(By.xpath("//input[@name='gender' and @value='" + prop.getProperty("Gender") + "']"))
					.click();

			System.out.println("Step: Select Region");
			Select select = new Select(driver.findElement(By.id("continents")));
			select.selectByVisibleText(prop.getProperty("Region"));

			System.out.println("Step: Select Total Year's of Experience In Industry");
			driver.findElement(By.id(prop.getProperty("Experience"))).click();

			System.out.println("Step: Type Programming Language you know");
			driver.findElement(By.id("knownlanguage")).sendKeys(prop.getProperty("ProgrammingLanguage"));

			System.out.println("Step: Select Programming Language wnated to learn");
			driver.findElement(
					By.xpath("//input[@name='language' and @value='" + prop.getProperty("LanguageToLearn") + "']"))
					.click();

			System.out.println("Step: Select Dream Company");
			driver.findElement(
					By.xpath("//input[@name='company' and @value='" + prop.getProperty("DreamCompany") + "']")).click();

			System.out.println("Step: Click on 'Go and Practice'");
			driver.findElement(By.id("morePractice")).click();
			if (driver.getCurrentUrl().contains("automationbykrishna.com")) {
				System.out.println("Test Passed");
				driver.navigate().back();
			} else
				System.out.println("Test Failed");

			System.out.println("Step: validate first name field is intact");
			if (driver.findElement(By.id("first name")).getAttribute("value").equals(prop.getProperty("FirstName")))
				System.out.println("Test Passed");
			else
				System.out.println("Test Failed");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Driver.quit(driver);
		}
	}

}
