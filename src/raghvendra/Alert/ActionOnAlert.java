package raghvendra.Alert;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import raghvendra.base.ConstantAction;
/*Program - 2: Go to Basic element page, 
a) verify alert message on Alert button.
b) verify label message on JavaScript Confirmation button
c) verify label message on JavaScript prompt button
*/
public class ActionOnAlert {
	WebDriver driver=ConstantAction.url();
	void performAlertAction(String msg) {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		System.out.println("Click on Basic Elements:");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		System.out.println("Click on Java Script Alert:");
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
		Alert alert=driver.switchTo().alert();
		String javaScriptAlert=alert.getText();
		System.out.println("Message displayed on Java Script Alert is:"+javaScriptAlert);
		alert.dismiss();
		if(msg.equals(javaScriptAlert))
			System.out.println("Testcase Passed");
		else
			System.out.println("Testcase Failed");
	}
	void javaConfirmationBox(String msg, String oklblMessage,String cancelMsg) {
		//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		System.out.println("Click on Java Confirmation box");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		Alert alert=driver.switchTo().alert();
		alert=driver.switchTo().alert();
		String javaConfirmationBox=alert.getText();
		System.out.println("Message displayed on Java confirmation box is:"+javaConfirmationBox);
		alert.accept();
		if(msg.equals(javaConfirmationBox))
			System.out.println("Testcase Passed");
		else
			System.out.println("Testcase Failed");
		boolean flag=driver.findElement(By.xpath("//p[@id='pgraphdemo']")).isDisplayed();
		String labelText=driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if(flag && labelText.equals(oklblMessage))
			System.out.println("Testcase Passed!"+"\n"+"label displayed after clicking Ok: "+ labelText);
		else
			System.out.println("Label not displayed after clicking Ok");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		alert=driver.switchTo().alert();
		alert.dismiss();
		String cancellabelText=driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if(flag && cancellabelText.equals(cancelMsg))
			System.out.println("Testcase Passed!"+"\n"+"label displayed after clicking cancel: "+ cancellabelText);
		else
			System.out.println("Label not displayed after clicking Ok");
	}
	
	void javaPrompt(String ok, String cancel) {
		System.out.println("Click on Javascript Prompt prompt");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("test");
		alert.accept();
		String okLabel = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if(okLabel.equals(ok))
			System.out.println("Testcase Passed for Ok label");
		else
			System.out.println("Testcase Failed");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		alert.sendKeys("test");
		alert.dismiss();
		String cancelLabel = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if(cancelLabel.equals(cancel))
			System.out.println("Test Passed for Cancel label ");
		else
			System.out.println("Testcase Failed");
	}
	public static void main(String[] args) {
		String msg="You must be TechnoCredits student!!";
		ActionOnAlert actionOnAlert=new ActionOnAlert();
		actionOnAlert.performAlertAction(msg);
		System.out.println("------------------------------------------------------------");
		String msg2="Are you are doing your homework regularly, Press Okay else Cancel!!";
		String okLabelMessage="You pressed OK!";
		String cancelMsg="You pressed Cancel!";
		actionOnAlert.javaConfirmationBox(msg2,okLabelMessage,cancelMsg);
		System.out.println("------------------------------------------------------------");
		String okLabel="Hello test! How are you today?";
		String cancelLabel="User cancelled the prompt.";
		actionOnAlert.javaPrompt(okLabel, cancelLabel);
	}

}
