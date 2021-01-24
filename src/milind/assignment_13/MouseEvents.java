package milind.assignment_13;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseEvents {
	
	WebDriver driver;
	
	void dragAndDrop() {
		driver = PredefinedConditions.start("https://demos.telerik.com/kendo-ui/dragdrop/index");
		System.out.println("STEP : Scroll the window");
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("window.scrollBy(0,250)");
		System.out.println("STEP : Get Source and tagert");
		WebElement sourceElement = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@id='droptarget']"));
		System.out.println("STEP : Perform Drag and drop");
		Actions actions = new Actions(driver);
		actions.dragAndDrop(sourceElement, targetElement).build().perform();
		if(targetElement.getText().equals("You did great!")) {
			System.out.println("=====Pass=====");
			System.out.println("Success!! Drag and Drop");
		}else {
			System.out.println("=====Fail=====");
			System.out.println("Sorry, Please try again Drag and drop");
		}
	}
	
	void doubleClick() throws InterruptedException {
		driver = PredefinedConditions.start("http://automationbykrishna.com/");
		System.out.println("STEP : Redirect to basic element");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click(); 
		Thread.sleep(2000);
		System.out.println("STEP : Scroll to bottom");
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		System.out.println("STEP : Double click on element");
		Actions actions = new Actions(driver);
		actions.doubleClick(driver.findElement(By.xpath("//a[text()='Double-click on me']"))).build().perform();
		System.out.println("STEP : Verify alert is present after double click");
		Alert alert = driver.switchTo().alert();
		if(alert.getText().equals("You successfully double clicked it")) {
			System.out.println("=====Pass=====");
			System.out.println("Success!! Double click");
			alert.accept();
		}else {
			System.out.println("=====Fail=====");
			System.out.println("Fail, Double click is not working");
		}
	}
	
	void mouseHover() throws InterruptedException {
		driver = PredefinedConditions.start("https://www.amazon.in/");
		System.out.println("STEP : Mouse hover on User name");
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).build().perform();
		if(driver.findElement(By.xpath("//div[@id='nav-al-container']")).isDisplayed()) {
			int linkcount = driver.findElements(By.xpath("//div[@id='nav-al-container']//a")).size();
			System.out.println("Total links : "+linkcount);
		}else {
			System.out.println("Mouse hover is not working");
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		MouseEvents mouseEvents = new MouseEvents();
		mouseEvents.dragAndDrop();
		mouseEvents.driver.close();
		mouseEvents.doubleClick();
		mouseEvents.driver.close();
		mouseEvents.mouseHover();
		mouseEvents.driver.close();
	}
}
