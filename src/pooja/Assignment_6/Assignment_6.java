/*Assignment - 6 : 13th Jan'2020 
Program 1 : a) fillup the form "First_Form_4" by taking data from properties file
            b) click on "Go and Practice", validate user should navigate to AutomationBykrishna.com
            c) go back in the history, verify firstname field contains the same value which is provided 
            from properties file.*/

package pooja.Assignment_6;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class Assignment_6 {
	static WebDriver driver;

	static void launchBrowser() {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		System.out.println("STEP-Go To WebSite");
		driver.get("file:///F:/JavaPractice_Techno/SeleniumTechnoOct2020/resources/forms/First_Form_4.html");
		System.out.println("Website open successfully.");
		driver.manage().window().maximize();
	}

	static void propertyFileDemo() throws IOException {
		File file = new File("./src/pooja/configData.properties");
		FileInputStream inputStream = new FileInputStream(file);
		Properties property = new Properties();
		property.load(inputStream);

		System.out.println("STEP-Enter First Name");
		driver.findElement(By.xpath("//input[@id='first name']")).sendKeys(property.getProperty("firstname"));
		System.out.println("STEP-Enter Last Name");
		driver.findElement(By.xpath("//input[@id='last name']")).sendKeys(property.getProperty("lastname"));
		System.out.println("STEP-Enter E-mail");
		driver.findElement(By.xpath("//input[@id='E-mail']")).sendKeys(property.getProperty("email"));
		System.out.println("STEP-Enter Company");
		driver.findElement(By.xpath("//input[@id='Company Name']")).sendKeys(property.getProperty("company"));
		String gender = property.getProperty("gender");
		System.out.println("STEP-Select Gender");
		if (gender.equals("Female"))
			driver.findElement(By.xpath("//input[@id='femaleG']")).click();
		else
			driver.findElement(By.xpath("//input[@id='maleG']")).click();
		String cont = property.getProperty("continents");
		System.out.println("STEP-Select Continents");
		WebElement Continents = driver.findElement(By.xpath("//select[@id='continents']"));
		Select selectCont = new Select(Continents);
		if (cont.contains("Asia"))
			selectCont.selectByVisibleText(cont);
		List<WebElement> elements = driver.findElements(By.xpath("//input[@name='experience']"));
		System.out.println("STEP-Select experience");
		for (WebElement exp : elements) {
			if (exp.getAttribute("id").equals(property.getProperty("experience"))) {
				exp.click();
			}
		}
		System.out.println("STEP-Enter Programming Language");
		driver.findElement(By.xpath("//input[@id='knownlanguage']")).sendKeys(property.getProperty("knownlanguage"));
		String languages = property.getProperty("language");
		System.out.println("STEP-Select Languages");
		elements = driver.findElements(By.xpath("//input[@name='language']"));
		for (WebElement lang : elements) {
			String lname = lang.getAttribute("id");
			if (languages.contains(lname))
				lang.click();
		}
		elements = driver.findElements(By.xpath("//input[@name='company']"));
		System.out.println("STEP-Select Dream Company");
		for (WebElement company : elements) {
			if (company.getAttribute("id").equals(property.getProperty("dreamCompany"))) {
				company.click();
			}
		}
		System.out.println("STEP-Click On I selected required option");
		driver.findElement(By.xpath("//input[@id='confirmDetails']")).click();
		System.out.println("STEP-Click on Go and Practice button");
		driver.findElement(By.xpath("//a[text()='Go And Practice For it']")).click();
		String textTitle = driver.getTitle();
		System.out.println("STEP-Title of Current page: " + textTitle);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.navigate().back();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String backHistoryFname = driver.findElement(By.xpath("//input[@id='first name']")).getAttribute("value");
		if (backHistoryFname.equals(property.getProperty("firstname")))
			System.out.println("First Name Is Available");
		else
			System.out.println("First Name Is Not Available");
	}

	public static void main(String[] args) {
		Assignment_6.launchBrowser();
		try {
			Assignment_6.propertyFileDemo();
		} catch (IOException e) {
			System.out.println("Exception Handle");
		}
		driver.close();
	}
}
