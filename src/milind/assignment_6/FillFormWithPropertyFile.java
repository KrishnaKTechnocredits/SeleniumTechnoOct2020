package milind.assignment_6;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class FillFormWithPropertyFile {
	
	WebDriver driver = PredefinedActiona.start();
	static Properties prop;
	
	Properties readPropertyFile() throws IOException {
		System.out.println("STEP : Reading File");
		File file = new File("D:\\Technocredits\\eclipseProject\\Oct2020\\SeleniumTechnoOct2020\\src\\milind\\assignment_6\\conData.properties");
		System.out.println("STEP : File open in read mode");
		FileInputStream fis = new FileInputStream(file);
		prop = new Properties();
		System.out.println("STEP : Loading file");
		prop.load(fis);
		return prop;
	}
	
	void fillForm() throws IOException {
		prop = readPropertyFile();
		System.out.println("STEP : Enter first name");
		driver.findElement(By.xpath("//input[@id='first name']")).sendKeys(prop.getProperty("firstName"));
		System.out.println("STEP : Enter last name");
		driver.findElement(By.xpath("//input[@id='last name']")).sendKeys(prop.getProperty("lastName"));
		System.out.println("STEP : Enter Email");
		driver.findElement(By.xpath("//input[@id='E-mail']")).sendKeys(prop.getProperty("email"));
		System.out.println("STEP : Enter company name");
		driver.findElement(By.xpath("//input[@id='Company Name']")).sendKeys(prop.getProperty("companyName"));
		System.out.println("STEP : Select Gender");
		String genderFromFile = prop.getProperty("gender");
		if(genderFromFile.equals("Male")) {
			System.out.println("STEP : Select Male as Gender");
			driver.findElement(By.xpath("//input[@id='maleG']")).click();
		}else {
			System.out.println("STEP : Select Female as Gender");
			driver.findElement(By.xpath("//input[@id='femaleG']")).click();
		}
		System.out.println("STEP : Select region from Dropdown");
		Select select = new Select(driver.findElement(By.xpath("//select[@id='continents']")));
		select.selectByVisibleText(prop.getProperty("region"));
		System.out.println("STEP : Select year of Experience radio button");
		String yearOfExperience = prop.getProperty("experience");
		if(yearOfExperience.equals("Student")) {
			System.out.println("STEP : Select student radio button");
			driver.findElement(By.xpath("//input[@id='student']")).click();
		}else if(yearOfExperience.equals("1-3")){
			System.out.println("STEP : Select 1-3 radio button");
			driver.findElement(By.xpath("//input[@id='beginner']")).click();
		}else if(yearOfExperience.equals("3-6")) {
			System.out.println("STEP : Select 3-6 radio button");
			driver.findElement(By.xpath("//input[@id='entry']")).click();
		}else if(yearOfExperience.equals("6-10")) {
			System.out.println("STEP : Select 6-10 radio button");
			driver.findElement(By.xpath("//input[@id='intermidiate']")).click();
		}else if(yearOfExperience.equals("Above 10")) {
			System.out.println("STEP : Select Above 10 radio button");
			driver.findElement(By.xpath("//input[@id='expert']")).click();
		}else {
			System.out.println("No Value from Property file");
		}
		System.out.println("STEP : Enter Known languages");
		driver.findElement(By.xpath("//input[@id='knownlanguage']")).sendKeys(prop.getProperty("knowLanguage"));
		System.out.println("STEP : Select Language for Learn");
		String learnLanguage = prop.getProperty("learnLanguage");
		if(learnLanguage.equals("Java")) {
			System.out.println("STEP : Check java is selected or not");
			if(driver.findElement(By.xpath("//input[@id='java']")).isSelected()) {
				System.out.println("Java is selected");
				if(driver.findElement(By.xpath("//input[@id='python']")).isSelected()) {
					System.out.println("Python is selected Please Deselect it");
					driver.findElement(By.xpath("//input[@id='python']")).click();
				}
			}else {
				driver.findElement(By.xpath("//input[@id='java']")).click();
				if(driver.findElement(By.xpath("//input[@id='python']")).isSelected()) {
					System.out.println("Python is selected Please Deselect it");
					driver.findElement(By.xpath("//input[@id='python']")).click();
				}
			}
		}
		
		String dreamCompany = prop.getProperty("dreamCompany");
		if(dreamCompany.equals("Google")) {
			System.out.println("STEP : Select Google as dream company");
			driver.findElement(By.xpath("//input[@id='google']")).click();
		}else if(dreamCompany.equals("ThoughtWorks")) {
			System.out.println("STEP : Select ThoughtWorks as dream company");
			driver.findElement(By.xpath("//input[@id='ThoughtWorks']")).click();
		}else if(dreamCompany.equals("Other")) {
			System.out.println("STEP : Select Other as dream company");
			driver.findElement(By.xpath("//input[@id='other']")).click();
		}
	}
	
	public static void main(String[] args) throws IOException {
		FillFormWithPropertyFile fillFormWithPropertyFile = new FillFormWithPropertyFile();
		fillFormWithPropertyFile.fillForm();
		fillFormWithPropertyFile.driver.close();
	}
}
