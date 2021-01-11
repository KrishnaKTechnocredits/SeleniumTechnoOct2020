package milind.assignment_3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasicElementPageAlertVerify {
	
	WebDriver driver = PredifinedActions.start();
	
	void alertButtonMessageVerify() {
		System.out.println("TC : 1");
		System.out.println("STEP : Redirect to Basic element page");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		System.out.println("STEP : Click on Alert button");
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
		System.out.println("STEP : Switch to alert and Verify message on alert Message");
		Alert alert = driver.switchTo().alert();
		System.out.println("STEP : Get message from alert");
		String alertActualMessage = alert.getText();
		String alertExpectedMessage = "You must be TechnoCredits student!!";
		System.out.println("STEP : Verify alert message");
		if(alertActualMessage.equals(alertExpectedMessage)) {
			System.out.println("=====Pass=====");
		}else {
			System.out.println("=====fail=====");
		}
		System.out.println("Accept alert");
		alert.accept();
	}
	
	void verifyLabelOnAcceptAlert() {
		System.out.println("TC : 2");
		System.out.println("STEP : Click on JavaScript confirmation button");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		System.out.println("Step : Switch to alert");
		Alert alert = driver.switchTo().alert();
		System.out.println("STEP : Accept the Alert");
		alert.accept();
		System.out.println("STEP : Verify label is display");
		driver.findElement(By.xpath("//p[@id='pgraphdemo']")).isDisplayed();
		System.out.println("STEP : get label Message");
		String actualLabelMessage = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		String expectedLabelMessage = "You pressed OK!";
		System.out.println("STEP : Verify Label message");
		if(actualLabelMessage.equals(expectedLabelMessage)) {
			System.out.println("=====Pass=====");
			System.out.println("You Accept alert");
		}else {
			System.out.println("=====Fail=====");
		}
	}
	
	void verifyLabelOnDismiss() {
		System.out.println("TC : 3");
		System.out.println("STEP : Click on JavaScript confirmation button");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		System.out.println("Step : Switch to alert");
		Alert alert = driver.switchTo().alert();
		System.out.println("STEP : Dismiss the Alert");
		alert.dismiss();
		System.out.println("STEP : Verify label is display");
		driver.findElement(By.xpath("//p[@id='pgraphdemo']")).isDisplayed();
		System.out.println("STEP : get label Message");
		String actualLabelMessage = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		String expectedLabelMessage = "You pressed Cancel!";
		System.out.println("STEP : Verify Label message");
		if(actualLabelMessage.equals(expectedLabelMessage)) {
			System.out.println("=====Pass=====");
			System.out.println("You Dismiss alert");
		}else {
			System.out.println("=====Fail=====");
		}
	}
	
	void verifyLabelOnPromptButton_Accept() {
		System.out.println("TC : 4");
		System.out.println("STEP : Click on PromptJavascript prompt");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		System.out.println("STEP : Switch to alert");
		Alert alert = driver.switchTo().alert();
		System.out.println("STEP : Send text in alert text box");
		String messageInAlertTextbox = "Milind";
		alert.sendKeys(messageInAlertTextbox);
		System.out.println("STEP : Accept the alert");
		alert.accept();
		System.out.println("STEP : Check label is present and verify entered test is present in label");
		driver.findElement(By.xpath("//p[@id='pgraphdemo']")).isDisplayed();
		String actualLabelMessage = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		System.out.println("STEP : Verify entered text is present in label message");
		if(actualLabelMessage.contains(messageInAlertTextbox)) {
			System.out.println("=====Pass=====");
			System.out.println("You Accept alert");
		}else {
			System.out.println("=====Fail=====");
		}
	}
	
	void verifyLabelOnPromptButton_Dismiss() {
		System.out.println("TC : 5");
		System.out.println("STEP : Click on PromptJavascript prompt");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		System.out.println("STEP : Switch to alert");
		Alert alert = driver.switchTo().alert();
		System.out.println("STEP : Send text in alert text box");
		String messageInAlertTextbox = "Milind";
		alert.sendKeys(messageInAlertTextbox);
		System.out.println("STEP : Accept the alert");
		alert.dismiss();
		System.out.println("STEP : Check label is present and verify entered test is present in label");
		driver.findElement(By.xpath("//p[@id='pgraphdemo']")).isDisplayed();
		String actualLabelMessage = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		String expectedLabelMessageOnDismiss = "User cancelled the prompt.";
		System.out.println("STEP : Verify entered text is present in label message");
		if(actualLabelMessage.equals(expectedLabelMessageOnDismiss)) {
			System.out.println("=====Pass=====");
			System.out.println("You Dismiss alert");
		}else {
			System.out.println("=====Fail=====");
		}
	}
	
	
	public static void main(String[] args) {
		BasicElementPageAlertVerify basicElementPageAlertVerify = new BasicElementPageAlertVerify();
		basicElementPageAlertVerify.alertButtonMessageVerify();
		basicElementPageAlertVerify.verifyLabelOnAcceptAlert();
		basicElementPageAlertVerify.verifyLabelOnDismiss();
		basicElementPageAlertVerify.verifyLabelOnPromptButton_Accept();
		basicElementPageAlertVerify.verifyLabelOnPromptButton_Dismiss();
		basicElementPageAlertVerify.driver.close();
	}

}
