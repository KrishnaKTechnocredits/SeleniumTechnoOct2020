package technoCredits;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import technoCredits.base.PredefinedActions;

public class ScreenShotDemo {
	WebDriver driver;
	int count = 1;
	
	@Test
	public void firstTest() throws IOException {
		driver = PredefinedActions.start("https://www.facebook.com/");
		driver.findElement(By.cssSelector("#email")).sendKeys("maulik_it232@yahoo.com");
		boolean loginbtnEnabledFlag = driver.findElement(By.cssSelector("button[name='login']")).isEnabled();
		Assert.assertFalse(loginbtnEnabledFlag);
	}
	
	@AfterMethod
	public void teardown(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.FAILURE)
			getScreenShot(result.getName());
		driver.close();
	}
	
	void getScreenShot(String filename) throws IOException{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		Files.copy(srcFile, new File("./screenshot/"+filename+".png"));
		count++;
	}
}
