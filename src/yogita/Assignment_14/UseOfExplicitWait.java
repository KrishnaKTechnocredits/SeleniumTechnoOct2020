/*
 * Assignment 14

Form: Enable_And_Disable_Display_Hide_Form

Script 1: check element's clickability using explicit wait 
Script 2: check element's visibility using explicit wait

 */

package yogita.Assignment_14;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UseOfExplicitWait {
	static WebDriver driver;

	static void launchBrowser() {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		System.out.println("STEP-Go to Page");
		driver.get(
				"file:///E:/java%20program/SeleniumTechnoOct2020/resources/forms/Enable_And_Disable_&_Display_&_Hide_Form.html");
		driver.manage().window().maximize();

	}

	static void checkClickability() {
		System.out.println("STEP-Finding Enable & Disable Button");
		driver.findElement(By.xpath("//input[@id='myText']//following-sibling::button[1]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 4);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='myText']")));

		} catch (TimeoutException te) {
			System.out.println("Msg:TextField Element is Disabled");
		}

	}

	static void checkVisibility() {
		System.out.println("STEP-Finding  Visiable & Hidden Button");
		driver.findElement(By.xpath("//button[text()='Visiable & Hidden Button']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 4);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='myDIV']")));
		} catch (TimeoutException te) {
			System.out.println("Msg:TechnoCredits Element is Hidden");
		}

	}

	public static void main(String[] args) {
		UseOfExplicitWait.launchBrowser();
		UseOfExplicitWait.checkClickability();
		UseOfExplicitWait.checkVisibility();
		driver.close();
	}
}
