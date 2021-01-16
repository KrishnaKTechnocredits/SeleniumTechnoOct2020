package prasad;

/*Assignment - 6 : 13th Jan'2020
Program 1 : a) fillup the form "First_Form_4" by taking data from properties file
b) click on "Go and Practice", validate user should navigate to AutomationBykrishna.com
c) go back in the history, verify firstname field contains the same value which is provided from properties file.*/
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FillFormPropFile {

	String fName, lName, eMail, companyName, gender, exp, proLangK, langL, dCompany, region;

	public WebDriver start() {
		System.setProperty("webdriver.chrome.driver", "./resources/windows/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get(
				"file:///C:/Users/Prasad%20Chitale/Documents/java_selenium/SeleniumTechnoOct2020/resources/forms/First_Form_4.html");

		return driver;
	}

	void readPropFile() throws IOException {
		File file = new File(
				"C:\\Users\\Prasad Chitale\\Documents\\java_selenium\\SeleniumTechnoOct2020\\src\\prasad\\PropertyFile.properties");
		FileInputStream inputstream = new FileInputStream(file);

		Properties prop = new Properties();
		prop.load(inputstream);
		fName = prop.getProperty("firstName");
		lName = prop.getProperty("lastName");
		eMail = prop.getProperty("e-Mail");
		companyName = prop.getProperty("companyName");
		gender = prop.getProperty("gender");
		region = prop.getProperty("region");
		exp = prop.getProperty("experience");
		proLangK = prop.getProperty("proLangKnown");
		langL = prop.getProperty("langLearn");
		dCompany = prop.getProperty("dreamCompany");
	}

	void fillForm(WebDriver driver) {
		System.out.println("Step: Populate personal details");
		System.out.println("Populating First Name,Last Name,E-Mail,Company Name & Gender");
		driver.findElement(By.xpath("//input[@id='first name']")).sendKeys(fName);
		driver.findElement(By.xpath("//input[@id='last name']")).sendKeys(lName);
		driver.findElement(By.xpath("//input[@id='E-mail']")).sendKeys(eMail);
		driver.findElement(By.xpath("//input[@id='Company Name']")).sendKeys(companyName);

		if (gender.equals("Male")) {
			if (driver.findElement(By.xpath("//input[@id='maleG']")).isSelected()) {
				System.out.println("Gender male is pre-selected");
			} else
				driver.findElement(By.xpath("//input[@id='maleG']")).click();
		} else {
			if (driver.findElement(By.xpath("//input[@id='femaleG']")).isSelected()) {
				System.out.println("Gender female is pre-selected");
			} else
				driver.findElement(By.xpath("//input[@id='femaleG']")).click();
		}
		// Finding picklist and reading all its values.

		WebElement regionElement = driver.findElement(By.xpath("//select[@id='continents']"));

		Select oselect = new Select(regionElement);
		WebElement selectedElement = oselect.getFirstSelectedOption();
		String selectedValue = selectedElement.getAttribute("value");
		List<WebElement> continents = oselect.getOptions();
		System.out.println("Select region value from the picklist");

		if (!selectedValue.equals(region)) {
			if (region.equals("Europe")) {
				oselect.selectByVisibleText("Europe");
			} else if (region.equals("Africa")) {
				oselect.selectByVisibleText("Africa");
			} else if (region.equals("Australia")) {
				oselect.selectByVisibleText("Australia");
			} else if (region.equals("South America")) {
				oselect.selectByVisibleText("South America");
			} else if (region.equals("North America")) {
				oselect.selectByVisibleText("North America");
			} else if (region.equals("Antartica")) {
				oselect.selectByVisibleText("Antartica");
			}
		} else
			System.out.println(selectedValue + " is pre-selected");

		System.out.println("");
		System.out.println("Selecting experience level");
		if (exp.equals("Student")) {
			if (!driver.findElement(By.xpath("//input[@id='student']")).isSelected()) {
				driver.findElement(By.xpath("//input[@id='student']")).click();
			}
		} else if (exp.equals("1-3")) {
			if (!driver.findElement(By.xpath("//input[@id='beginner']")).isSelected()) {
				driver.findElement(By.xpath("//input[@id='beginner']")).click();
			} else
				System.out.println(exp + " is pre-selected");
		} else if (exp.equals("3-6")) {
			if (!driver.findElement(By.xpath("//input[@id='entry']")).isSelected()) {
				driver.findElement(By.xpath("//input[@id='entry']")).click();
			} else
				System.out.println(exp + " is pre-selected");
		} else if (exp.equals("6-10")) {
			if (!driver.findElement(By.xpath("//input[@id='intermidiate']")).isSelected()) {
				driver.findElement(By.xpath("//input[@id='intermidiate']")).click();
			} else
				System.out.println(exp + " is pre-selected");
		} else if (exp.equals("Above 10")) {
			if (!driver.findElement(By.xpath("//input[@id='expert']")).isSelected()) {
				driver.findElement(By.xpath("//input[@id='expert']")).click();
			} else
				System.out.println(exp + " is pre-selected");
		}
		System.out.println("");
		System.out.println("Entering value in programming languages know");
		driver.findElement(By.xpath("//input[@id='knownlanguage']")).sendKeys(proLangK);

		System.out.println("Clearing default seletion for languages want to learn");
		driver.findElement(By.xpath("//input[@id='python']")).click();

		System.out.println("Selecting languages want to learn");
		String[] lang = langL.split(",");
		for (int index = 0; index < lang.length; index++) {
			langL = lang[index];
			if (langL.equals("Java")) {
				if (!driver.findElement(By.xpath("//input[@id='java']")).isSelected()) {
					driver.findElement(By.xpath("//input[@id='java']")).click();
				} else
					System.out.println(langL + " is pre-selected");
			} else if (langL.equals("Python")) {
				if (!driver.findElement(By.xpath("//input[@id='python']")).isSelected()) {
					driver.findElement(By.xpath("//input[@id='python']")).click();
				} else
					System.out.println(langL + " is pre-selected");
			} else if (langL.equals("JavaScript")) {
				if (!driver.findElement(By.xpath("//input[@id='javascript']")).isSelected()) {
					driver.findElement(By.xpath("//input[@id='javascript']")).click();
				} else
					System.out.println(langL + " is pre-selected");
			}

		}
		System.out.println("");
		System.out.println("Selecting dream company");
		driver.findElement(By.xpath("//input[@id='google']")).click();
		System.out.println("Selecting confirmation checkbox");
		driver.findElement(By.xpath("//input[@id='confirmDetails']")).click();
		
		System.out.println("");
		System.out.println("Step: Click on Go And Practice For it button");
		driver.findElement(By.xpath("//a[text()='Go And Practice For it']")).click();
		String title = driver.getTitle();
		if (title.equals("Login Signup Demo")) {
			System.out.println("User navigated to home page");
		}
		
		System.out.println("");
		System.out.println("Step: Navigating back to personal details form page");
		driver.navigate().back();
		
		System.out.println("");
		System.out.println("Step: Validating if previously entered value in First Name field is retained");
		WebElement fNameElement = driver.findElement(By.xpath("//input[@id='first name']"));
		String actualFname = fNameElement.getAttribute("value");
		if (actualFname.equals(fName)) {
			System.out.println("First name value is retained , Over-all test outcome: PASSED");
		} else
			System.out.println("First name value is NOT retained, Over-all test outcome: FAILED");
		
		driver.quit();

	}

	public static void main(String[] arg) throws IOException {

		FillFormPropFile fillform = new FillFormPropFile();
		System.out.println("Step: Opening chrome browser and accessing URL");
		WebDriver driver = fillform.start();
		System.out.println("Step: Reading key values from the properties file");
		fillform.readPropFile();
		fillform.fillForm(driver);

	}

}
