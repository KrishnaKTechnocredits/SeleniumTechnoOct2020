package nagendra;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import nagendra.base.PredefinedActions;

/*
1. Drag And Drop on (https://demos.telerik.com/kendo-ui/dragdrop/index)
*/

public class ActionsClass {

	static WebDriver driver;
	
	public static void dragAndDrop(){
		WebElement sourceLocation=driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement TargetLocation=driver.findElement(By.xpath("//div[@id='droptarget']"));
		System.out.println("STEP - Initialize Actions Class");
		Actions action=new Actions(driver);
		System.out.println("STEP - Scroll to till element in page");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)", sourceLocation);
		System.out.println("STEP - Perform Drag and Drop Operation");
		action.dragAndDrop(sourceLocation, TargetLocation).build().perform();

	}

	public static void main(String[] args) {
		System.out.println("STEP - Initialize WebDriver ");
		driver = PredefinedActions.start("https://demos.telerik.com/kendo-ui/dragdrop/index");
		dragAndDrop();
		System.out.println("STEP - Close The Driver");
		driver.close();
		System.out.println("STEP - Test Case Passed!!");
	}

}
