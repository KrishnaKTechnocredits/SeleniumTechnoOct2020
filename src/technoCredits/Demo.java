package technoCredits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import technoCredits.base.PredefinedActions;

public class Demo {

	@Test
	public void m1() {
		WebDriver driver = PredefinedActions.start();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.MILLISECONDS);
		driver.findElement(By.id("basicelements")).click();
		driver.findElement(By.id("UserFirstName1")).sendKeys("harsh");
	}

}