package prasad;
/*Program - 1 : Verify alert message on Registration Page -> login.*/

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Registration {
	String errorMsg = "Failed! please enter strong password";
	String successMsg = "Success!";
	String userName = "pchitale";
	String password = "Test12";
	int count;

	public void navigateToReg(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//a[@id='registration2']")).click();

		System.out.println("Step 3: Enter login credentials");
		System.out.println("Enter user name");
		driver.findElement(By.xpath("//input[@id = 'unameSignin']")).sendKeys(userName);
		System.out.println("Enter password with length less than 8 chars");
		driver.findElement(By.xpath("//input[@id = 'pwdSignin']")).sendKeys(password);
		System.out.println("Step 4: Click on submit button");
		driver.findElement(By.xpath("//button[@id = 'btnsubmitdetails']")).click();

		System.out.println("Switching context to the alert");
		Alert alert = driver.switchTo().alert();
		String msg = alert.getText();
		if (msg.equals(errorMsg)) {
			count++;
			System.out.println("Validation Passed: Correct error message is displayed");
		} else
			System.out.println("Validation Failed: Incorrect error message is displayed");

		alert.accept();
		userName = "prasad.chitale";
		password = "correctPassword";

		System.out.println("Step 5: Clearing user name field value and entring new value");
		driver.findElement(By.xpath("//input[@id = 'unameSignin']")).clear();
		driver.findElement(By.xpath("//input[@id = 'unameSignin']")).sendKeys(userName);

		System.out.println("Step 6: Clearing password field value and entring new value");
		driver.findElement(By.xpath("//input[@id = 'pwdSignin']")).clear();
		driver.findElement(By.xpath("//input[@id = 'pwdSignin']")).sendKeys(password);

		System.out.println("Step 7: Click on submit button");
		driver.findElement(By.xpath("//button[@id = 'btnsubmitdetails']")).click();

		msg = alert.getText();
		if (msg.equals(successMsg)) {
			count++;
			System.out.println("Validation Passed: Correct success message is displayed");
		} else
			System.out.println("Validation Passed: Correct success message is displayed");

		System.out.println("Clicking on Ok button");
		alert.accept();

		if (count == 2) {
			System.out.println("Overall test outcome: Passed");
		} else
			System.out.println("Overall test outcome: Failed");

		driver.quit();

	}

	public static void main(String[] arg) throws InterruptedException {
		Registration reg = new Registration();
		System.out.println("Step 1: Launching chrome browser and accessing URL");
		WebDriver driver = StaticResources.start();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		String tabName = driver.getTitle();
		if (tabName.equals("Login Signup Demo"))
			System.out.println("User navigated to page " + "successfully");
		else
			System.out.println("Webpage not accessed");
		System.out.println("Step 2: Navigate to Registration Tab");
		reg.navigateToReg(driver);
	}

}
