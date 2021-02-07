package prasad;
/*1. run XML file bat file*/

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class XmlParameters {
	WebDriver driver;
	
	@Parameters({"uName","password"})
	@Test
	void login(String uName , String password) throws InterruptedException {
		System.out.println("Parameter 1 received : User Name:- " + uName);
		System.out.println("Parameter 2 received : Password:- "+password);
		System.out.println("Step 1: Open chrome browser and open URL");
		driver = StaticResources.start();
		System.out.println("Step 2: Click on registration tab");
		driver.findElement(By.linkText("Registration")).click();
		Thread.sleep(2000);
		System.out.println("Step 3: Populate user name and password");
		driver.findElement(By.cssSelector("#unameSignin")).sendKeys(uName);
		driver.findElement(By.cssSelector("#pwdSignin")).sendKeys(password);
		System.out.println("Step 4: Click on submit button");
		driver.findElement(By.cssSelector("#btnsubmitdetails")).click();
		System.out.println("Step 5: Handle pop-up");
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	@AfterMethod
	void tearDown() throws InterruptedException {
		System.out.println("Step 6: Closing browser");
		Thread.sleep(3000);
		driver.close();
	}

}
