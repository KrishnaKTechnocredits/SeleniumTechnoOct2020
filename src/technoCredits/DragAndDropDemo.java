package technoCredits;

import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import technoCredits.base.PredefinedActions;

public class DragAndDropDemo {

	static WebDriver driver;

	public static void main(String[] args) {
		driver = PredefinedActions.start("https://demos.telerik.com/kendo-ui/dragdrop/index");
		DragAndDropDemo dragAndDropDemo = new DragAndDropDemo();
		dragAndDropDemo.dragAndDrop();
	}

	public void dragAndDrop() {
		WebElement target = driver.findElement(By.id("droptarget"));
		WebElement drag = driver.findElement(By.id("draggable"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");

		Actions action = new Actions(driver);
		action.dragAndDrop(drag, target).build().perform();

	}
}
