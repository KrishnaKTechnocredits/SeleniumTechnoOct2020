package suvela.Assignment14;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import suvela.basic.RequiredActions;

public class ExplicitWaitEx {
	static WebDriver driver;
	public void waitTillElementIsClickable() {
		System.out.println("Method 1:-Wait untill Element is clickable..");
		System.out.println("Click on Enable & Disable Button");
		driver.findElement(By.cssSelector("button[onclick='disable()']")).click();
		try {
			System.out.println("Waiting till Element is clickable");
			WebElement e = driver.findElement(By.cssSelector("#myText"));
			WebDriverWait wait = new WebDriverWait(driver,3);
			wait.until(ExpectedConditions.elementToBeClickable(e));
		}catch(TimeoutException ex) {
			System.out.println("Exception "+ex + " is catched");
		}
	}
	public void waitUntilElementIsVisible() {
		System.out.println("Method 2:-Wait untill Element is visible..");
		System.out.println("Click on Visiable & Hidden Button");
		driver.findElement(By.cssSelector("button[onclick='myFunction()']")).click();
		try {
			System.out.println("Waiting till Element is visible");
			WebElement element= driver.findElement(By.cssSelector("div#myDIV"));
			WebDriverWait wait= new WebDriverWait(driver,3);
			wait.until(ExpectedConditions.visibilityOf(element));
		}catch(TimeoutException ex) {
			System.out.println("Exception "+ex + " is catched");
		}
	}
	public static void main(String[] args) {
		driver= RequiredActions.start("file:///F:/Java-Selenium%20course/Suvela-workspace/SeleniumTechnoOct2020/resources/forms/Enable_And_Disable_&_Display_&_Hide_Form.html");
		new ExplicitWaitEx().waitTillElementIsClickable();
		new ExplicitWaitEx().waitUntilElementIsVisible();
	}

}
