package shrutiC.assignment3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertValidation {

	static WebDriver driver;

	static void startWebDriver() {

		String path = "./resources/windows/chromedriver.exe";
		System.out.println("STEP - open chrome browser");
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.automationbykrishna.com");
	}

	void navigateToBasicElements() throws InterruptedException {

		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
	}

	void validateAlertButton() {

		try {
			System.out.println("*******************************************************************");
			System.out.println("Validate Alert button");
			driver.findElement(By.xpath("//button[text()='Alert']")).click();
			Alert alert = driver.switchTo().alert();
			String text = alert.getText();
			alert.accept();
			if (text.equals("You must be TechnoCredits student!!"))
				System.out.println("Alert button validation successful");
			else
				System.out.println(
						"Alert validation failed | Expected msg : You must be TechnoCredits student!! | Actual msg : "
								+ text);
		} catch (Exception e) {
			e.printStackTrace();
			driver.quit();
		}

	}

	void validateJavascriptConfirmButton(String buttonToBeClickedOnAlert) {

		System.out.println("*******************************************************************");
		System.out.println("Validate Confirmation box");

		try {
			driver.findElement(By.id("javascriptConfirmBox")).click();

			// Are you are doing your homework regularly, Press Okay else
			// Cancel!! -
			Alert alert = driver.switchTo().alert();

			if (buttonToBeClickedOnAlert.equalsIgnoreCase("OK")) {
				alert.accept();
				String text = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
				if (text.equals("You pressed OK!"))
					System.out.println("Validation successful, message displayed : " + text);
				else
					System.out.println("Validation failed | Expected msg : You pressed OK! | Actual msg : " + text);

			} else if (buttonToBeClickedOnAlert.equalsIgnoreCase("Cancel")) {
				alert.dismiss();
				String text = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
				if (text.equals("You pressed Cancel!"))
					System.out.println("Validation passed");
				else
					System.out.println("Validation failed | Expected msg : You pressed Cancel! | Actual msg : " + text);

			}
		} catch (Exception e) {
			e.printStackTrace();
			driver.quit();
		}
	}

	void validateJavaPromtButton(String buttonToBeClickedOnAlert, String name) {
		System.out.println("*******************************************************************");
		System.out.println("Validate Javascript promt button");
		try {
			driver.findElement(By.xpath("//button[text()='Javascript Prompt']")).click();
			Alert alert = driver.switchTo().alert();
			String actualText = "";
			String expectedText = "Hello " + name.trim() + "! How are you today?";
			if (buttonToBeClickedOnAlert.equalsIgnoreCase("OK")) {
				alert.sendKeys(name);
				alert.accept();
				actualText = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
				if (actualText.contains(expectedText))
					System.out.println("Validation successful, message displayed : " + actualText);
				else
					System.out.println(
							"Validation failed | Expected msg : " + expectedText + " Actual msg : " + actualText);

			} else if (buttonToBeClickedOnAlert.equalsIgnoreCase("Cancel")) {
				alert.dismiss();
				actualText = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
				if (actualText.equals("User cancelled the prompt."))
					System.out.println("User cancelled the prompt.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			driver.quit();
		}
	}

	public static void main(String[] args) {

		try {
			startWebDriver();
			AlertValidation object = new AlertValidation();
			object.navigateToBasicElements();
			object.validateAlertButton();
			object.validateJavascriptConfirmButton("OK");
			object.validateJavaPromtButton("OK", "Shruti");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}

}
