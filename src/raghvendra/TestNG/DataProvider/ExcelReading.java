package raghvendra.TestNG.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import raghvendra.base.ConstantAction;
public class ExcelReading {
WebDriver driver=ConstantAction.start("http://automationbykrishna.com/#");
	
	@Test(dataProvider="LoginDataProvider")
	void checkDataProvider(String uname, String pwd, String exp) {
		driver.findElement(By.cssSelector("a#registration2")).click();
		WebDriverWait wait=new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#unameSignin")));
		driver.findElement(By.cssSelector("#unameSignin")).sendKeys(uname);
		driver.findElement(By.cssSelector("#pwdSignin")).sendKeys(pwd);
		driver.findElement(By.cssSelector("#btnsubmitdetails")).click();
		Alert alert=driver.switchTo().alert();
		String actual=alert.getText();
		alert.accept();
		Assert.assertEquals(exp, actual);
	}

	@DataProvider(name="LoginDataProvider")
	String[][] dataLogin() {
		String[][] data=null;
		try {
			data=Work2.dataLogin1 ("data.xlsx", "Sheet1");
		}
		catch(Exception e) {
			System.out.println("File not present");
		}
		return data;
	}
}
