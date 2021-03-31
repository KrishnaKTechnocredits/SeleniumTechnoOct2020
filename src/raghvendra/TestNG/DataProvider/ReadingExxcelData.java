package raghvendra.TestNG.DataProvider;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
import raghvendra.base.ConstantAction;

public class ReadingExxcelData {
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
			String[][] data=new String[2][3];
			data[0][0]="raghv";
			data[0][1]="r1234";
			data[0][2]="Failed! please enter strong password";
			data[1][0]="mike";
			data[1][1]="medcqwsa123";
			data[1][2]="Success!";
			return data;
	}
}
