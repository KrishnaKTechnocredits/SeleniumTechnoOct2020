package ritika.assignments_1to20.asgmt_13;
/*Assignment - 13 : 20th Jan 2021
Actions class methods to perform
1. Drag And Drop on (https://demos.telerik.com/kendo-ui/dragdrop/index)*/
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ritika.base.PredefinedActions;

public class DragAndDrop {

	static WebDriver driver;
	
	static void verifyDragAndDrop() {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)");
		WebElement src = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droptarget"));
		System.out.println("Text before Drag and Drop is -> "+target.getText());
		Actions action = new Actions(driver);
		action.dragAndDrop(src, target).build().perform();
		System.out.println("Text before Drag and Drop is -> "+target.getText());
		System.out.println("Operation successfull");
	}

	public static void main(String[] args) {
		driver = PredefinedActions.start("https://demos.telerik.com/kendo-ui/dragdrop/index");
		verifyDragAndDrop();
		driver.close();
	}
}
