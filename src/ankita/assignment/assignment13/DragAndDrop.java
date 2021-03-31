package ankita.assignment.assignment13;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import ankita.base.PredefinedActions;

public class DragAndDrop {

	static WebDriver driver = PredefinedActions.start("https://demos.telerik.com/kendo-ui/dragdrop/index");

	public static void dragDrop() {
		WebElement target = driver.findElement(By.xpath("//div[@id='droptarget']"));
		WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Actions action = new Actions(driver);
		System.out.println("Step : dragging element and dropping");
		action.dragAndDrop(drag, target).build().perform();
	}

	public static void main(String[] args) {
		dragDrop();
		System.out.println("Step : Closing browser");
		driver.close();
	}
}
