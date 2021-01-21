/*
Assignment - 13 Actions class methods to perform
Program 1-Double Click on (AutomationByKrishna)
 */
package pooja.Assignment_13;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class Assignment_13 {
	static WebDriver driver;

	static void launchBrowser() {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();

		driver.get("http://automationbykrishna.com/");
		System.out.println("Website open successfully.");
		driver.manage().window().maximize();
	}

	static void performDoubleClick() {
		System.out.println("STEP-Finding Basic Elements");
		driver.findElement(By.xpath("//a[text()='Basic Elements']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("STEP-Perform Scrolling");
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollTo(0,document.body.scrollHeight)");

		Actions actions = new Actions(driver);
		System.out.println("STEP-Finding Double Click Element");
		WebElement ele = driver.findElement(By.xpath("//a[@ondblclick='doubleClick()']"));

		System.out.println("STEP-Perform Double Click Action");
		actions.doubleClick(ele).build().perform();
	}

	public static void main(String[] args) {
	Assignment_13.launchBrowser();
		Assignment_13.performDoubleClick();
		System.out.println("STEP-Closing  Browser");
		driver.close();
	}
}