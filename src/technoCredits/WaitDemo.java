package technoCredits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import technoCredits.base.PredefinedActions;

public class WaitDemo {

	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start(
				"file:///D:/TechnoCredits/Batches/Oct2020/Projects/SeleniumTechnoOct2020/resources/forms/Enable_And_Disable_%26_Display_%26_Hide_Form.html");

		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();

		//driver.findElement(By.id("myDIVz"));

		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myTextd")));
	}
}
