package prasad;

/*Program - 2: Go to Basic element page,
a) verify alert message on Alert button.
b) verify label message on JavaScript Confirmation button
c) verify label message on JavaScript prompt button*/

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasicElements {
	String expectedMsg = "You must be TechnoCredits student!!";
	int count;

	void basicElements(WebDriver driver) {
		System.out.println("Step: Validating alert button message");
		System.out.println("Navigating to basic elements tab");
		driver.findElement(By.xpath("//a[text()= 'Basic Elements']")).click();
		System.out.println("Clicking on alert button");
		driver.findElement(By.xpath("//button[text()='Alert']")).click();

		Alert alert = driver.switchTo().alert();
		String actualMsg = alert.getText();
		if (actualMsg.equals(expectedMsg)) {
			System.out.println("Passed: Expected message is displayed");
			count++;
		} else
			System.out.println("Failed: Expected message is NOT displayed");

		alert.accept();

		System.out.println("");
		System.out.println("Step: Validating accept label message on JavaScript Confirmation button");
		System.out.println("Clicking on JavaScript Confirmation button");
		driver.findElement(By.xpath("//button[text()='Javascript Confirmation']")).click();
		System.out.println("Clicking OK button on alert");
		alert.accept();
		String msg = driver.findElement(By.xpath("//p[@id= 'pgraphdemo']")).getText();
		if (msg.contains("OK")) {
			System.out.println("Passed: Message contains OK, message:- " + msg);
			count++;
		} else
			System.out.println("Failed: Message does NOT contain OK, message:- " + msg);

		System.out.println("");
		System.out.println("Step: Validating cancel label message on JavaScript Confirmation button");
		System.out.println("Clicking on JavaScript Confirmation button");
		driver.findElement(By.xpath("//button[text()='Javascript Confirmation']")).click();
		System.out.println("Clicking Cancel button on alert");
		alert.dismiss();
		msg = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if (msg.contains("Cancel")) {
			System.out.println("Passed: Message contains Cancel, message:- " + msg);
			count++;
		} else
			System.out.println("Failed: Message does NOT contain Cancel, message:- " + msg);

		System.out.println("");
		System.out.println("Step: Validating label message on JavaScript prompt button");
		System.out.println("Clicking on JavaScript prompt button");
		driver.findElement(By.xpath("//button[text()='Javascript Prompt']")).click();
		System.out.println("Entering name in alert text box");
		alert.sendKeys("Prasad");
		System.out.println("Clicking OK button on alert");
		alert.accept();
		msg = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if (msg.contains("Prasad")) {
			System.out.println("Passed: Message contains name, message:- " + msg);
			count++;
		} else
			System.out.println("Failed: Message does NOT contain name, message:- " + msg);

		if (count == 4) {
			System.out.println("");
			System.out.println("Overall test outcome:- Passed");
		} else {
			System.out.println("");
			System.out.println("Overall test outcome:- Failed");
		}
		
		driver.quit();
	}

	public static void main(String[] arg) {
		BasicElements elements = new BasicElements();
		System.out.println("Opening chrome browser and accessing URL");
		WebDriver driver = StaticResources.start();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		elements.basicElements(driver);
	}
}
