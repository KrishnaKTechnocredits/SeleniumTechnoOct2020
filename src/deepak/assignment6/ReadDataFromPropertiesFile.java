package deepak.assignment6;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import deepak.methods.UtilityMethods;

public class ReadDataFromPropertiesFile {
	
	
	public static void fillForm(WebDriver driver, Properties prop) {
		
		String firstName = prop.getProperty("FirstName");
		String lastName = prop.getProperty("LastName");
		String emailAddress = prop.getProperty("EmailAddress");
		String companyName = prop.getProperty("CompanyName");
		String gender = prop.getProperty("Gender");
		String livingIn = prop.getProperty("LivingIn");
		String experience = prop.getProperty("ExperienceInIndustory");
		String programmingLanguage = prop.getProperty("ProgrammingLanguage");
		String dreameCompany = prop.getProperty("DreameCompany");
		
		driver.findElement(By.xpath("//input[@id='first name']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@id='last name']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@id='E-mail']")).sendKeys(emailAddress);
		driver.findElement(By.xpath("//input[@id='Company Name']")).sendKeys(companyName);
		
		//Step1: Selecting the Gender
		System.out.println("Step1 : Selecting the Gender");
		if(gender.equalsIgnoreCase("Male")) {
			
			driver.findElement(By.xpath("//input[@id='maleG']")).click();
		}
		else
		{
			driver.findElement(By.xpath("//input[@id='femaleG']")).click();
		}
		
		//Step2: Selecting value from drop-down
		System.out.println("Step2: Selecting value from drop-down");
		WebElement dropDown = driver.findElement(By.xpath("//select[@id='continents']"));
		
		Select obj = new Select(dropDown);
				
		switch(livingIn) {
		
		case "Asia":
			
			obj.selectByVisibleText(livingIn);
			
			break;
		
		case "Europe":
			
			obj.selectByVisibleText(livingIn);
			
			break;
			
		case "Africa":
			
			obj.selectByVisibleText(livingIn);
			
			break;
			
		case "Australia":
			
			obj.selectByVisibleText(livingIn);
			
			break;
			
		case "South America":
			
			obj.selectByVisibleText(livingIn);
			
			break;
			
		case "North America":
			
			obj.selectByVisibleText(livingIn);
			
			break;
			
		case "Antartica":
	
			obj.selectByVisibleText(livingIn);
	
			break;
		}
		
		//Step3: Convert the string experience into integer
		System.out.println("Step3: Convert the string experience into integer");
		
		if(experience.equalsIgnoreCase("Student")) {
			
			driver.findElement(By.xpath("//input[@id='student']")).click();
		}
		
		else {
			
		int yearsOfExp = Integer.parseInt(experience);
		
		if(yearsOfExp >=1 && yearsOfExp <3) {
			driver.findElement(By.xpath("//input[@id='beginner']")).click();			
		}
		else if(yearsOfExp >=3 && yearsOfExp < 6) {
			
			driver.findElement(By.xpath("//input[@id='entry']")).click();
		}
		else if(yearsOfExp >=6 && yearsOfExp < 9) {
			
			driver.findElement(By.xpath("//input[@id='intermidiate']")).click();
		}
		else if(yearsOfExp >= 10) {
			
			driver.findElement(By.xpath("//input[@id='expert']")).click();
		}
		
		}
		
		//Step4: Selecting programming Language
		System.out.println("Step4: Selecting programming Language");
		
		List<WebElement> language = driver.findElements(By.xpath("//input[@name='language']"));
		
		for(WebElement refVar : language) {
			
			if(refVar.isSelected()) {
				refVar.click();
			}
			
		}
		
		
		String intitialVal = "//input[@id='"; 
		String laterVal = "']";
		
		if(programmingLanguage.contains(",")) {
			
			
			
			String[] arr = programmingLanguage.split(",");
			
			for(int i=0; i<arr.length; i++) {
				
				String value = arr[i];
				
				driver.findElement(By.xpath(intitialVal +value + laterVal)).click();
			}
			
			
		}
		else{
			
				driver.findElement(By.xpath(intitialVal + programmingLanguage + laterVal)).click();
			}
		
		//Step5: Selecting Company Name
		System.out.println("Step5: Selecting Company Name");
		
		
		switch(dreameCompany) {
		
		case "Google":
			driver.findElement(By.xpath("//input[@id='google']")).click();
			break;
		
		case "ThoughtWorks":
			driver.findElement(By.xpath("//input[@id='tw']")).click();
			break;
		
		case "Other":
			driver.findElement(By.xpath("//input[@id='other']")).click();
			break;
		
		}
			
		//Step6: Clicking on I selected required options checkbox
		System.out.println("Step6: Clicking on I selected required options checkbox");
		WebElement reqOptionsCheckbox = driver.findElement(By.xpath("//input[@id='confirmDetails']"));
		if(!(reqOptionsCheckbox.isSelected())) {
			
			reqOptionsCheckbox.click();
		}
		else
		{
			System.out.println("I selected required options checkbox is already checked");
		}
		
		String expectedTitle = "Login Signup Demo";
		driver.findElement(By.xpath("//a[text()='Go And Practice For it']")).click();
		String title = driver.getTitle();
		if(title.equalsIgnoreCase(expectedTitle)) {
			
			System.out.println("You are successfully redirected to Automation By Krishan site");
		}
		else {
			System.out.println("You are on wrong page");
		}
		
		//Step7: Verifying the value from History 
		System.out.println("Step7: Verifying the value from History ");
		driver.navigate().back();
		String valAfterBack = driver.findElement(By.xpath("//input[@id='first name']")).getAttribute("value");
		
		if(valAfterBack.equals(firstName)) {
			
			System.out.println("----------Test Pass----------");
		}
		else
			System.out.println("----------Test Fail----------");
		}
				
	public static void main(String[] args) throws IOException {
		
		File src = new File(".\\src\\deepak\\assignment6\\Config.properties");
		
		FileInputStream fis = new FileInputStream(src);
		
		Properties prop = new Properties();
		
		prop.load(fis);
		
		WebDriver driver = UtilityMethods.start("file:///G:/Technocredits/Selenium_Technocredits/SeleniumTechnoOct2020/resources/forms/First_Form_4.html");
		
		fillForm(driver, prop);
		driver.close();
	}

}