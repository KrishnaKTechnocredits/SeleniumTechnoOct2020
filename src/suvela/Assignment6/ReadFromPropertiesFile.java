/*Assignment - 6 : 13th Jan'2020 
Program 1 : a) fillup the form "First_Form_4" by taking data from properties file
            b) click on "Go and Practice", validate user should navigate to AutomationBykrishna.com
            c) go back in the history, verify firstname field contains the same value which is provided from properties file.*/
package suvela.Assignment6;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import technoCredits.base.PredefinedActions;

public class ReadFromPropertiesFile {
	public void readPropertyFile(WebDriver driver) throws Exception {
		System.out.println("Read from property file");
		
		File file = new File("./src/suvela/config/configData.properties");
		FileInputStream inputstream= new FileInputStream(file);
		
		Properties prop= new Properties();
		prop.load(inputstream);
		
		String fname=prop.getProperty("firstname");
		String lname=prop.getProperty("lastname");
		String email=prop.getProperty("email");
		String company=prop.getProperty("company");
		String lang=prop.getProperty("langugage");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Enter name in firstName");
		driver.findElement(By.xpath("//input[@id='first name']")).sendKeys(fname);
		System.out.println("Enter name in lastName");
		driver.findElement(By.xpath("//input[@id='last name']")).sendKeys(lname);
		System.out.println("Enter email id");
		driver.findElement(By.xpath("//input[@id='E-mail']")).sendKeys(email);
		System.out.println("Enter compnay name");
		driver.findElement(By.xpath("//input[@id='Company Name']")).sendKeys(company);
		System.out.println("Enter language you know");
		driver.findElement(By.xpath("//input[@id='knownlanguage']")).sendKeys(lang);
		
		System.out.println("Form has been filled by taking data from properties file");
		System.out.println("Now click on Go and Practice, validate user should navigate to AutomationBykrishna.com");
		driver.findElement(By.xpath("//button[@id='morePractice']")).click();
		String actualurl="http://automationbykrishna.com/";
		String expectedurl=driver.getCurrentUrl();
		if(expectedurl.equals(actualurl))
			System.out.println("User has been navigated to AutomationBykrishna.com");
		else
			System.out.println("User has been navigated to somewhere else");
		
		System.out.println("Go back and verify firstname field contains the same value which is provided from properties file");
		driver.navigate().back();
		String bexpectname=driver.findElement(By.xpath("//input[@id='first name']")).getAttribute("value");
		if(bexpectname.equals(fname))
			System.out.println("Verified! Firstname field contains the same value which is provided from properties file ");
		else
			System.out.println("Not Verified! Firstname field does not contain the same value which is provided from properties file ");
		driver.close();
	}
	public static void main(String[] args) {
		WebDriver driver= PredefinedActions.start("file:///F:/Java-Selenium%20course/Suvela-workspace/SeleniumTechnoOct2020/resources/forms/First_Form_4.html");
		try{
			new ReadFromPropertiesFile().readPropertyFile(driver);
		}catch(Exception e) {
		System.out.println("Exception occured");
	}

	}
}
