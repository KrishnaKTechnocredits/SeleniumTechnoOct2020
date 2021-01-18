package monika;

/*Assigmnet 3 
Program3
Go to Basic element page - verify alert message on "Alert demo" form.
*/

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public class BasicElement1 {
	
	static WebDriver driver;

	public static WebDriver start() {
		System.out.println("Step : opening browser");
		System.setProperty("webdriver.chrome.driver", "./resources/windows/chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Step : Navigate to automationbykrishna");
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	public static void verifyAlert(String userName, String lastName, String compName) {
		System.out.println("Step : Clicking on Basic Element tab");
		driver.findElement(By.xpath("//a[@id=\"basicelements\"]")).click();

		if (driver.findElement(By.xpath("//header[@class='panel-heading' and text() =' Alert Demo ']")).isDisplayed()) {
			System.out.println("Step : Navigated on Basic Elemennt page");
			System.out.println("Step : Enter FirstName");
			driver.findElement(By.xpath("//input[@name='ufname']")).sendKeys(userName);

			System.out.println("Step : Enter LastName");
			driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys(lastName);

			System.out.println("Step : Enter CompanyName");
			driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys(compName);

			System.out.println("Step : Clicking on Submit");
			driver.findElement(By.xpath("//header[contains(text(),'Alert Demo')]//parent::section//button")).click();
//alert on screen
			Alert alert = driver.switchTo().alert();
			if (alert.getText().equals(userName + " and " + lastName + " and " + compName))
				System.out.println("Test passed");
			else
				System.out.println("Test failed");
			alert.accept();
		} else
			System.out.println("Page not visible");

	}

	public static void main(String[] args) {
		start();
		verifyAlert("Monika", "sethi", "uni");
		driver.close();
	}
}


