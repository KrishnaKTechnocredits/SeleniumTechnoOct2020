package anjaliS;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragDropAndHover {
	static WebDriver driver;

	void dragDrop() {
		
		System.out.println("demos link opened successfully");
     	driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,200)");

		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droptarget"));

		System.out.println("Drag and drop done");
		Actions action = new Actions(driver);
		action.dragAndDrop(drag, target).build().perform();

	}

	public static void main(String[] args) {
		//driver = Driver.start();
		DragDropAndHover dd = new DragDropAndHover();
		dd.dragDrop();
	}
}
