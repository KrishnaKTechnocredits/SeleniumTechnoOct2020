package nagendra;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import nagendra.base.PredefinedActions;

/*
 Program - 2: Go to Basic element page, 
             a) verify alert message on Alert button.
			 b) verify label message on JavaScript Confirmation button
			 c) verify label message on JavaScript prompt button
*/

public class BasicElementsPageAlert {

	public static void VerifyAlertButtonAlertMessage(WebDriver driver) {
		System.out.println("STEP - Applied implicit wait to driver instance");
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		System.out.println("STEP -Click on Basic Elements  Page ");
		driver.findElement(By.xpath("//a[text()='Basic Elements']")).click();
		WebElement alertButton = driver.findElement(By.xpath("//button[text()='Alert']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", alertButton);
		System.out.println("Click on Alert Button");
		alertButton.click();
		System.out.println("STEP- Switch to Alert on Alert Button");
		Alert alert = driver.switchTo().alert();
		String message = alert.getText();
		System.out.println("Message is" + message);
		System.out.println("STEP-Accept the alert");
		alert.accept();
		String expectedMessage = "You must be TechnoCredits student!!";
		if (message.equals(expectedMessage)) {
			System.out.println("The Alert Message " + message + " Matches");
		} else {
			System.out.println("Both The Messages are different ");
		}
	}

	public static void VerifyJavaScriptConfirmationButtonLabelMessage(WebDriver driver) {
		System.out.println("STEP - Applied implicit wait to driver instance");
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		System.out.println("STEP -Click on Basic Elements  Page ");
		driver.findElement(By.xpath("//a[text()='Basic Elements']")).click();
		WebElement alertButton = driver.findElement(By.xpath("//button[text()='Javascript Confirmation']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", alertButton);
		System.out.println("Click on Alert Button");
		alertButton.click();
		System.out.println("STEP- Switch to Alert on Alert Button");
		Alert alert = driver.switchTo().alert();
		String message = alert.getText();
		System.out.println("Message is" + message);
		System.out.println("STEP-Accept the alert");
		alert.accept();
		WebElement label = driver.findElement(By.xpath("//p[@id='pgraphdemo']"));
		String OkLabelMessage = label.getText();
		String expectedMessage = "You pressed OK!";
		if (OkLabelMessage.equals(expectedMessage)) {
			System.out.println("PASSED- Label Message is Same for Ok");
		} else {
			System.out.println("FAILED- Label Message is different");
		}
		String cancelLabelMessage = "You pressed Cancel!";
		System.out.println("Click on Alert Button");
		alertButton.click();
		System.out.println("STEP- Switch to Alert on Alert Button");
		driver.switchTo().alert();
		System.out.println("STEP-Dismiss the alert");
		alert.dismiss();
		String cancelMessage = label.getText();
		if (cancelMessage.equals(cancelLabelMessage)) {
			System.out.println("PASSED- Label Message is Same For Cancel");
		} else {
			System.out.println("FAILED- Label Message is different");
		}
	}

	public static void VerifyJavaScriptPromptButtonLabelMessage(WebDriver driver) {
		System.out.println("STEP - Applied implicit wait to driver instance");
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		System.out.println("STEP -Click on Basic Elements  Page ");
		driver.findElement(By.xpath("//a[text()='Basic Elements']")).click();
		WebElement alertButton = driver.findElement(By.xpath("//button[text()='Javascript Prompt']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", alertButton);
		System.out.println("Click on Alert Button");
		alertButton.click();
		System.out.println("STEP- Switch to Alert on Alert Button");
		Alert alert = driver.switchTo().alert();
		System.out.println("STEP- Enter Your Name in Input Box");
		alert.sendKeys("Nagendra");
		System.out.println("STEP-Accept the alert");
		alert.accept();
		System.out.println("STEP-Get The Message on Label the alert");
		WebElement label = driver.findElement(By.xpath("//p[@id='pgraphdemo']"));
		String labelMessage = label.getText();
		System.out.println("STEPThe Message on Label is "+labelMessage);
		String expectedMessage = "Hello Nagendra! How are you today?";
		if (labelMessage.equals(expectedMessage)) {
			System.out.println("The Alert Message " + labelMessage + " Matches");
		} else {
			System.out.println("Both The Messages are different ");
		}
	}

	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start();
		VerifyJavaScriptPromptButtonLabelMessage(driver);
		driver.close();
		System.out.println("Browser is Closed");

	}

}
