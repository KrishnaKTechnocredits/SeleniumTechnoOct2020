package anjaliS;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FillFormFromPropertyFile {
	static WebDriver driver;

	void start() {

		String path = "./resources/windows/chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();

		driver.get("file:///C:/Users/anjal/SeleniumTechnoOct2020/resources/forms/First_Form_4.html");
		System.out.println("Firsform opened successfully.");
		driver.manage().window().maximize();
	}

	void displayFillForm() throws IOException {
		File file = new File("./src/anjaliS/confData.properties");
		FileInputStream inputStream = new FileInputStream(file);

		Properties prop = new Properties();
		prop.load(inputStream);

		System.out.println("First Name entered");
		driver.findElement(By.id("first name")).sendKeys(prop.getProperty("FirstName"));

		System.out.println("Last Name entered");
		driver.findElement(By.id("last name")).sendKeys(prop.getProperty("LastName"));

		System.out.println("E-mail Entered");
		driver.findElement(By.id("E-mail")).sendKeys(prop.getProperty("Email"));

		System.out.println("Company Name Entered");
		driver.findElement(By.id("Company Name")).sendKeys(prop.getProperty("CompanyName"));

		System.out.println("Gender Selected");
		driver.findElement(By.xpath("//input[@id='femaleG' and @value='" + prop.getProperty("Gender") + "']")).click();

		System.out.println("Step: Select Region");
		Select select = new Select(driver.findElement(By.id("continents")));
		select.selectByVisibleText(prop.getProperty("Region"));

		System.out.println("Total year's of experience in industry selected");
		driver.findElement(By.id(prop.getProperty("Experience"))).click();

		System.out.println("Select programming language ");
		driver.findElement(By.id("knownlanguage")).sendKeys(prop.getProperty("ProgrammingLanguage"));

		if (driver.findElement(By.id("python")).isSelected())
			driver.findElement(By.id("python")).click();

		System.out.println("Select anyone programming language ");
		driver.findElement(
				By.xpath("//input[@name='language' and @value='" + prop.getProperty("LanguageToLearn") + "']")).click();

		System.out.println("Select your dream company");
		driver.findElement(By.xpath("//input[@id='google' and @value='" + prop.getProperty("DreamCompany") + "']"))
				.click();

		System.out.println("Click on 'Go and Practice'");
		driver.findElement(By.id("morePractice")).click();
		if (driver.getCurrentUrl().contains("automationbykrishna.com")) {
			System.out.println("Test Passed");
			driver.navigate().back();
		} else
			System.out.println("Test Failed");

		System.out.println("Verify first name field is intact");
		if (driver.findElement(By.id("first name")).getAttribute("value").equals(prop.getProperty("FirstName")))
			System.out.println("Testcase Passed");
		else
			System.out.println("Testcase Failed");
	}

	public static void main(String[] args) throws IOException {
		FillFormFromPropertyFile formfill = new FillFormFromPropertyFile();
		formfill.start();
		formfill.displayFillForm();
		driver.quit();

	}

}