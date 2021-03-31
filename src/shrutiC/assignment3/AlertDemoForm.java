package shrutiC.assignment3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemoForm {

	static WebDriver driver;

	static void startWebDriver() {

		String path = "./resources/windows/chromedriver.exe";
		System.out.println("Open chrome browser");
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.automationbykrishna.com");
	}

	void enterCandiateDetails(String username, String lastname, String company) {

		try {

			WebElement basicElementTag = driver.findElement(By.xpath("//a[@id='basicelements']"));
			if (basicElementTag.isDisplayed())
				basicElementTag.click();
			Thread.sleep(2000);
			System.out.println("Enter User Details");
			driver.findElement(By.xpath("//input[@name='ufname']")).sendKeys(username);
			driver.findElement(By.xpath("//input[@name='ulname']")).sendKeys(lastname);
			driver.findElement(By.xpath("//input[@name='cmpname']")).sendKeys(company);
			driver.findElement(By.xpath("//input[@name='cmpname']//following::button[1]")).click();

			System.out.println("Switch to Alert");
			String expectedText = username + " and " + lastname + " and " + company;
			Alert alert = driver.switchTo().alert();
			String actualText = alert.getText();
			alert.accept();
			if (actualText.equals(expectedText))
				System.out.println("Alert form validation successful, message : " + actualText);
			else
				System.out.println("Alert form validation failed | Actual msg : " + actualText + "| Expected msg : "
						+ expectedText);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			driver.quit();
		}

	}

	public static void main(String[] args) {

		startWebDriver();
		new AlertDemoForm().enterCandiateDetails("Shruti", "Kaustubh", "Accenture");

	}

}
