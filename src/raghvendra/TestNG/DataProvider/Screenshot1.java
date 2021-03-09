package raghvendra.TestNG.DataProvider;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.google.common.io.Files;
import raghvendra.base.ConstantAction;

public class Screenshot1 {
WebDriver driver=ConstantAction.start("http://automationbykrishna.com/#");
	
	@Test(dataProvider="LoginDataProvider")
	void checkDataProvider(String uname, String pwd, String exp) throws IOException {
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
			String[][] data=new String[3][3];
			data[0][0]="raghv";
			data[0][1]="r1234";
			data[0][2]="Failed! please enter strong password";
			data[1][0]="mike";
			data[1][1]="medcqwsa123";
			data[1][2]="Success!";
			data[2][0]="mike";
			data[2][1]="m123";
			data[2][2]="Success!";
			return data;
	}
	
	@AfterMethod
	public void teardown(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE)
			getScreenShot("Fail");
	}
	
	void getScreenShot(String Step) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File srcFile=ts.getScreenshotAs(OutputType.FILE);
		Files.copy(srcFile, new File("C:\\Java Selenium\\Oct22\\SeleniumTechnoOct2020\\Raghv_testData\\Screenshot\\"+Step+".png"));
	}
	
}
