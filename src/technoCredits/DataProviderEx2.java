package technoCredits;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import technoCredits.base.PredefinedActions;
import technoCredits.util.ExcelOperation;

public class DataProviderEx2 {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = PredefinedActions.start();
	}
	
	@Test(dataProvider="LoginDataProvider")
	public void loginTest(String username, String password, String expectedMessage) throws InterruptedException {
		
		driver.findElement(By.xpath("//a[text()='Registration']")).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//input[@id='unameSignin']"));
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

		Alert alert = driver.switchTo().alert();
		String actualMessage = alert.getText();
		alert.accept();
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	@DataProvider(name="LoginDataProvider")
	public String[][] dataProvider() {
		String[][] data = null;
		try {
			data = ExcelOperation.getExcelData("Demo.xlsx", "Data");
		} catch (IOException e) {
			System.out.println("Demo file was not present on given location");
		}
		return data;
	}
}
