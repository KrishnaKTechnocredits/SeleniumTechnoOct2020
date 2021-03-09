/*verify alert message on "Alert demo" form on Basic Elements Page*/

package kajol.assignment3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VerifyAlertDemo {
	static WebDriver driver;
	
	public static void verifyAlertDemoform(String firstName,String lastName,String company) {
		System.out.println("1.Enter First Name");
		driver.findElement(By.id("UserFirstName")).sendKeys(firstName);
		System.out.println("2.Enter Last Name");
		driver.findElement(By.id("UserLastName")).sendKeys(lastName);
		System.out.println("3.Enter Company Name");
		driver.findElement(By.id("UserCompanyName")).sendKeys(company);
		System.out.println("4.Click on Submit Button");
		driver.findElement(By.xpath("//button[@onclick='myFunctionPopUp()']")).click();
		System.out.println("5.Verify Alert Message");
		Alert alert=driver.switchTo().alert();
		if(alert.getText().equals(firstName+" and "+lastName+" and "+company))
			System.out.println("Test Passed....Message Displayed: "+firstName+" and "+lastName+" and "+company);
		else
			System.out.println("Test Failed");
		alert.accept();
	}
	
	public static void main(String[] args) {
		System.out.println("Opening Browser");
		//driver=DriverMethods.start();
		System.out.println("Click on Basic Elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		verifyAlertDemoform("Kajol", "Chhabada", "Atos");
		driver.close();
		System.out.println("Browser Closed");	
	}
}
