package milind.assignment_3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasicElementPageAlertDemo {
	
	WebDriver driver = PredifinedActions.start();
	
	void alertDemoMessageOnRegistrationPage() {
		
		String firstName = "Milind";
		String lastName = "Chavhan";
		String companyName = "TechnoCredits";
		
		System.out.println("STEP : Redirect to Basic Element page");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		System.out.println("STEP : Enter user first name");
		driver.findElement(By.xpath("//input[@name='ufname']")).sendKeys(firstName);
		System.out.println("STEP : Enter user last name");
		driver.findElement(By.xpath("//input[@name='ulname']")).sendKeys(lastName);
		System.out.println("STEP : Enter company name");
		driver.findElement(By.xpath("//input[@name='cmpname']")).sendKeys(companyName);
		System.out.println("STEP : Click submit button");
		driver.findElement(By.xpath("//div[@id='firstRow']/div[1]//button[@type='submit']")).click();
		System.out.println("STEP : Switch to alert message");
		Alert alert = driver.switchTo().alert();
		String actualTextFromAlert = alert.getText();
		if(actualTextFromAlert.contains(firstName) && actualTextFromAlert.contains(lastName) && actualTextFromAlert.contains(companyName)) {
			System.out.println("=====Pass=====");
		}else {
			System.out.println("=====Fail=====");
		}
		alert.accept();
	}
	
	public static void main(String[] args) {
		BasicElementPageAlertDemo basicElementPageAlertDemo = new BasicElementPageAlertDemo();
		basicElementPageAlertDemo.alertDemoMessageOnRegistrationPage();
		basicElementPageAlertDemo.driver.close();
	}

}
