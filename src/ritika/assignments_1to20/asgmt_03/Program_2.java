package ritika.assignments_1to20.asgmt_03;

/*Program - 2: Go to Basic element page,
a) verify alert message on Alert button.
b) verify label message on JavaScript Confirmation button
c) verify label message on JavaScript prompt button*/

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ritika.base.PredefinedActions;

public class Program_2 {

	static void verifyJavaScriptAlert(WebDriver driver) {

		System.out.println("Step4: Click on Alert button");
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
		System.out.println("Step5: Switch to Alert");
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		String expectedAlertMsg = "You must be TechnoCredits student!!";
		if (alertText.equals(expectedAlertMsg))
			System.out.println("Correct Alert text displayed");
		System.out.println("Step6: Accept alert");
		alert.accept();
		System.out.println("Step7: Check if Alert handled?");
		boolean flag = driver.findElement(By.xpath("//button[@id='javascriptAlert']")).isEnabled();
		if (flag)
			System.out.println("Alert handled successfully");
	}

	static void verifyJavaScriptConfirmationBox(WebDriver driver) {

		System.out.println("Step8: Click on Confirmation Alert button");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		System.out.println("Step9: Switch to Alert");
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		String expectedAlertMsg = "Are you are doing your homework regularly, Press Okay else Cancel!!";
		if (alertText.equals(expectedAlertMsg))
			System.out.println("Correct Alert text displayed");
		System.out.println("Step10:Press OK");
		alert.accept();
		System.out.println("Step11: Check if Alert handled?");
		boolean flag = driver.findElement(By.xpath("//p[contains(text(), \"You pressed OK!\")]")).isDisplayed();
		if (flag)
			System.out.println("Alert accepted successfully");
		System.out.println("Step12: Click on Confirmation Alert button");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		System.out.println("Step13: Switch to Alert");
		alert = driver.switchTo().alert();
		alertText = alert.getText();
		if (alertText.equals(expectedAlertMsg))
			System.out.println("Correct Alert text displayed");
		System.out.println("Step14: Press Cancel");
		alert.dismiss();
		System.out.println("Step15: Check if Alert handled?");
		flag = driver.findElement(By.xpath("//p[contains(text(), \"You pressed Cancel!\")]")).isDisplayed();
		if (flag)
			System.out.println("Alert dismissed successfully");
	}

	static void verifyJavaScriptPrompt(WebDriver driver) {

		System.out.println("Step16: Click on Prompt button");
		driver.findElement(By.xpath("//button[@onclick=\"callJavaScriptPrompt()\"]")).click();
		System.out.println("Step17: Switch to Alert");
		Alert alert = driver.switchTo().alert();
		System.out.println("Step18: Verify Alert text");
		String alertText = alert.getText();
		String expectedAlertMsg = "Please enter your name :";
		if (alertText.equals(expectedAlertMsg))
			System.out.println("Correct Alert text displayed");
		alert.sendKeys("Ritika");
		System.out.println("Step19: Name entered");
		System.out.println("Step20: Press OK");
		alert.accept();
		System.out.println("Step21: Check if Alert handled?");
		boolean flag = driver.findElement(By.xpath("//p[contains(text(), \"Hello Ritika! How are you today?\")]")).isDisplayed();
		if (flag)
			System.out.println("Prompt accepted successfully");
		
		System.out.println("Step22: Again Click on Prompt button");
		driver.findElement(By.xpath("//button[@onclick=\"callJavaScriptPrompt()\"]")).click();
		System.out.println("Step23: Switch to Alert");
		alert = driver.switchTo().alert();
		System.out.println("Step24: Press Cancel");
		alert.dismiss();
		System.out.println("Step25: Check if Alert handled?");
		flag = driver.findElement(By.xpath("//p[contains(text(), \"User cancelled the prompt.\")]")).isDisplayed();
		if (flag)
			System.out.println("Prompt cancelled successfully");
	}

	public static void main(String[] args) {

		WebDriver driver = PredefinedActions.start();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		System.out.println("Step1: Click on Basic Elements link");
		driver.findElement(By.id("basicelements")).click(); 
		System.out.println("Step2: Scroll down");
	    WebElement modalElement = driver.findElement(By.xpath("//header[contains(text(),' Different Examples of Alerts ')]"));
	    JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true);", modalElement);
		System.out.println("Step3: Start calling methods");
		verifyJavaScriptAlert(driver);
		verifyJavaScriptConfirmationBox(driver);
		verifyJavaScriptPrompt(driver);

		driver.close();
		System.out.println("Browser closed");
		System.out.println("Test Completed");
	}

}
