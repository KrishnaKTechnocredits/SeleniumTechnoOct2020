package ritika.assignments_1to20.asgmt_03;

/* Program - 3 : Go to Basic element page,
a) verify alert message on "Alert demo" form.*/

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ritika.base.PredefinedActions;

public class Program_3 {

	static void verifyAlertMsgOnAlertDemoForm(WebDriver driver) {
		System.out.println("Step1: Click on Submit button without entering anything");
		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();
		System.out.println("Step2: Switch to alert window");
		Alert alert = driver.switchTo().alert();
		String expectedText = " and  and ";
		System.out.println("Step3: Verify alert text");
		if((alert.getText()).equals(expectedText))
			System.out.println("Correct msg displayed");
		System.out.println("Step4: Press OK");
		alert.accept();
		System.out.println("Step5: Enter all details in Alert Demo form");
		driver.findElement(By.xpath("//input[@name='ufname']")).sendKeys("Ritika");
		driver.findElement(By.xpath("//input[@name='ulname']")).sendKeys("Gandhi");
		driver.findElement(By.xpath("//input[@name='cmpname']")).sendKeys("TechM");
		System.out.println("Step6: Click on Submit button");
		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();
		System.out.println("Step7: Switch to alert window");
		alert = driver.switchTo().alert();
		expectedText = "Ritika and Gandhi and TechM";
		System.out.println("Step8: Verify alert text");
		if((alert.getText()).equals(expectedText))
			System.out.println("Correct msg displayed");
		alert.dismiss();
	}
	public static void main(String[] args) {
		
		WebDriver driver = PredefinedActions.start();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Basic Elements")).click();
		verifyAlertMsgOnAlertDemoForm(driver);
		driver.close();
		System.out.println("Test Completed");
	}
}
