package suresh;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.PredefinedActions;
 
public class DragAndDropDemo {
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = PredefinedActions.start("https://demos.telerik.com/kendo-ui/dragdrop/index");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		DragAndDropDemo dragandDropDemo = new DragAndDropDemo();
		dragandDropDemo.dragAndDrop();
	}

	public void dragAndDrop() {
		//driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		WebElement target = driver.findElement(By.xpath("//div[@id='droptarget']"));
		WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy (0,300)");
		Actions action = new Actions(driver);
		action.dragAndDrop(drag, target).build().perform();
		driver.quit();

	}
}
