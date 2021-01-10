package technoCredits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import technoCredits.base.PredefinedActions;

public class ImplicitWaitDemo {
	static WebDriver driver;
	
	void verifyAlertMessage(String uname, String pwd, String expectedMessage){
		driver.manage().timeouts().implicitlyWait(900, TimeUnit.MILLISECONDS);
		driver.findElement(By.linkText("Registration")).click(); 
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		
		Alert alert = driver.switchTo().alert();
		String actualMessage = alert.getText();
		if(actualMessage.equals(expectedMessage)) {
			System.out.println("Alert message is displayed correctly");
		}
		
		alert.accept();
		
	}
	
	public static void main(String[] args) {
		driver = PredefinedActions.start();
		new ImplicitWaitDemo().verifyAlertMessage("mkanani","mkanani1234","Success!");
	}
}
