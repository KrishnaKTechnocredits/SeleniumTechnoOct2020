package brijesh.assignments.assignment13;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import brijesh.base.Driver;

/*
1. Drag And Drop on (https://demos.telerik.com/kendo-ui/dragdrop/index)
2. Double Click on (AutomationByKrishna)
3. Mouse hover on Amazon(Verify how many links available under Account & Lists)
*/

public class ActionsClass {
	static WebDriver driver = null;

	public static void dragAndDrop() {
		System.out.println("Step: drag and drop element");
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droptarget"));
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
		javascriptExecutor.executeScript("window.scrollBy(2,200)");
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).build().perform();
		if(target.getText().contains("You did great"))
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
	}
	
	public static void doubleClick() throws InterruptedException {
		driver.get("http://automationbykrishna.com/");
		System.out.println("http://automationbykrishna.com/ website open successfully");
		System.out.println("Step: Navigate to Basic Elements link");
		driver.findElement(By.partialLinkText("Basic Elements")).click();
		Thread.sleep(1000);
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
		javascriptExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Actions action = new Actions(driver);
		System.out.println("Step: double click on link");
		WebElement el = driver.findElement(By.xpath("//a[text()='Double-click on me']"));
		action.doubleClick(el).build().perform();
		Alert alert = driver.switchTo().alert();
		if(alert.getText().equals("You successfully double clicked it")) {
			System.out.println("Test Passed");
			alert.accept();
		} else
			System.out.println("Test Failed");
	}

	public static void findLinks() {
		driver.get("https://www.snapdeal.com/");
		System.out.println("https://www.snapdeal.com/ website open successfully");
		System.out.println("Step: Hover on 'All Offers'");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[text()='All Offers']")));
		System.out.println("Step: Count number of links under 'All Offers'");
		System.out.println(driver.findElements(By.cssSelector("#category1Data .linkTest")).size());
	}
	
	public static void main(String[] args) {
		driver = Driver.start("https://demos.telerik.com/kendo-ui/dragdrop/index");
		try {
			System.out.println("Test1: Drag and Drop");
			dragAndDrop();
			System.out.println("\nTest2: Double Click");
			doubleClick();
			System.out.println("\nTest3: Count Links snapdeal");
			findLinks();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Driver.quit(driver);
		}
	}
}
